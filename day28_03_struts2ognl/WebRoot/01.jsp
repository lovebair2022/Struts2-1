<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>OGNL的功能</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<br/>-------好比是JSTL中的c：out。把表达式的值输出到页面上。value属性中的内容就是OGNL表达式---------<br/>
  	支持对象方法调用，如xxx.doSomeSpecial();<br/>
    <s:property value="'abcdefg'.endsWith('d')"/><br/>
    <hr/>
   	 支持类静态的属性访问<br/>
    <s:property value="@java.lang.Integer@MAX_VALUE"/><br/>
             支持类静态的方法访问:Struts2中默认是关闭的。需要一个常量开关：struts.ognl.allowStaticMethodAccess<br/>
    <s:property value="@java.util.UUID@randomUUID()"/><br/>
  </body>
</html>
