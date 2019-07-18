package org.zipkinServer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class Consumer {
	
	@KafkaListener(topics={"${zipkin.collector.kafka.topic}"})
    public void receive(@Payload String message, @Headers MessageHeaders headers){
        log.info("zipkin-Consumer 接收到消息："+message);
        headers.keySet().forEach(key->log.info("{}: {}",key,headers.get(key)));
    }

}
