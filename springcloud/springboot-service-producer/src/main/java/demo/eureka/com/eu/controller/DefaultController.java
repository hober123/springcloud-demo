package demo.eureka.com.eu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api("首页")
@RestController
@Slf4j
public class DefaultController {

	@Value("${server.port}")
	String port;
	
	@ApiOperation(value = "首页-index", notes = "访问默认页")
	@GetMapping("/index")
	public String index() {

		log.info("index");
		return "INDEX";

	}

	@GetMapping("/port")
	public String user() {
		return this.port;
	}
}
