package com.itheima.interceptors;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class SessionCheckInterceptor extends MethodFilterInterceptor {

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//�ж���û�е�¼���
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object loginFlag = session.getAttribute("user");
		//�У�����
		if(loginFlag!=null){
			return invocation.invoke();//����
		}else{
			//û�У������߼���ͼ
			return Action.LOGIN;
		}
	}

}
