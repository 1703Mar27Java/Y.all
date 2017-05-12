<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/imageboard.css" />">
<style>
img{
	position:absolute;
	top:100px;
	left:26%;
	z-index:-1;
	display:block;
}
a{
	position:relative;
	left:33%;
	top:360px;
	z-index:2;
}
</style>
</head>
<body>
<img src="<c:url value="/resources/static-images/merjpost5.png" />" alt="Since 2017">
<a href="modLogin" class="button">Moderator Login</a><a href="catalog" class="button">View Catalog</a>
</body>
</html>