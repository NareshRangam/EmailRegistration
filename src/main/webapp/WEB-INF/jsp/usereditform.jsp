<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User Details</title>
</head>
<body>
	<center>
		<h1>Edit User</h1>
	</center>
	<form:form method="POST" action="/MailVerification/editsave">
		<table align="center">
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>First Name :</td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><form:hidden path="password" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>