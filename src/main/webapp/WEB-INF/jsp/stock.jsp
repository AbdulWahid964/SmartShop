<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Stock Details Form</h1>

		<form:form action="/stock" method="post" modelAttribute="stock">
			<table>
				<tr>
					<td><form:input path="id" type="hidden" /></td>
				</tr>
				<tr>
					<td>Stock Name</td>
					<td><form:input path="name" cssClass="formInput"
							placeholder="Enter Stock Name" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save" /></td>
				</tr>
				<!-- <a href="/login">Login</a> -->
			</table>
		</form:form>
	</center>
</body>
</html>