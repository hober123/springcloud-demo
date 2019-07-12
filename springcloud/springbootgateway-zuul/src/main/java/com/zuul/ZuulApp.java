package com.zuul;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zuul.filter.AccessFilter;

/**
 * GateWay Zuul
 *
 */

@SpringBootApplication
@SpringCloudApplication
@EnableZuulProxy
public class ZuulApp 
{
	
	@Bean
	public AccessFilter CustomFilter() {
		
		return new AccessFilter();
	}
	
    public static void main( String[] args )
    
    {
    	new SpringApplicationBuilder(ZuulApp.class).web(WebApplicationType.SERVLET).run(args);
    }
}
