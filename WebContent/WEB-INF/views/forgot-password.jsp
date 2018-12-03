<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="lbl.title" /></title>
<style>
.error {
	color: red
}
</style>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<h2> Welcome to forgot password page</h2>
		<p>The username is 'madhura' and password can be anything! :-)</p>
		<br><a href="login">Login</a>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>