package com.itheima.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {

	public String execute() throws Exception {
		String s = getText("hello");//û������
		System.out.println(s);
		return NONE;
	}
	public String m1(){
		return SUCCESS;
	}
}
