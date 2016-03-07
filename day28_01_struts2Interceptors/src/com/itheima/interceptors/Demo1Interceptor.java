package com.itheima.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Demo1Interceptor extends AbstractInterceptor {
	//应用加载时就完成了初始化
	public void init() {
		System.out.println("Demo1Interceptor初始化了");
	}
	//针对需要拦截的动作方法的访问，每次都会调用
	public String intercept(ActionInvocation invocation) throws Exception {
		//取出动作类，看看是不是代理类
		
		Object currentAction = invocation.getProxy();
		System.out.println(currentAction.getClass().getName());
		System.out.println("Demo1Interceptor拦截前");
		String rtValue = invocation.invoke();//放行
		System.out.println("Demo1Interceptor拦截后");
		return rtValue;
	}

}
