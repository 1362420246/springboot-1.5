package com.qbk.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: quboka
 * @Date: 2018/11/21 15:31
 * @Description: 消费者
 */
@Component
public class MsgConsumer {

    @KafkaListener(topics = {"quboka","kafka_log"})
    public void processMessage(String content) {
        System.out.println("接收结果："+content);
    }




}