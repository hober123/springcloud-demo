package demo.springjob.com.pojo;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Task {
	
	@Scheduled(cron = "0/3 * * * * ?")
	public void task01() throws InterruptedException {
		
		log.info("当前任务task01线程名称:{}",Thread.currentThread().getName());
		log.debug("task 调试日志");
		TimeUnit.SECONDS.sleep(2);
	}
	
	@Scheduled(cron = "0/10 * * * * ?")
	public void task02() throws InterruptedException {
		log.info("当前任务task02线程名称:{}",Thread.currentThread().getName());
		//TimeUnit.SECONDS.sleep(2);
	}
	
	@Scheduled(cron = "0/5 * * * * ?")
	public void task03() {
		log.info("当前任务task03线程名称:{}",Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
