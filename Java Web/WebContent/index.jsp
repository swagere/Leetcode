<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8080/Java_Web/servletDemo" method="post">
		<input type="submit" value="直接实现Servlet-post">
	</form>
	<br/>
	<form action="http://localhost:8080/Java_Web/servletDemo" method="get">
		<input type="submit" value="直接实现Servlet-get">
	</form>
	<br/>
	<form action="http://localhost:8080/Java_Web/httpServletDemo" method="post">
		<input type="submit" value="继承HttpServlet-post">
	</form>
	<br/>
	<form action="http://localhost:8080/Java_Web/httpServletDemo" method="get">
		<input type="submit" value="继承HttpServlet-get">
	</form>
</body>
</html>