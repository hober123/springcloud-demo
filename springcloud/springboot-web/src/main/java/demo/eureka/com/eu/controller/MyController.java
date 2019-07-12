package demo.eureka.com.eu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api("拦截器")
@RestController
@Slf4j
public class MyController {

	@GetMapping("/{param}")
	public String index(@PathVariable("param") String param) {
		return "";
	}

	@ApiOperation(value = "首页-index", notes = "访问默认页")
	@GetMapping("/index")
	public String index() {

		log.info("index");
		return "INDEX";

	}

	@GetMapping("/test/login")
    public String login(String username,String pwd) {
       
		return "登录成功";
    }

}
