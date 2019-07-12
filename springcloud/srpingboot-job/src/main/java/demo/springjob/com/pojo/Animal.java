package demo.springjob.com.pojo;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Scope("prototype")
@Slf4j
public class Animal {
	
	public static int count = 0;
    
	public Animal() {
		log.info("访问时间:{}->访问次数:{}",new Date(),count);
		count++;
	}
}
