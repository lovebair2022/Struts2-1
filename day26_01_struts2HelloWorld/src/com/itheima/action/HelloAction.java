package com.itheima.action;

public class HelloAction {
	public String sayHello(){
		try {
			System.out.println("HelloAction��sayHello����ִ����");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
