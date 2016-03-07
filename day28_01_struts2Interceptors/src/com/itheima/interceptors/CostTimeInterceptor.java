package com.itheima.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CostTimeInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		long time = System.nanoTime();
		String rtValue = invocation.invoke();
		System.out.println("”√ ±£∫"+(System.nanoTime()-time));
		return rtValue;
	}

}
