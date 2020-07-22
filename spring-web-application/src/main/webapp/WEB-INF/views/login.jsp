<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<!-- My name is ${name} and password is ${password} -->
<p><font color="red">${errormsg}</font></p>
<form action="/login" method="post">
Enter Name: <input type="text" name="name"/>
Enter Password: <input type="password" name="password"/>
<input type="submit" value="Login"/>
</form>
</body>
</html>