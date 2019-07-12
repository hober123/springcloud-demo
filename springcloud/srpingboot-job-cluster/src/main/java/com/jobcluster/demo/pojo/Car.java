package com.jobcluster.demo.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Car {
	
	@JSONField(name = "NAME")
	private String name;
	@JSONField(name = "型号",ordinal = 1)
	private String model;
	@JSONField(serialize = false)
	private String price;
	//出厂日期
	@JSONField(name="出厂日期", format="dd/MM/yyyy")
	private Date prodDate = new Date();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getProdDate() {
		return prodDate;
	}

	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
	}

}
