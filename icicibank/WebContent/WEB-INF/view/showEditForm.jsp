<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Edit Customer Details</h2>
	<a href="CustomerController?act=listCustomer">List Customer</a>
	<br>


	<form action="CustomerController?act=updateCustomer"
		method="post">

		<table border="1">
			<tr>
				<th>Customer Id:</th>
				<td><input type="text" name="id"
					value="<c:out value='${customerPojo.id}' />" /></td>
			</tr>
			<tr>
				<th>First name:</th>
				<td><input type="text" name="fname" size="45"
					value="<c:out value='${customerPojo.f}' />" /></td>
			</tr>
			<tr>
				<th>Last name:</th>
				<td><input type="text" name="lname" size="45"
					value="<c:out value='${customerPojo.l}' />" /></td>
			</tr>
			<tr>
				<th>Age:</th>
				<td><input type="text" name="age" size="5"
					value="<c:out value='${customerPojo.a}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Update Customer Details" /></td>
			</tr>
		</table>
	</form>



</body>
</html>