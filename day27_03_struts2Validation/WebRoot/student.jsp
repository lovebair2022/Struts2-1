<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>title</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<s:actionerror/>
    <s:form action="regist" namespace="/student">
    	<s:textfield name="username" label="用户名"/>
    	<s:textfield name="password" label="密码"/>
    	<s:textfield name="repassword" label="重复密码"/>
    	<s:textfield name="email" label="邮箱"/>
    	<s:textfield name="birthday" label="出生日期"/>
    	<s:textfield name="netaddress" label="日记地址"/>
    	<s:submit value="保存"/>
    </s:form>
  </body>
</html>
