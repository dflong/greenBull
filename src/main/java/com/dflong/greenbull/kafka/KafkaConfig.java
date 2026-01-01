package com.dflong.greenbull.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic newTopic() {
        Map<Integer, List<Integer>> replicasAssignments; // 可以指定分区、副本存放位置
        return new NewTopic(KafkaConstant.TOPIC, KafkaConstant.NUM_PARTITIONS, KafkaConstant.REPLICATION_FACTOR);
    }

    @Bean
    public NewTopic deadLetterTopic() {
        return new NewTopic(KafkaConstant.DEAD_LETTER_TOPIC, 1, (short) 1);
    }


}
