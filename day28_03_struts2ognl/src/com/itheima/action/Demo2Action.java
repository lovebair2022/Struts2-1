package com.itheima.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo2Action extends ActionSupport {
	private String name = "青霞";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute(){
		ValueStack vs1 = ActionContext.getContext().getValueStack();
		
		vs1.setValue("name", "范青霞");//给根栈中对象的name属性赋值
		vs1.setValue("#name", "霞霞");//相当于向contextMap中存放数据
		//总结：操作根中对象的属性，直接写属性名称。操作contextMap中的数据，要加上#。取亦然。
		
		//向根栈中压入2个Date对象
		
		//根栈中对象“属性”的设置：默认情况下，从栈顶到栈底依次搜索属性名称，找到就赋值，不再往下找。找不到报错
		//也可以指定从第几个开始找，索引从0开始
		vs1.push(new Date());
		vs1.push(new Date());
		
		vs1.setValue("[1].month", 9);
		
		vs1.setValue("name", "青青");
		
		return SUCCESS;
	}
}
