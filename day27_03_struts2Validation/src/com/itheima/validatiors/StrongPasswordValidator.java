package com.itheima.validatiors;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;
//验证密码的强度
public class StrongPasswordValidator extends FieldValidatorSupport {
	//object:实际上就是动作类
	public void validate(Object object) throws ValidationException {
		String fieldName = getFieldName();//得到要验证的字段名
		String fieldValue = (String) getFieldValue(fieldName, object);
		if(StringUtils.isNotEmpty(fieldValue)){
			//有值时再做强度验证
			if(!isPasswordStrong(fieldValue)){
				addFieldError(fieldName, object);
			}
		}
	}
	private static final String GROUP1 = "abcdefghijklmnopqrstuvwxyz";
	private static final String GROUP2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String GROUP3 = "0123456789";
	protected boolean isPasswordStrong(String password) {
		boolean ok1 = false;//有一个小写字母就为true
		boolean ok2 = false;//有一个大写字母就为true
		boolean ok3 = false;//有一个数字就为true
		int length = password.length();
		for(int i=0;i<length;i++){
			if(ok1&&ok2&&ok3)
				break;
			String character = password.substring(i,i+1);
			if(GROUP1.contains(character)){
				ok1 = true;
				continue;
			}
			if(GROUP2.contains(character)){
				ok2 = true;
				continue;
			}
			if(GROUP3.contains(character)){
				ok3 = true;
				continue;
			}
		}
		return ok1&&ok2&&ok3;
	}
}
