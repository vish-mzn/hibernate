<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In Page</title>
</head>

<body>
	<h2 style="background-color:rgb(0,0,255)">Sign In Page</h2>
	<br><br>

	<form action="SignInServlet" method="post">
		Enter Email Address : &nbsp <input type="text" name="email"><br><br>
		Enter Password : &nbsp <input type="text" name="password"><br><br>
		<button type="submit" name="signIn">Sign In</button>
	</form>

</body>
</html>