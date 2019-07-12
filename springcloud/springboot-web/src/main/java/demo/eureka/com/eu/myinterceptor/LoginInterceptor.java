package demo.eureka.com.eu.myinterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 在请求处理之前进行调用（Controller方法调用之前） 基于URL实现的拦截器
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */

	private static final String name = "test";
	private static final String pwd = "123";
	
	static {
		log.info("=======开始加载自定义拦截器==========");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
          log.info("开始自定义拦截器:{}",LoginInterceptor.class.getName());
          String username = request.getParameter("username");
          log.info("登录用户{}",username);
          String password = request.getParameter("pwd");
          log.info("用户密码{}",password);
          if(username == LoginInterceptor.name && password == LoginInterceptor.pwd) {
        	  return Boolean.TRUE;
          }else {
        	  return Boolean.FALSE;
          }
         
	}

}
