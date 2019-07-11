package rokcetmq.demo.config;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class TestConsumer extends ConsumerConfigure implements ApplicationListener<ContextRefreshedEvent> {

	static int num = 0;
	@Override
	protected ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs) {
		// TODO Auto-generated method stub
		// int num = 1;
        log.info("进入");
        for(MessageExt msg : msgs) {
            log.info("第" + num + "次消息");
            try {
            	log.info(msg.getKeys());
                String msgStr = new String(msg.getBody(), "utf-8");
                log.info(msgStr);
                num++;
            } catch (UnsupportedEncodingException e) {
                log.error("body转字符串解析失败");
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		try {
            super.listener("TopicTest", "Tag1");
        } catch (MQClientException e) {
            log.error("消费者监听器启动失败", e);
        }
		
	}

}
