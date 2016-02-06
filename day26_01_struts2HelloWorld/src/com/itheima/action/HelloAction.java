package com.itheima.action;

public class HelloAction {
	public String sayHello(){
		try {
			System.out.println("HelloAction的sayHello方法执行了");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
