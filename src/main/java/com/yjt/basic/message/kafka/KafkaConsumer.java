package com.yjt.basic.message.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Description "TODO"
 * @Author :ym
 * @Date: 2018/11/26 17:09
 **/
@Component
public class KafkaConsumer {

    private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = {"testdemo"})
    public void receive(String message){
        System.out.println("--消费消息:" + message);
    }

}