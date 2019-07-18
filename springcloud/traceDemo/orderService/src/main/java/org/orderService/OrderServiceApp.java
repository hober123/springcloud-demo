package org.orderService;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ervin
 *
 */
@SpringBootApplication
@RestController
public class OrderServiceApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderServiceApp.class, args);
    }
    
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
     }
    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping("/orderQuery")
    public String orderQuery(){
       String authRes = restTemplate.getForEntity("http://localhost:14001/authUser",String.class).getBody();
       if(authRes.equals("OK")) {
    	   Random randomGenerator = new Random();
    	   return "orderId:"+Math.abs(randomGenerator.nextLong());
       }
       return "no order";
}
}
