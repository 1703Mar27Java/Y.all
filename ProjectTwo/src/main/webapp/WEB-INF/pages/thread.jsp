<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Thread</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://blackrockdigital.github.io/startbootstrap-3-col-portfolio/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://blackrockdigital.github.io/startbootstrap-3-col-portfolio/css/3-col-portfolio.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/imageboard.css" />">

<style>
form {
	float: none;
	margin-left: 30px;
}
</style>
</head>
<body>
	<form method="POST" action="reply" enctype="multipart/form-data">
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
				<td><textarea name="comment" rows="3" cols="20"></textarea></td>
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
	<a href="/ProjectTwo/board/catalog">Return to Catalog</a>

	<table border="1px solid black">
		<tr>
			<td rowspan="3"><c:if test="${op.getImage() != null}">
					<a target="_blank" href="/ProjectTwo/board/img/${op.getId()}">
						<img src="/ProjectTwo/board/thmb/${op.getId()}" />
					</a>
				</c:if></td>
			<td><c:out value="${op.getId()}" /></td>
			<td><c:out value="${op.getName()}" /></td>
			<td><c:out value="${op.getSubject()}" /></td>
			<td><c:out value="${op.getTimeFormatted()}" /></td>
			<td>
				<form method="POST" action="flagPost">
					<input name="postId" type="hidden" value="${op.getId()}" /> <input
						type="submit" value="Flag" />
				</form>
			</td>
		</tr>
		<tr>
			<td rowspan="2" colspan="5">${op.getComment()}</td>
		</tr>
		<tr></tr>
	</table>

	<c:forEach var="row" items="${listPosts}">
		<table border="1px solid black">
			<tr>
				<td rowspan="3"><c:if test="${row.getImage() != null}">
						<a target="_blank" href="/ProjectTwo/board/img/${row.getId()}">
							<img src="/ProjectTwo/board/thmb/${row.getId()}" />
						</a>
					</c:if></td>
				<td><c:out value="${row.getId()}" /></td>
				<td><c:out value="${row.getName()}" /></td>
				<td><c:out value="${row.getSubject()}" /></td>
				<td><c:out value="${row.getTimeFormatted()}" /></td>
				<td>
					<form method="POST" action="flagPost">
						<input name="postId" type="hidden" value="${row.getId()}" /> <input
							type="submit" value="Flag" />
					</form>
				</td>
			</tr>
			<tr>
				<td rowspan="2" colspan="5"><c:out value="${row.getComment()}" /></td>
			</tr>
			<tr></tr>
		</table>
	</c:forEach>
</body>
</html>