<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application</title>
</head>

<body>
	<h3>Welcome <% String name = (String)session.getAttribute("name");
					out.println(name);%>
	</h3>
	<h3>You are Logged In successfully</h3>
	<h4> <a href="logout.jsp"> Logout </a> </h4>

</body>
</html>