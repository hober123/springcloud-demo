package demo.eureka.com.eu;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;


/**
 * Config Server 示例
 *
 */
@Api("config-Server")
@SpringBootApplication
@EnableAutoConfiguration
@RestController
@EnableConfigServer
public class ConfigServerApp {
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApp.class, args);
	}

	@Value("${server.port}")
	String port;
    
	@RequestMapping("/config-server")
	public String home(String param) {
		System.out.println(param);
		return "请求参数:" +"<b>"+ param+"</b>"+"&nbsp &nbsp &nbsp "+"当前时间:"+new Date();
	}
}
