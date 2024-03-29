package rokcetmq.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ConfigurationProperties(prefix = "rocketmq.producer")
@Configuration
@ToString
public class ProducerConfig {

	private String nameSrvAddr;
	private String groupName;
}
