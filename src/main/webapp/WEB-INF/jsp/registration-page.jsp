<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.formError {
	color: red;
}
</style>

</head>
<body>


 <div class="container">
  <h1 align="center">Registration Form</h1>
  <br/>
  
  <form:form action="saveUserRegistrationForm" method="post" modelAttribute="users">
<table >
    <tr>
    	<td><form:input path="userId" type="hidden" /></td>
    </tr>
     <tr>
    	<td>User Name</td>
    	<td><form:input path="userName"  cssClass="formInput" placeholder="Enter User Name"/></td>
    	<td><form:errors path="userName"  cssClass="formError"/></td>
    </tr>
     <tr>
    	<td>Email Id:</td>
    	<td><form:input path="emailId"  cssClass="formInput" placeholder="Enter Email"/></td>
    	<td><form:errors path="emailId"  cssClass="formError"/></td>
    </tr>
    <tr>
    	<td>Password</td>
    	<td><form:password path="password"  cssClass="formInput" placeholder="Enter password"/></td>
    	<td><form:errors path="password"  cssClass="formError"/></td>
    </tr>
    <tr>
    	<td>Address</td>
    	<td><form:input path="Address"  cssClass="formInput" placeholder="Enter Address"/></td>
    </tr>
    <tr>
    	<td>Contact Number</td>
    	<td><form:input path="contactNumber"  cssClass="formInput" placeholder="Enter Contact Number"/></td>
    	<td><form:errors path="contactNumber"  cssClass="formError"/></td>
    </tr>
    <tr>
    	<td>Gender</td>
    	<td><form:select path="gender"  cssClass="formInput">
    	<form:option value="Male">Male</form:option>
    	<form:option value="Female">Female</form:option>
    	</form:select></td>
    </tr>
  <%--   <tr>
    	<td>Role:</td>
    	<td><form:select path="role"  cssClass="formInput" >
    		<form:option value="employee" label="Employee" />
 			<form:option value="admin" label="Admin"/>
    	</form:select></td>
    	<td>
    </td>
    </tr> --%>
    <tr><td align="right"><input type="submit" value="Submit"/></td><td align="left">
    <input type="reset" value="Reset"/></td>
    <a href="/login">Login</a> 
    </tr>
    <!-- <a href="/login">Login</a> -->
    </table>
 </form:form>
 
<%-- <form:form action="${pageContext.request.contextPath}/physician/savePhysician" method="post" commandName="physician">


    <div class="form-group">
      <label for="physician_id">Physician Id:</label>
      <form:input path="physicianId"  class="form-control" readonly="true" placeholder="Enter Physician Id"/>
    </div>
    
    <div class="form-group">
      <label for="physician_first_name">Physician First Name:</label>
		<form:input path="physicianFirstName"  class="form-control" placeholder="Enter First Name "/>
</div>
    <div class="form-group">
      <label for="phy_last_name">Physician Last Name:</label>
		<form:input path="physicianLastName"  class="form-control" placeholder="Enter Physician Last Name "/>
    </div>
    
    <div class="form-group">
      <label for="department">Department:</label>
      <form:input path="department"  class="form-control" placeholder="Enter Department "/>
    </div>
    
    <div class="form-group">
      <label for="year_of_Experience">year Of Experience:</label>
	<form:input class="form-control" path="yearOfExperience" placeholder="Enter Year Of Experience"/>
    </div>
    
    <div class="form-group">
      <label for="state">state</label>
      <form:input path="state"  class="form-control"  placeholder="Enter State"/>
    </div>

    <div class="form-group">
      <label for="insurance">Insurance Plan</label>
      <form:input path="insurancePlan"  class="form-control"  placeholder="Enter Insurance Plan"/>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
 <button type="reset" class="btn btn-default">Reset</button>
    
  </form:form><br/> --%>
</div>
</body>
</html>