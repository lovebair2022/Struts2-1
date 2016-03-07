package com.itheima.interceptors;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class SessionCheckInterceptor extends MethodFilterInterceptor {

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断有没有登录标记
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object loginFlag = session.getAttribute("user");
		//有：放行
		if(loginFlag!=null){
			return invocation.invoke();//放行
		}else{
			//没有：返回逻辑视图
			return Action.LOGIN;
		}
	}

}
