package com.itheima.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Demo1Interceptor extends AbstractInterceptor {
	//Ӧ�ü���ʱ������˳�ʼ��
	public void init() {
		System.out.println("Demo1Interceptor��ʼ����");
	}
	//�����Ҫ���صĶ��������ķ��ʣ�ÿ�ζ������
	public String intercept(ActionInvocation invocation) throws Exception {
		//ȡ�������࣬�����ǲ��Ǵ�����
		
		Object currentAction = invocation.getProxy();
		System.out.println(currentAction.getClass().getName());
		System.out.println("Demo1Interceptor����ǰ");
		String rtValue = invocation.invoke();//����
		System.out.println("Demo1Interceptor���غ�");
		return rtValue;
	}

}
