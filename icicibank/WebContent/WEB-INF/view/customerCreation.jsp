<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Create Customer</h2>
	<a href="CustomerController?act=listCustomer">List Customer</a>
	
	<br>

	<form action="CustomerController?act=createCustomer" method="post">

		Customer first Name : <input type="text" name="fname">
		<br> 
		Customer last Name : <input type="text" name="lname">
		<br>
		Customer Age : <input type="text" name="age">
		<br> 
		<input type="submit" name="subm" value="Create Customer">

	</form>



</body>
</html>