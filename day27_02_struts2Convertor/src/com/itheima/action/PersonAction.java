package com.itheima.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport{
	private String name;
	private int age;
	//框架自动转换了
	//框架会自动探测你的区域信息：zh_CN. yyyy-MM-dd
	private Date birthday;
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String save(){
		System.out.println(name+":"+birthday+":"+age);
		return null;
	}
	
}
