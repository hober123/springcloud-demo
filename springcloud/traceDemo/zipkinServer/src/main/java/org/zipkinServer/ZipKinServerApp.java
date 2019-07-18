package org.zipkinServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import zipkin.server.EnableZipkinServer;



/**
 * 
 * @author Ervin
 *
 */
@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableZipkinServer
@RestController
public class ZipKinServerApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ZipKinServerApp.class, args);
    }
    
    @Autowired
    Consumer consumer;
    
    @GetMapping("/test")
    void test() {
    	
    }
}
