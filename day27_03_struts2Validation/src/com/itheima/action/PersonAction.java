package com.itheima.action;

import java.util.Date;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport{
	private String name;
	private int age;
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
		System.out.println("���棺"+name+":"+birthday+":"+age);
		return null;
	}
	public String update(){
		System.out.println("���£�"+name+":"+birthday+":"+age);
		return null;
	}
	public String findAll(){
		System.out.println("��ѯ");
		return null;
	}
}
