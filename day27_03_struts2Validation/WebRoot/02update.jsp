<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>更新</title>
    <s:head/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<!-- 
    <form action="${pageContext.request.contextPath}/act1" method="post">
    	用户名：<input type="text" name="name"/><br/>
    	年龄：<input type="text" name="age"/><br/>
    	出生日期：<input type="text" name="birthday"/>MM/dd/yyyy<br/>
    	<input type="submit" value="注册"/>
    </form>
     -->
   	<hr/>
   	<s:form action="update">
   		<s:textfield name="name" label="用户名" value=""></s:textfield>
   		<s:textfield name="age" label="年龄" value="10"></s:textfield>
   		<s:textfield name="birthday" label="出生日期(MM/dd/yyyy)" value="2000-10-01"></s:textfield>
   		<s:submit value="保存"></s:submit>
   	</s:form>
  </body>
</html>
