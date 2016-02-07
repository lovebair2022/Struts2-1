package com.itheima.action;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	public String addCustomer(){
		//µ÷ÓÃService
		System.out.println("addCustomer");
		return SUCCESS;
	}
	public String updateCustomer(){
		System.out.println("updateCustomer");
		return SUCCESS;
	}
	public String delCustomer(){
		System.out.println("delCustomer");
		return SUCCESS;
	}
	public String findCustomer(){
		System.out.println("findCustomer");
		return SUCCESS;
	}
}
