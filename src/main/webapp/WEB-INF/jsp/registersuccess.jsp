<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration success</title>
</head>
<body>
<table border="2" align="center">
<tr>
<tr>
      <th>Id</th>
      <th>First Name</th>
       <th>Last Name</th>
      <th>Email</th>
      <th>Password</th>
      
      
    </tr>
    
     <tr>
      <td >${user.id}</td>
      <td >${user.firstname}</td>
      <td >${user.lastname}</td>
      <td >${user.email}</td>
      <td >${user.password}</td>    
    
     
    </tr>
   
</table>
<center><h3>Activation link sent to ${user.email}.Click the link to Activate your Account</h3></center>

</body>
</html>