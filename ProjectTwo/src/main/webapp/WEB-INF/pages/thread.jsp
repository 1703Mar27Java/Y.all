<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<<<<<<< HEAD
<title>Index</title>
</head>
<body>

=======
<title>Thread</title>
</head>
<body>
	<form:form method="post" action="thread/${threadId}" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Subject:</td>
				<td><input type="text" name="subject" /></td>
			</tr>
			<tr>
				<td>Comment:</td>
				<td><input type="text" name="comment" /></td>
			</tr>
			<tr>
				<td>File:</td>
				<td><input type="file" name="image" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Post" /></td>
			</tr>
		</table>
	</form:form>
>>>>>>> UserCreatePost
	<table>
		<tr>
			<th>Name</th>
			<th>Subject</th>
			<th>Comment</th>
		</tr>
<<<<<<< HEAD
=======

		<c:forEach var="row" items="${listPosts}">
			<tr>
				<td><c:out value="${row.getName()}" /></td>
				<td><c:out value="${row.getSubject()}" /></td>
				<td><c:out value="${row.getComment()}" /></td>
			</tr>
		</c:forEach>
>>>>>>> UserCreatePost
	</table>
</body>
</html>