package com.jobcluster.demo.pojo;

import java.util.ArrayList;
import java.util.List;

import com.jobcluster.demo.pojo.User;

public class Depart {
	
	private String name;
	private String manager;
	private String phone;
	private List<User> employees = new ArrayList<User>();
	
	public Depart(String name,String manager,String phone,List<User> luser) {
		
		this.name = name;
		this.manager = manager;
		this.phone = phone;
		this.employees = luser;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getManager() {
		return manager;
	}
	
	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<User> getEmployees() {
		return employees;
	}

	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}

}
