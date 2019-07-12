package demo.eureka.com.eu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import demo.eureka.com.eu.myinterceptor.LoginInterceptor;

@Configuration
public class IntercepConfig extends WebMvcConfigurationSupport {
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/test/**");
		super.addInterceptors(registry);
	}

}
