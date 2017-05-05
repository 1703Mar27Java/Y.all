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
	<form:form method="POST" action="addPost" enctype="multipart/form-data" >
		<table>
				<tr><td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" type="text" name="name" /></td>
				</tr>
				<tr><td><form:label path="subject">Subject</form:label></td>
					<td><form:input path="subject" type="text" name="subject" /></td>
				</tr>
				<tr><td><form:label path="comment">Comment</form:label></td>
					<td><form:input path="comment" type="text" name="comment" /></td>
				</tr>
				<tr><td><form:label path="image">Image</form:label></td>
					<td><form:input path="image" type="file" name="pic" accept="image/*"/></td>
				</tr>
				<form:input type="hidden" path="threadid" value="${threadID}"/>
		</table>
				<input type="submit" value="Post" />
	</form:form>
	
	<table>
<<<<<<< HEAD
		<tr>
			<th>Name</th>
			<th>Subject</th>
			<th>Comment</th>
		</tr>

		<c:forEach var="row" items="${listPosts}">
=======
		<c:forEach var="row" items="${filtered}">
>>>>>>> 606f64ab1555031fdf962af3d923ee5465cc03ca
			<tr>
				<td><a target="_blank" href="data:image/png;base64,${row.getImageString()}">
				<img id="pic" src="data:image/png;base64,${row.getImageString()}" style="width:150px;">
				</a></td>
				<td><c:out value="${row.getName()}" /></td>
				<td><c:out value="${row.getSubject()}" /></td>
				<td><c:out value="${row.getComment()}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>