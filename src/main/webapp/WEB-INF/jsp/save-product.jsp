<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.formError {
	color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<center>
		<h1>Product Details Form</h1>

		<form:form action="/product" method="post" modelAttribute="product">
			<table>
				<tr>
					<td><form:input path="productId" type="hidden" /></td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td><form:input path="productName" cssClass="formInput"
							placeholder="Enter Product Name" /></td>
					<td><form:errors path="productName" cssClass="formError" /></td>
				</tr>
				<tr>
					<td>Product Price</td>
					<td><form:input path="productPrice" cssClass="formInput"
							placeholder="Enter Price" /></td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><form:input path="quantity" cssClass="formInput"
							placeholder="Enter Quantity" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><form:input path="description" cssClass="formInput"
							placeholder="Enter Description" /></td>
				</tr>
				<tr>
					<td colspan="2"><c:if test="${!empty products.productName}">
							<input type="submit" value="Update Product" />
						</c:if> <c:if test="${empty products.productName}">
							<input type="submit" value="Save" />
						</c:if></td>
					<td><input type=button value="Back" onClick="history.back()">
					</td>
				</tr>
				<!-- <a href="/login">Login</a> -->
			</table>
		</form:form>
	</center>
</body>
</html>