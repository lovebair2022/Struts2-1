package com.itheima.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo3Action extends ActionSupport {
	private String name = "��ϼ";
//	private String p="actionP";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//	public String getP() {
//		return p;
//	}
//
//	public void setP(String p) {
//		this.p = p;
//	}

	public String execute(){
		ValueStack vs1 = ActionContext.getContext().getValueStack();
		
		//��contextMap�з�һ������
		vs1.setValue("#p", "mapP");
		
		return SUCCESS;
	}
}
