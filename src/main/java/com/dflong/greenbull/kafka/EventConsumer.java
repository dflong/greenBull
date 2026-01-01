package com.dflong.greenbull.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class EventConsumer {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @KafkaListener(id = "greenBull-grouper-consumer", topics = KafkaConstant.TOPIC, groupId = KafkaConstant.GROUP_ID)
    public void receive(List<ConsumerRecord<String, String>> records,
                        Acknowledgment ack
//                        @Header("kafka_receivedTopic") String topic,
//                        @Header("kafka_receivedPartitionId") int partition,
//                        @Header(KafkaHeaders.OFFSET) long offset
    ) {
        logger.info("receive records num: " + records.size());
        for (ConsumerRecord<String, String> record : records) {
            try {
                logger.info("kafka消费者监听消息： 订单号: " + record.key() + ", 订单信息: " + record.value());
            } catch (Exception e) {
                // 如果失败，写入数据库重试或者发送到另一个retry topic
            } finally {
                // 手动ack, 通知kafka已经消费
                ack.acknowledge();
            }
        }
    }

}
