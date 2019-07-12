package demo.eureka.com.eu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import demo.eureka.com.eu.service.RemoteHello;

@Api("首页-remote")
@RestController
@Slf4j
public class RpcInovke {
	
	@Autowired
	RemoteHello helloRemote;
	
	@GetMapping("/{param}")
    public String index(@PathVariable("param") String param) {
        return helloRemote.hello(param + "!");
    }

	@ApiOperation(value = "首页-index", notes = "访问默认页")
	@GetMapping("/index")
	public String index() {

		log.info("index");
		return "INDEX";

	}

}
