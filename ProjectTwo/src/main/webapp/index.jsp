<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div id="postForm">
		<h3>Start New Thread</h3>
		<form method="post" action="NewThread" enctype="multipart/form-data">
		<table>
				<tr><td>Name</td><td><input type="text" name="name" /></td></tr>
				<tr><td>Subject</td><td><input type="text" name="subject" /></td></tr>
				<tr><td>Comment</td><td><input type="text" name="comment" /></td></tr>
				<tr><td>Image</td><td><input type="file" name="pic" accept="image/*"></td></tr>
		</table>
				<input type="submit" value="Post" />
		</form>
	</div>
	
	<ul>
	<c:forEach var="row" items="${posts}">
		<li><a target="_blank" href="data:image/png;base64,${row}">
			<img id="pic" src="data:image/png;base64,${row}" style="width:150px;">
			</a>
		</li>
	</c:forEach>
	</ul>
	
</body>
</html>