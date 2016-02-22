package com.itheima.action;

import com.itheima.domain.Student;

//动作
public class StudentAction {
	private Student student = new Student();//相对要高一些

	public Student getStudent() {
		System.out.println("getStudent");
		return student;
	}

	public void setStudent(Student student) {
		System.out.println("setStudent");
		this.student = student;
	}
	public String save(){
		//把表单的数据封装到模型对象中
		//调用Service把Student的数据保存到数据库中
		System.out.println(student);
		return "none";
	}
}
