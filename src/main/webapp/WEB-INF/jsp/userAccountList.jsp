<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     


<!DOCTYPE html>
<html lang="en">
<head>
<title>User Accounts List</title>
<meta charset="utf-8">

 
</head>
<body>

<center><h2>List Of User Accounts</h2></center><br>

<div align="center">
<table border="1">

  
    <tr>
      <th>Id</th>
      <th>First Name</th>
       <th>Last Name</th>
      <th>Email</th>
      <th>Password</th>
      <th>Active</th>
      <th>Edit</th>
      <th>Delete</th>
      
    </tr>

  <c:forEach var="list" items="${user}">
  
    <tr>
     <td >${list.id}</td>
      <td >${list.firstname}</td>
      <td >${list.lastname}</td>
      <td >${list.email}</td>  
      <td >${list.password}</td>
      <td >${list.active}</td>
      <td><a href="editUser/${list.id}">Edit</a></td>  
      <td><a href="deleteUser/${list.id}">Delete</a></td>
    </tr>
    </c:forEach>
  
</table><br>
</div>
<div align="center">
<a href="registerform">Register New Account</a><br><br>
<a href="downloadExcel">Download Excel<!-- <img src="images/excel.png" title="Download Excel" width="60" height="60" /> --></a>
</div>
<%-- <center><h3>If You Want to Download List of User Accounts in Excel Format.click Download Button</h3></center>
<center><a href="downloadExcel">Download</a></center> --%>
</body>
</html>