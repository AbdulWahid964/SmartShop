<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<h1>Home Page</h1>
<c:if test="${role eq '[admin]'}">
<a href="addBooks">Add Books</a>
 <a href="showBooks">Show Books</a><br/>
  <a href="payment">Payment</a><br/>
</c:if>
<div>
<c:if test="${role eq '[user]'}">
<center>
<h2>Books Search</h2>€‹
<form  action="/find">€‹
<input type="text" name="bookname" class="form-control" placeholder="Search the products"/>€‹
<button type="submit" value="save">Search</button>€‹
</form>€‹
<br/>€‹
<br/>

		<h2>Books Details</h2>
		<br /> <br />
		<table class="table">
			<tr>
				<th width="80">Book-Id</th>
				<th width="80">Book-Name</th>
				<th width="80">Author-Name</th>
				<th width="80">Price</th>
				<th width="80">Quantity</th>
				<th width="80">Description</th>
				<th width="80">Add To Cart</th>
			</tr>
			<c:if test="${list.size() eq 0}">
			<tr>
					<td colspan=6>No Data to be display</td>
			</c:if>
			<c:forEach var="listbooks" items="${list}">
				<tr>
					<td>${listbooks.bookID}</td>
					<td>${listbooks.bookName}</td>
					<td>${listbooks.authorName}</td>
					<td>${listbooks.price}</td>
					<td>${listbooks.quantity}</td>
					<td>${listbooks.description}</td>
					<td><a href="<c:url value='viewcart/${listbooks.bookID}' />">Add To Cart</a></td>
					<%-- <td><a href="<c:url value='/cart/${listbooks.bookID}' />">Add To Cart</a></td> --%>
				</tr>
			</c:forEach>
			
		</table>
		<br/>
		<a href="${pageContext.request.contextPath}/home"> Back</a>
		<a href="<c:url value='viewcart/0' />">Go To Cart</a>
	</center>
	</c:if>
</div>


<br>
<br>
<div>
Welcome Back <sec:authentication property="name"/> 

<sec:authentication property="principal.authorities"/>
<a href="logout">Logout</a></div>


</body>
</html>