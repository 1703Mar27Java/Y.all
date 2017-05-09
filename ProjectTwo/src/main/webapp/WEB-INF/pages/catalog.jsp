<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Catalog</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://blackrockdigital.github.io/startbootstrap-3-col-portfolio/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://blackrockdigital.github.io/startbootstrap-3-col-portfolio/css/3-col-portfolio.css">
</head>
<body>
	<h4 style="color: red; float: right;margin=0px">${moderator.getUsername()}</h4>
	<div class="container">
	<h3>Start New Thread</h3>
	<form method="POST" action="catalog" enctype="multipart/form-data">
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

	<div class="row">
	<c:forEach var="row" items="${listThreads}">
	<div class="col-md-4 portfolio-item">
				<a target="_blank" href="/ProjectTwo/board/img/${row.getId()}">
				<img src="/ProjectTwo/board/img/${row.getId()}" style="width:200px;"/></a>
				<h3><c:out value="${row.getName()} ${row.getSubject()}" /></h3>
				<a href="/ProjectTwo/board/thread/${row.getId()}"> Reply </a>
				<p><c:out value="${row.getComment()}" /></p>
	</div>
	</c:forEach>
	</div>
	</div>
</body>
</html>