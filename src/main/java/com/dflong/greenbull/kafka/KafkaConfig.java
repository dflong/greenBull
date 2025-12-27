package com.dflong.greenbull.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.RoundRobinPartitioner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.transaction.KafkaTransactionManager;

import java.util.*;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaConfig {

//    @Bean
//    @Primary
//    public DefaultErrorHandler  kafkaErrorHandler(KafkaTemplate<?, ?> template) {
//        // <1> 创建 DeadLetterPublishingRecoverer 对象
//        ConsumerRecordRecoverer recoverer = new DeadLetterPublishingRecoverer(template);
//        // <2> 创建 FixedBackOff 对象   设置重试间隔 10秒 次数为 3次
//        BackOff backOff = new FixedBackOff(10 * 1000L, 3L);
//        // <3> 创建 SeekToCurrentErrorHandler 对象
//        return new SeekToCurrentErrorHandler(recoverer, backOff);
//    }
    @Bean
    public NewTopic newTopic() {
        Map<Integer, List<Integer>> replicasAssignments; // 可以指定分区、副本存放位置
        return new NewTopic(KafkaConstant.TOPIC, KafkaConstant.NUM_PARTITIONS, KafkaConstant.REPLICATION_FACTOR);
    }

    @Bean
    public NewTopic deadLetterTopic() {
        return new NewTopic(KafkaConstant.DEAD_LETTER_TOPIC, 1, (short) 1);
    }

    @Value("${spring.kafka.bootstrap-servers}")
    String bootstrapServers;

    @Value("${spring.kafka.producer.acks}")
    String ackConfigs;

    @Value("${spring.kafka.producer.retries}")
    int retryConfigs;

    @Value("${spring.kafka.producer.batch-size}")
    int batchSizeConfigs;

    @Value("${spring.kafka.producer.buffer-memory}")
    int bufferMemoryConfigs;

    @Value("${spring.kafka.producer.retries}")
    int retryConfig;

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
        configProps.put(VALUE_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
        configProps.put(ACKS_CONFIG, ackConfigs);
        configProps.put(RETRIES_CONFIG, retryConfigs);
        configProps.put(ENABLE_IDEMPOTENCE_CONFIG, true); // 默认开启幂等性, ack必须-1,retry>0,MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION<=5
        configProps.put(BATCH_SIZE_CONFIG, batchSizeConfigs);
        configProps.put(BUFFER_MEMORY_CONFIG, bufferMemoryConfigs);
//        configProps.put(PARTITIONER_CLASS_CONFIG, RoundRobinPartitioner.class);
        DefaultKafkaProducerFactory<String, String> factory =
                new DefaultKafkaProducerFactory<>(configProps);
        return factory;
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    /**
     * 配置事务Kafka模板
     *
     * @return 事务Kafka模板
     */
    @Bean
    public KafkaTemplate<String, String> transactionalKafkaTemplate() {
        return new KafkaTemplate<>(transactionalProducerFactory());
    }

    /**
     * 配置Kafka事务管理器
     *
     * @return Kafka事务管理器
     */
    @Bean
    public KafkaTransactionManager<String, String> kafkaTransactionManager() {
        return new KafkaTransactionManager<>(transactionalProducerFactory());
    }

    /**
     * 配置事务生产者工厂
     *
     * @return 事务生产者工厂
     */
    @Bean
    public ProducerFactory<String, String> transactionalProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
        configProps.put(VALUE_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
        configProps.put(ACKS_CONFIG, ackConfigs);
        configProps.put(RETRIES_CONFIG, retryConfigs);
        configProps.put(BATCH_SIZE_CONFIG, batchSizeConfigs);
        configProps.put(BUFFER_MEMORY_CONFIG, bufferMemoryConfigs);
//        configProps.put(PARTITIONER_CLASS_CONFIG, RoundRobinPartitioner.class);
        // 配置事务ID前缀
        configProps.put(TRANSACTIONAL_ID_CONFIG, KafkaConstant.TRANSACTION_ID_PREFIX);

        DefaultKafkaProducerFactory<String, String> factory =
                new DefaultKafkaProducerFactory<>(configProps);
        // 开启事务支持
        factory.transactionCapable();
        return factory;
    }

}
