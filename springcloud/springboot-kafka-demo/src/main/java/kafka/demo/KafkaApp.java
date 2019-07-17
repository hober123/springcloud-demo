package kafka.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kafka.demo.kafka.KafkaMessageProducer;

/**
 * kafka 示例
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
@RestController
public class KafkaApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(KafkaApp.class, args);
    }
    
    @Autowired
    KafkaMessageProducer msgProd;
    
    @GetMapping("/test")
    public void test() {
    	
    	msgProd.send();
    }
}
