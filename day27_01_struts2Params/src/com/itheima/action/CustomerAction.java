package com.itheima.action;

import com.itheima.domain.Customer;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction implements ModelDriven<Customer>{
	private Customer customer = new Customer();//һ��Ҫnew����

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String save(){
		System.out.println(customer);
		return "none";
	}
	//���ö�������ǰ����ܻ��ȵ��ø÷���
	//����ʵ����customer��
	public Customer getModel() {
		return customer;
	}
}
