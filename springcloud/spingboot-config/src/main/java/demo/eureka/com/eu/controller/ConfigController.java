package demo.eureka.com.eu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


@Api("配置中心")
@RestController
@Slf4j
public class ConfigController {
	

	@ApiOperation(value = "配置中心本地配置", notes = "本地配置")
	@GetMapping("/config")
	public String config() {

		log.info("本地配置文件使用");
		return "CONFIG-NATIVE";

	}

}
