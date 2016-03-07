package com.itheima.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {

	public String execute() throws Exception {
		String s = getText("hello");//没有意义
		System.out.println(s);
		return NONE;
	}
	public String m1(){
		return SUCCESS;
	}
}
