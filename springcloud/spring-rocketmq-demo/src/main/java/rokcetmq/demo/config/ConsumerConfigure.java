package rokcetmq.demo.config;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public abstract class ConsumerConfigure {

	@Autowired
	private ConsumerConfig consumerCfg;

	// 开启消费者监听服务
	public void listener(String topic, String tag) throws MQClientException {
		log.info("开启" + topic + ":" + tag + "消费者-------------------");
		log.info(consumerCfg.toString());

		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerCfg.getGroupName());

		consumer.setNamesrvAddr(consumerCfg.getNameSrvAddr());

		consumer.subscribe(topic, tag);

		// 开启内部类实现监听
		consumer.registerMessageListener(new MessageListenerConcurrently() {
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				return ConsumerConfigure.this.dealBody(msgs);
			}
		});

		consumer.start();

		log.info("rocketmq consumer 启动成功---------------------------------------");

	}

	// 处理body业务
	protected abstract ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs);
}
