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
	<form:form modelAttribute="student" action="getStudent" method="get">
		<table>

			<tr>
				<td><spring:message code="lbl.studentId" />:</td>
				<td><form:input path="id" size="30" /> <form:errors path="id"
						cssClass="error" /> <b><font color="red">${message}</font></b></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Get Student" name="btnSubmit" /></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="home">Home</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>