package demo.eureka.com.eu;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.context.annotation.Configuration;


/**
 * Service Demo 1!
 *
 */
@Api("启动页")
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@RestController
public class ProviderApp {
	
	public static void main(String[] args) {
		SpringApplication.run(ProviderApp.class, args);
	}

	@Value("${server.port}")
	String port;
    
	@ApiOperation(value = "启动页-hello" ,  notes="启动页")
	@RequestMapping("/hello")
	public String home(String param) {
		System.out.println(param);
		return "请求参数:" +"<b>"+ param+"</b>"+"&nbsp &nbsp &nbsp &nbsp"+"当前时间:"+new Date();
	}
	
	 @Bean
	    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	        return ss -> {

	            System.out.println("Let's inspect the beans provided by Spring Boot:");

	            String[] beanNames = ctx.getBeanDefinitionNames();
	            String[] beanTypes = ctx.getBeanNamesForAnnotation(Configuration.class);
	            Arrays.sort(beanNames);
	            for (String beanName : beanNames) {
	                System.out.println(beanName);
	            }
	            for(String beanType:beanTypes) {
	            	System.out.println(beanType);
	            }

	        };
	    }
}
