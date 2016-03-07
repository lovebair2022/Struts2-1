package com.itheima.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo1Action extends ActionSupport {
	private String name = "范青霞";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute(){
		
		//如何得到ValueStack
		ValueStack vs1 = ActionContext.getContext().getValueStack();
//		System.out.println("vs1:"+vs1);
//		ValueStack vs2 = (ValueStack) ActionContext.getContext().get(ValueStack.VALUE_STACK);//从Map中取
//		System.out.println("vs2:"+vs2);
//		ValueStack vs3 = (ValueStack) ServletActionContext.getRequest().getAttribute("struts.valueStack");
//		System.out.println("vs3:"+vs3);
		
		
		vs1.set("p1","ppp");
		vs1.set("p2","pppp");
		return SUCCESS;
	}
}
