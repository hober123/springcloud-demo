package demo.eureka.com.eu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "server-producer")
public interface RemoteHello {
	
	@GetMapping("/producer/hello/")
    String hello(@RequestParam(value = "param") String param);

}
