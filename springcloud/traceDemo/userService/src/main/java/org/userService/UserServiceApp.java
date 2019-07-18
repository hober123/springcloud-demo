package org.userService;

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
public class UserServiceApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(UserServiceApp.class, args);
    }
    
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
     }
    
    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping("/userQuery")
    public String userQuery(){
       return restTemplate.getForEntity("http://localhost:14002/orderQuery",String.class).getBody();
    }
}
