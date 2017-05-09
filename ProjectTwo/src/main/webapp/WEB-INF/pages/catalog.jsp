<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Catalog</title>
<link rel="stylesheet" href="https://blackrockdigital.github.io/startbootstrap-3-col-portfolio/css/bootstrap.min.css">
<link rel="stylesheet" href="https://blackrockdigital.github.io/startbootstrap-3-col-portfolio/css/3-col-portfolio.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
		<body>
		<div class="container">
			<h4 style="color: red; float: right;margin=0px">${moderator.getUsername()}</h4>
			<h3>Start New Thread</h3>
			<form:form method="POST" action="catalog" modelAttribute="post" enctype="multipart/form-data">
			<table>
					<tr>
						<td>Name:</td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td>Subject:</td>
						<td><form:input path="subject" /></td>
					</tr>
					<tr>
						<td>Comment:</td>
						<td><form:textarea path="comment" rows="3" cols="20" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="file" name="image" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Post" /></td>
					</tr>
				</table>
			</form:form>
			
			<div class="row">
			<c:forEach var="row" items="${listThreads}">
				<div class="col-md-4 portfolio-item">
					<a target="_blank" href="data:image/png;base64,${row.getImageString()}">
						<img src="data:image/png;base64,${row.getImageString()}" style="width:200px;">
					</a>
					<h3>${row.getName()}:</h3> 
					<a href="/ProjectTwo/board/thread/${row.getId()}">${row.getSubject()}</a>
				</div>
			</c:forEach>
			</div>
		</body>
</html>