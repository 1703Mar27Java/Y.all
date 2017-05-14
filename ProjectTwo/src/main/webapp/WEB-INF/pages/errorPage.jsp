<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/imageboard.css" />">
<style>
img{
	position:absolute;
	top:100px;
	left:28%;
	z-index:-1;
	display:block;
}
a{
	position:relative;
	left:45%;
	top:400px;
	z-index:2;
}
</style>
</head>
<body>
	<c:if test="${errorCode == 404}">
		<img src="<c:url value="/resources/static-images/merjpost404.png" />"/>
	</c:if>
	<c:if test="${errorCode == 400}">
		<img src="<c:url value="/resources/static-images/merjpost400.png" />"/>
	</c:if>
	<c:if test="${errorCode == 500}">
		<img src="<c:url value="/resources/static-images/merjpost500.png" />"/>
	</c:if>
	<c:if test="${errorCode == 401}">
		<img src="<c:url value="/resources/static-images/merjpost401.png" />"/>
	</c:if>
	<a href="/ProjectTwo/board/catalog" class="button">Catalog</a>
</body>
</html>