<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application</title>
</head>

<body>

	<h2 align="center"> Welcome Page </h2>
	<hr style="border: 1px dashed blue;">
	
	<form action="/Session/LoginServlet" method="post">
		<pre>
		
		Username : <input type="text" name="username">
		<br>
		Password : <input type="text" name="password">
		<br>
				   <button type="submit"> Submit </button>
		
		</pre>
	</form>

</body>
</html>