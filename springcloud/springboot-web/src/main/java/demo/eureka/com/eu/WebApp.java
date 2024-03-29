package demo.eureka.com.eu;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * Service Demo 1!
 *
 */
@Api("配置中心示例")
@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class WebApp {
	
	public static void main(String[] args) {
		SpringApplication.run(WebApp.class, args);
	}

	@Value("${server.port}")
	String port;
    
	@ApiOperation(value = "conifg-demo" ,  notes="spring boot 配置中心示例")
	@RequestMapping("/config")
	public String home(String param) {
		System.err.println(param);
		return "请求参数:" +"<b>"+ param+"</b>"+"&nbsp &nbsp &nbsp &nbsp"+"当前时间:"+new Date();
	}
}
