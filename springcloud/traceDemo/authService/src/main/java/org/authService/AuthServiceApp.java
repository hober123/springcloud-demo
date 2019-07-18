package org.authService;

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
public class AuthServiceApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(AuthServiceApp.class,args);
    }
    
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
     }
    @GetMapping("/authUser")
    public String authUser(){
       return "OK";
    }
}
