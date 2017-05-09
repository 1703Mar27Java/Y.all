<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thread</title>
</head>
<body>
	<form method="POST" action="reply" modelAttribute="post"
		enctype="multipart/form-data">
		<input name="parent" type="hidden" value="${threadId}" />
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
				<td><textarea type="text" name="comment" rows="3" cols="20"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Post" /></td>
			</tr>
		</table>
	</form>

	<table border="1px solid black">
		<tr>
			<td rowspan="2"><a target="_blank" href="/ProjectTwo/board/img/${op.getId()}">
				<img src="/ProjectTwo/board/thmb/${op.getId()}" /></a></td>
			<td><c:out value="${op.getName()} ${op.getSubject()}" /></td>
		</tr>
		<tr>
			<td>${op.getComment()}</td>
		</tr>
	</table>

	<c:forEach var="row" items="${listPosts}">
		<table border="1px solid black">
			<tr>
				<td rowspan="2"><a target="_blank" href="/ProjectTwo/board/img/${row.getId()}">
				<img src="/ProjectTwo/board/thmb/${row.getId()}" /></a></td>
				<td><c:out value="${row.getName()} ${row.getSubject()}" /></td>
			</tr>
			<tr>
				<td><c:out value="${row.getComment()}" /></td>
			</tr>
		</table>
	</c:forEach>
	<p>
		<a href="/ProjectTwo/board/catalog">Return to Catalog</a>
	</p>
</body>
</html>