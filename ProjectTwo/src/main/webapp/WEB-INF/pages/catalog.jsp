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
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/imageboard.css" />">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

</head>
<body>
	<div id="nav">
		<ul>
			<li><a href="catalog">Catalog</a></li>
			<c:if test="${moderator.exists()}">
				<li style="float: right"><a href="/ProjectTwo/board/logout">Logout</a></li>
				<li style="float: right"><a class="active"
					href="/ProjectTwo/board/modFlags">Flags</a></li>
				<li><a>Logged in as Moderator</a></li>
			</c:if>
			<c:if test="${!moderator.exists()}">
				<li style="float: right"><a href="/ProjectTwo/board/modLogin">Admin
						Login</a></li>
			</c:if>
			<li style="float: right"><a id="currentTime"></a></li>
		</ul>
	</div>

	<div class="container-fluid">
		<form method="POST" action="post" enctype="multipart/form-data">
			<h3>Start New Thread</h3>
			<input name="parent" type="hidden" value="0" />
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
				<div class="col-md-3 portfolio-item"
					style="max-height: 325px; max-width: 300px; overflow: hidden; float: left;">
					<center>
						<a target="_blank" href="/ProjectTwo/board/img/${row.getId()}">
							<img src="/ProjectTwo/board/thmb/${row.getId()}" />
						</a><br /> <a href="/ProjectTwo/board/thread/${row.getId()}"
							class="button">Reply</a>

						<p>
						<h3>
							<c:out value="${row.getSubject()}" />
						</h3>
						<c:out value="${row.getComment()}" />
						</p>
					</center>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
<script>
	$(document).ready(
			function() {
				setInterval(function() {
					var chour = new Date().getHours();
					if (chour > 12)
						chour -= 12;
					var cmin = new Date().getMinutes();
					if (cmin < 10)
						cmin = '0' + cmin;
					var csec = new Date().getSeconds();
					if (csec < 10)
						csec = '0' + csec;
					$("#currentTime").html(
							chour
									+ ":"
									+ cmin
									+ ":"
									+ csec
									+ " "
									+ (new Date().getHours() <= 12 ? 'AM'
											: 'PM'));
				}, 1000);
			});
</script>
</html>