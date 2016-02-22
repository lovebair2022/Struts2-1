package com.itheima.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.itheima.domain.Student;

public class Demo2Action {
	//批量添加时
	private Map<String, Student> stus = new HashMap<String, Student>();

	
	public Map<String, Student> getStus() {
		return stus;
	}


	public void setStus(Map<String, Student> stus) {
		this.stus = stus;
	}


	public String save(){
		for(Map.Entry<String, Student> me:stus.entrySet()){
			System.out.println(me.getKey()+":"+me.getValue());
		}
		return "none";
	}
}
