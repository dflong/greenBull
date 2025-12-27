package com.dflong.greenbull.kafka;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.ExecutionException;

@Component
public class EventProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, String> transactionalKafkaTemplate;

    // 默认幂等性
    public void send(String topic, String key, String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic,  key, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("消息发送成功： " + result.getRecordMetadata().toString());
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("消息发送失败： ");
                // 默认开启幂等性，会自动重试
            }
        });
    }

    // 使用事务
    public void sendWithTransaction(String topic, String key, String message) {
        transactionalKafkaTemplate.executeInTransaction(kafkaOperations -> {
            SendResult<String, String> result = null;
            try {
                // 发送消息
                result = kafkaOperations.send(topic, key, message).get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

            return result;
        });

    }
}
