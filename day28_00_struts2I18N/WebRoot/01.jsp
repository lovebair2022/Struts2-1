<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>获取全局消息资源包中的内容</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<!-- 随地用：需要配置了全局消息资源包 -->
  	<s:text name="hello"></s:text>
	<hr/>    
	<!-- 在表单中用 -->
	<s:textfield name="name" key="name"></s:textfield>
	<!-- 使用Struts2的国际化标签:随时用 -->
	<s:i18n name="msg">
		<s:text name="hello"></s:text>
	</s:i18n>
	<!-- 使用占位符 -->
	<s:text name="welcome">
		<s:param>杨洋</s:param>
		<s:param>黑马训练营</s:param>
	</s:text>
  </body>
</html>
