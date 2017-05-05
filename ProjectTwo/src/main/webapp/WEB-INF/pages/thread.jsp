<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="java.util.*"%>
<%@page import="com.revature.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=ISO-8859-1"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Thread</title>
</head>
<body>
	<div id="postForm">
		<h3>Start New Thread</h3>
		<form:form method="POST" action="addPost" commandName="post" enctype="multipart/form-data">
			<p>
				<form:label path="name">Name</form:label>
				<form:input path="name" />
			</p>
			<p>
				<form:label path="subject">Subject</form:label>
				<form:input path="subject" />
			</p>
			<p>
				<form:label path="comment">Comment</form:label>
				<form:input path="comment" />
			</p>
			<div id="imageUpload">
				Browse <input type="file" name="pic" accept="image/*">
			</div>
			<input type="submit" value="Post" />
		</form:form>
	</div>
	
	<table>
	<tr>
		<th>Name</th>
		<th>Subject</th>
		<th>Comment</th>
	</tr>

	<c:forEach var="row" items="${filtered}">
		<tr>
			<td><c:out value="$ ${row.getR_AMOUNT()}" /></td>
			<td><c:out value="${row.getR_DESCRIPTION()}" /></td>
			<td><c:out value="${row.formatSubmitted()}" /></td>
			<td><c:out value="${row.getU_ID_AUTHOR()}" /></td>
			<td><c:out value="${row.formatResolved()}" /></td>
			<td><c:out value="${row.getU_ID_RESOLVER()}" /></td>
			<td><c:out value="${row.getRT_TYPE()}" /></td>
			<td><c:out value="${row.getRT_TYPE()}" /></td>
			<form method="post" action="Resolve">
				<td><select name="status">
						<option value="2">Approve</option>
						<option value="3">Deny</option>
				</select>
				<input type="hidden" name="crid" value="${row.getR_ID()}" /></td>
				<td><input type="submit" value="Resolve" /></td>
			</form>
		</tr>
	</c:forEach>
</table>
</body>
</html>