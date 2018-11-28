package com.yjt.basic.message.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

/**
 * @Description "TODO"
 * @Author :ym
 * @Date: 2018/11/26 17:09
 **/
@Component
public class KafkaProducer{

    private Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;


    public void sendMsg(String topic,String msg,SuccessCallback successCallback,FailureCallback failureCallback){
        ListenableFuture<SendResult<String, String>> listenableFuture  =  kafkaTemplate.send(topic,msg);
        listenableFuture.addCallback(successCallback,failureCallback);
    }

    public void sendMsg(String topic,String msg){
        ListenableFuture<SendResult<String, String>> listenableFuture  =  kafkaTemplate.send(topic,msg);
    }

}