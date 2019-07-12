package demo.springjob.com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.springjob.com.pojo.Depart;
import demo.springjob.com.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api("spring fjson 接口")
@RequestMapping(value="/json", produces="application/json;utf-8")
public class UserController {
	
	@ApiOperation(value = "获取用户信息", notes = "GET方法，无参数")
	@RequestMapping(value = "/getUser")
	public User getUser() {
		
		log.info("getUser");
		demo.springjob.com.pojo.User user = new User("小明", 0, "", "", "");
		return user;
	}
	
	@ApiOperation(value = "获取用户列表", notes = "返回用户列表")
	@RequestMapping(value = "/userList")
	public List<demo.springjob.com.pojo.User> userList() {
		
		log.info("get User list");
		List<User> users = new ArrayList<User>();
		
		User user = new User("小明", 0, "", "", "");
		User user1 = new User("小王",1,"","","");
		User user2 = new User("小竹",2,"","","");
		users.add(user);
		users.add(user1);
		users.add(user2);
		return users;
	}
	
	@ApiOperation(value = "Map对象返回用户信息", notes = "请求参数为depart对象")
	@RequestMapping(value = "/userList1",method = RequestMethod.POST)
	public Map<String,List<User>> userList1(@RequestBody Depart depart) {
		
		log.info("get User list");
		List<User> users = new ArrayList<User>();
		Map<String,List<User>> userMap = new HashMap<String,List<User>>();
		
		User user = new User("小明", 0, "", "", "");
		User user1 = new User("小王",1,"","","");
		User user2 = new User("小竹",2,"","","");
		users.add(user);
		users.add(user1);
		users.add(user2);
		userMap.put("users", users);
		return userMap;
	}

}
