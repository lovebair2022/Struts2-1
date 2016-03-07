<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
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
  	<!-- 不建议 -->
  	<s:property value="p"/><br/>
  	<s:property value="#p"/><br/>
  	<s:property value="#request['struts.valueStack']"/><br/>
  	<s:property value="#context['com.opensymphony.xwork2.ActionContext.locale']"/><br/>
  	<hr/>
  	<%
  	ValueStack vs = ActionContext.getContext().getValueStack();
  	String p1 = (String)vs.findValue("p");
  	out.write(p1+"<br/>");
  	String p2 = (String)vs.findValue("#p");
  	out.write(p2+"<br/>");
  	%>
  	
    <s:debug></s:debug>
  </body>
</html>
