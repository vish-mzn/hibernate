<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>ICICI Customer Management</title>
</head>
<body>

	<a href="CustomerController?act=displayCustomerForm">Create Customer</a>  
	<br>
	<a href="CustomerController?act=listCustomer">List Customer</a>


	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Customer</h2>
			</caption>
			<tr>
				<th>Cusomer ID</th>
				<th>Customer Firstname</th>
				<th>Customer lastname</th>
				<th>Age</th>
				<th>Action</th>
			</tr>
			<c:forEach var="customer" items="${customerList}">
				<tr>
					<td><c:out value="${customer.id}" /></td>
					<td><c:out value="${customer.f}" /></td>
					<td><c:out value="${customer.l}" /></td>
					<td><c:out value="${customer.a}" /></td>
					<td>
						<a	href="CustomerController?id=<c:out value='${customer.id}' />&act=showEditForm">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; 
						<a	href="CustomerController?id=<c:out value='${customer.id}' />&act=deleteCustomer">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>




</body>
<html></html>

</body>
</html>