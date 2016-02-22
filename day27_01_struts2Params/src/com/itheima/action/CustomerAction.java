package com.itheima.action;

import com.itheima.domain.Customer;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction implements ModelDriven<Customer>{
	private Customer customer = new Customer();//一定要new出来

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
	//调用动作方法前，框架会先调用该方法
	//不会实例化customer。
	public Customer getModel() {
		return customer;
	}
}
