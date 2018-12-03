<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Information</title>
</head>
<body>
	<div class="container">

		<%@ include file="header.jsp"%>
		<%@ include file="navbar.jsp"%>
		
		<h2>Student Information:</h2>
		<table class="table table-bordered table-hover">
			<tr>
				<td><spring:message code="lbl.studentId" /></td>
				<td>${studentinfo.id}</td>
			</tr>
			<tr>
				<td><spring:message code="lbl.firstName" /></td>
				<td>${studentinfo.firstname}</td>
			</tr>
			<tr>
				<td><spring:message code="lbl.lastName" /></td>
				<td>${studentinfo.lastname}</td>
			</tr>
			<tr>
				<td><spring:message code="lbl.email" /></td>
				<td>${studentinfo.email}</td>
			</tr>
			<tr>
				<td><spring:message code="lbl.address" /></td>
				<td>${studentinfo.address}</td>
			</tr>
			<tr>
				<td><spring:message code="lbl.phone" /></td>
				<td>${studentinfo.phone}</td>
			</tr>
		</table>


		<td><a href="home">Home</a></td>

		<%@ include file="footer.jsp"%>

	</div>
</body>
</html>


<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Student Information<br>

  ${studentinfo.firstname} <br>
  ${studentinfo.lastname}<br>
  ${studentinfo.email}<br>
  ${studentinfo.address}<br>
  ${studentinfo.phone}<br>
  ${studentinfo.id}<br>
  
  <td><a href="home">Home</a></td>

</body>
</html> --%>

