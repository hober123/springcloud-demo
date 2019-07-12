package demo.springjob.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;


/**
 * spring job
 *
 */
@SpringBootApplication
@EnableScheduling
public class JobApp 
{
    public static void main( String[] args )
    {
    	new SpringApplication(JobApp.class).run(args);
    }
    
    @Bean
    public TaskScheduler taskScheduler() {
    	
    	ThreadPoolTaskScheduler threadScheduler = new ThreadPoolTaskScheduler();
    	threadScheduler.setPoolSize(10);
    	threadScheduler.setThreadNamePrefix("springboot-job");
		return threadScheduler;
    	
    }
}
