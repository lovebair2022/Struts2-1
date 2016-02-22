package com.itheima.action;

import java.util.ArrayList;
import java.util.Collection;

import com.itheima.domain.Student;

public class Demo1Action {
	//批量添加时
	private Collection<Student> stus = new ArrayList<Student>();

	public Collection<Student> getStus() {
		return stus;
	}

	public void setStus(Collection<Student> stus) {
		this.stus = stus;
	}
	public String save(){
		for(Student s:stus){
			System.out.println(s);
		}
		return "none";
	}
}
