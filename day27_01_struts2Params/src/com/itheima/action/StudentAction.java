package com.itheima.action;

import com.itheima.domain.Student;

//����
public class StudentAction {
	private Student student = new Student();//���Ҫ��һЩ

	public Student getStudent() {
		System.out.println("getStudent");
		return student;
	}

	public void setStudent(Student student) {
		System.out.println("setStudent");
		this.student = student;
	}
	public String save(){
		//�ѱ������ݷ�װ��ģ�Ͷ�����
		//����Service��Student�����ݱ��浽���ݿ���
		System.out.println(student);
		return "none";
	}
}
