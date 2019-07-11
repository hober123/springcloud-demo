package kafka.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaMessageConsumer {
	
	@KafkaListener(topics={"${kafka.topic.foo}"})
    public void receive(@Payload String message, @Headers MessageHeaders headers){
        log.info("KafkaMessageConsumer 接收到消息："+message);
        headers.keySet().forEach(key->log.info("{}: {}",key,headers.get(key)));
    }

}
