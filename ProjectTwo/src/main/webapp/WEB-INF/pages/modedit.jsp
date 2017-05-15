<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Post</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/imageboard.css" />">
</head>
<body>
	<form method="POST" action="edit">
		<input type="text" name="name" placeholder="Anonymous" value="${post.name}"><br/>
		<input type="text" name="subject" value="${post.subject}"/><br/>
		<textarea name="comment" value="${post.comment}"></textarea>
		<input type="submit" value="Commit">
	</form>

</body>
</html>