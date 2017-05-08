<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalog</title>
</head>
<body>
<h3>Start New Thread</h3>		
	<form:form method="POST" action="catalog" modelAttribute="post">
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
				<td colspan="2" align="center"><input type="submit"
					value="Post" /></td>
			</tr>
		</table>
	</form:form>
	<c:forEach var="row" items="${listThreads}">
		<table border="1px solid black">
			<tr>
				<td rowspan="2"><c:out value="${row.getImage()}" /></td>
				<td><c:out
						value="${row.getName()} ${row.getSubject()}" /><a
					href="/ProjectTwo/board/thread/${row.getId()}"> Reply </a></td>
			</tr>
			<tr>
				<td><c:out value="${row.getComment()}" /></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>