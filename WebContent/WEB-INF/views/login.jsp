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
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<p>Please enter your username and password</p>
				</div>
				<form:form modelAttribute="mylogin" action="login-form"
					method="post">
					<table class="table table-hover">
						<tr>
						<tr class="form-group">
							<td><spring:message code="lbl.username" />:</td>
							<td><form:input path="username" size="30" /> <form:errors
									path="username" cssClass="error" /> <b><font color="red">${message}</font></b>
							</td>
						</tr>

						<tr class="form-group">
							<td><spring:message code="lbl.password" />:</td>
							<td><form:input path="password" size="30" /> <form:errors
									path="password" cssClass="error" /> <b><font color="red">${message}</font></b>
							</td>
						</tr>

						<tr>
							<td></td>
							<td class="forgot"><a href="reset">Forgot password?</a></td>
						</tr>

						<tr>
							<td></td>
							<td>
								<button type="submit" class="btn btn-primary"">Login</button>
							</td>
						</tr>
					</table>
					<!-- <div class="forgot" style="margin-left: 250px;">
						<a href="reset">Forgot password?</a>
					</div> -->
					<!-- <button type="submit" class="btn btn-primary" style="margin-left: 250px;">Login</button> -->
				</form:form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>