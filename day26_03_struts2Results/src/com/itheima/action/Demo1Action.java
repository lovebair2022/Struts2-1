package com.itheima.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
	public String save(){
		//µ÷ÓÃservice
		try{
//			int i=1/0;
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
}
