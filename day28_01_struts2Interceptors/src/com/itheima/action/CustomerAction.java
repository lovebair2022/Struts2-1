package com.itheima.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	public String save(){
		System.out.println("�������");
		return SUCCESS;
	}
	public String update(){
		System.out.println("���²���");
		return SUCCESS;
	}
	public String login(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", "aaa");
		return SUCCESS;
	}
}
