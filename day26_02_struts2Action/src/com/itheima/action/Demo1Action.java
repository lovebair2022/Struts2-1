package com.itheima.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
//��ʾServlet�йصĶ���Ļ�ȡ
public class Demo1Action extends ActionSupport {
	public String execute(){
		System.out.println(ServletActionContext.getPageContext());
		System.out.println(ServletActionContext.getRequest());
		System.out.println(ServletActionContext.getResponse());
		System.out.println(ServletActionContext.getServletContext());
		return NONE;
	}
}
