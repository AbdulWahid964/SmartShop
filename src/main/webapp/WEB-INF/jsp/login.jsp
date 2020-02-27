<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>  
  <script type="text/javascript">
   function preventBack()
   {
		   	window.history.forward();
			 setTimeout("preventBack()", 0);
			 window.onunload=function(){null};
	   		
	} 
</script>
  
    <title> LOGIN Form</title>
    <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <link rel="stylesheet" href="css/bootstrap.css">
       <link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
       <style>
       body{
          margin:0;
          padding:0;
          background:url("/img/bg.jpg");
          background-size: cover;
          font-family: sans-serif;
           }
      .log{  width:1366px;
          height:696px;
          
          }
      .loginbox{  width: 320px;
          height: 450px;
          background: #000;
          color: #fff;
          top:20%;
          left:36%;
          position:absolute;
          transform: translate{-50%,-50%}
          box-sizing: border-box;
          padding: 70px 30px;
          opacity:.7;
               }
      .avatar{  width: 100px;
          height: 100px;
          border-radius:50%;
          position:absolute;
          top:-14%;
          left:calc(50% - 50px);
             }
      h1{    margin:0;
          padding: 0 0 20px;
          text-align: center;
          font-size: 30px;
          font-family:AR JULIAN;
          color:red;
        }    
      .loginbox p{  margin:0;
          padding: 0;
          font-weight:bold;
                 }
      .loginbox input{width: 100%;
          margin-bottom:20px;
                     }
      .loginbox input[type="text"], input[type="password"]{
          border: none;
          border-bottom: 1px solid #fff;
          background: transparent;
          outline:none;
          height:40px;
          color:#fff;
          font-size:16px;
              }
      .loginbox input[type="submit"]{
          border: none;
          outline:none;
          height:40px;
          background:#fb2525;
          color: #fff;
          font-size:18px;
          border-radius:20px;
              }
      .loginbox input[type="submit"]:hover
      {    cursor:pointer;
          background:#ffc107;
          color:#000;
      }
      .loginbox a{   
          text-decoration:none;
          font-size:12px;
          line-height:20px;
          color: darkgrey;
      }
      .loginbox a:hover
      {  
        color:#ffc107;
      }

      .active{
        color:#fff;
        background:#e02626;
        border-radius:4px;
      }
       </style>
  </head>
  <body>
    <img class="log">
    <div class="loginbox">
    	<c:if test="${param.error != null}">
				<div class="fadeIn first">
					<h2>Invalid user name and password</h2>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="fadeIn first">
					<h2>you have been logged out</h2>
				</div>
			</c:if>
    <img src="/img/avatar.png" class="avatar">
    <h1>Login Here</h1>
    
    <form:form action="/login" method="POST">
    <p> Username</p>
    <input type="text" name="username" id="username" placeholder="Enter Username">
    <p> Password</p>
    <input type="password" name="password"  id="password" placeholder="Enter Password"><br>
    <input type="submit" value="Login">
    <a href="showUserRegistration"> click here to register</a>
    </form:form>
    </div>
    <script src="js/jquery-2.1.4.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <script src="js/ajax-utils.js"></script>
      <script src="js/script.js"></script>
  </body>
</html>