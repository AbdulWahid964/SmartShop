<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style type="text/css">
.table {
	font-family: verdana, arial, sans-serif;
	font-size: 13px;
	border-width: 1px;
	border-color: black;
	border-collapse: collapse;
}

.table td {
	border-width: 2px;
	padding: 8px;
	border-style: solid;
	border-color: black;
}

.table th {
	background-color: #c3dde0;
	border-width: 2px;
	padding: 8px;
	border-style: solid;
	border-color: black;
}
</style>
</head>
<body>

	<h2>Product Details</h2>

	<form action="products">
		Product Name:<input id="productname" name="productname"
			class="form-control" value="${product.productName}"
			placeholder="Enter Product Name" /> <input type="submit"
			value="Submit">
		<!-- <input type="reset" value="Reset"> -->
	</form>
	<form action="home">
		<button type="submit">Refresh</button>
	</form>
	<br>
	<br>


	<c:if test="${role eq '[manager]'}">
		<table class="table">
			<tr>
				<th width="80">Product Id</th>
				<th width="80">Product Name</th>
				<th width="80">Price</th>
				<th width="80">Quantity</th>
				<th width="80">Description</th>
				<th width="80">Edit</th>
				<th width="80">Delete</th>
			</tr>
			<c:if test="${productList.size() eq 0}">
				<tr>
					<td colspan=7>No Product to be displayed</td>
			</c:if>
			<c:forEach var="product" items="${productList}">
				<tr>
					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.productPrice}</td>
					<td>${product.quantity}</td>
					<td>${product.description}</td>
					<td><a href="<c:url value='/product/${product.productId}' />">Edit</a></td>
					<td><a  href="<c:url value='/products/product/${product.productId}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<a href="/product">Add Product</a>
		<br/>
		<a href="/stock">Add Stock</a>
	</c:if>
	<div>
		<c:if test="${role eq '[user]'}">
			<table class="table">
				<tr>
					<th width="80">Product Id</th>
					<th width="80">Product-Name</th>
					<th width="80">Price</th>
					<th width="80">Quantity</th>
					<th width="80">Description</th>
				</tr>
				<c:if test="${productList.size() eq 0}">
					<tr>
						<td colspan=5>No Data to be display</td>
				</c:if>
				<c:forEach var="product" items="${productList}">
					<tr>
						<td>${product.productId}</td>
						<td>${product.productName}</td>
						<td>${product.productPrice}</td>
						<td>${product.quantity}</td>
						<td>${product.description}</td>
					</tr>
				</c:forEach>
			</table>
			<br />
		</c:if>
	</div>
	<br>
	<br>
	<div>
		Welcome Back
		<sec:authentication property="name" />

		<sec:authentication property="principal.authorities" />
		<a href="logout">Logout</a>
	</div>

</body>
</html>