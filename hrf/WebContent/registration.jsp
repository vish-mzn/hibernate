<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration page</title>
</head>

<body>
	<h2 style="background-color:rgb(0,0,255)">Registration Page</h2>
	<br><br>

	<form action="RegistrationServlet" method="post">
		First Name : &nbsp <input type="text" name="fname"><br><br>
		Last Name : &nbsp <input type="text" name="lname"><br><br>
		Email Address : &nbsp <input type="text" name="email"><br><br>
		Password : &nbsp <input type="text" name="password"><br><br>
		<button type="submit" name="register">Okay</button>
	</form>

</body>
</html>