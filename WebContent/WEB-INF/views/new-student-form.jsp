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
	<h2>Please Fill Up The Form Details</h2>
	<form:form modelAttribute="student" action="saveStudent" method="post">
		<table>
			<tr>
				<td><spring:message code="lbl.username" />:</td>
				<td><form:input path="username" size="30" /> <form:errors
						path="username" cssClass="error" /> <b><font color="red">${message}</font></b>
				</td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl.password" />:</td>
				<td><form:input path="password" size="30" /> <form:errors
						path="password" cssClass="error" /> <b><font color="red">${message}</font></b>
				</td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl.firstName" />:</td>
				<td><form:input path="firstname" size="30" /> <form:errors
						path="firstname" cssClass="error" /> <b><font color="red">${message}</font></b>
				</td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl.lastName" />:</td>
				<td><form:input path="lastname" size="30" /> <form:errors
						path="lastname" cssClass="error" /> <b><font color="red">${message}</font></b>
				</td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl.email" />:</td>
				<td><form:input path="email" size="30" /> <form:errors
						path="email" cssClass="error" /> <b><font color="red">${message}</font></b>
				</td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl.address" />:</td>
				<td><form:input path="address" size="30" /> <form:errors
						path="address" cssClass="error" /> <b><font color="red">${message}</font></b>
				</td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl.phone" />:</td>
				<td><form:input path="phone" size="30" /> <form:errors
						path="phone" cssClass="error" /> <b><font color="red">${message}</font></b>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save Account" name="btnSubmit" /></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="home">Home</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>