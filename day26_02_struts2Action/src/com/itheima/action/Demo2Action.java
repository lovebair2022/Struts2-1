package com.itheima.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
//��ʾServlet�йصĶ���Ļ�ȡ
public class Demo2Action extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	public String execute(){
		System.out.println(request);
		System.out.println(response);
		return NONE;
	}
	//�ڵ��ö�������ǰ������ȵ��ø÷�������request����ע�����
	public void setServletRequest(HttpServletRequest request) {
		 this.request = request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
