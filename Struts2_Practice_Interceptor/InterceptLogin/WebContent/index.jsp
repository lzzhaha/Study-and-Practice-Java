<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Interceptor</title>
</head>
<body>

	<center><h2>${sessionScope.messageSession }</h2>
	<s:form action="login" method="post">
		<s:textfield label="INVITATION CODE" name="inputCode"></s:textfield>
		<s:submit value="login" />
	</s:form>
	<a href="/InterceptorLogin/applyCode.jsp" type="button" >Apply a code</a>
	</center>
</body>
</html>