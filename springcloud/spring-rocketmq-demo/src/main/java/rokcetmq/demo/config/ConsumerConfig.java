package rokcetmq.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "rocketmq.consumer")
@Configuration
public class ConsumerConfig {
	private String nameSrvAddr;
	private String groupName;
	

}
