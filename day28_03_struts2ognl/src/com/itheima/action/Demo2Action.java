package com.itheima.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo2Action extends ActionSupport {
	private String name = "��ϼ";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute(){
		ValueStack vs1 = ActionContext.getContext().getValueStack();
		
		vs1.setValue("name", "����ϼ");//����ջ�ж����name���Ը�ֵ
		vs1.setValue("#name", "ϼϼ");//�൱����contextMap�д������
		//�ܽ᣺�������ж�������ԣ�ֱ��д�������ơ�����contextMap�е����ݣ�Ҫ����#��ȡ��Ȼ��
		
		//���ջ��ѹ��2��Date����
		
		//��ջ�ж������ԡ������ã�Ĭ������£���ջ����ջ�����������������ƣ��ҵ��͸�ֵ�����������ҡ��Ҳ�������
		//Ҳ����ָ���ӵڼ�����ʼ�ң�������0��ʼ
		vs1.push(new Date());
		vs1.push(new Date());
		
		vs1.setValue("[1].month", 9);
		
		vs1.setValue("name", "����");
		
		return SUCCESS;
	}
}
