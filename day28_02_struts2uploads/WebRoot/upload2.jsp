<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
    <s:form action="upload2" enctype="multipart/form-data">
    	<s:textfield name="name" label="姓名"></s:textfield>
    	<s:file name="photo" label="靓照"></s:file>
    	<s:file name="photo" label="靓照"></s:file>
    	<s:submit value="保存"></s:submit>
    </s:form>
  </body>
</html>
