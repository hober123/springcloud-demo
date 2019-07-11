package rokcetmq.demo.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ProducerConfigure {

	@Autowired
	ProducerConfig prodCfg;
	
	/**
	 * 创建普通消息发送实例
	 * 
	 * @return
	 * @throws MQClientException
	 */
	@Bean
	@ConditionalOnProperty(prefix = "rocketmq.producer", value = "default", havingValue = "true")
	public DefaultMQProducer defaultProducer() throws MQClientException {
        log.info(prodCfg.toString());
        log.info("defaultProducer 正在创建---------------------------------------");
        DefaultMQProducer producer = new DefaultMQProducer(prodCfg.getGroupName());
        producer.setNamesrvAddr(prodCfg.getNameSrvAddr());
        producer.setVipChannelEnabled(false);
        producer.setRetryTimesWhenSendAsyncFailed(10);
        producer.start();
        log.info("rocketmq producer server开启成功---------------------------------.");
        return producer;
    }
}
