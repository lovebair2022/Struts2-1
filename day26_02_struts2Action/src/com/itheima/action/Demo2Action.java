package com.itheima.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
//演示Servlet有关的对象的获取
public class Demo2Action extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	public String execute(){
		System.out.println(request);
		System.out.println(response);
		return NONE;
	}
	//在调用动作方法前，框架先调用该方法。把request对象注入进来
	public void setServletRequest(HttpServletRequest request) {
		 this.request = request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
