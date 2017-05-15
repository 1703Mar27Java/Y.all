<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm</title>
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
			<li><a href="/ProjectTwo/board/index"><img src="<c:url value="/resources/static-images/merjpostSmall.png" />" style="max-height:30px;"></a></li>
			<li><a href="/ProjectTwo/board/catalog">Catalog</a></li>
			<li><a>-> Thread No. <c:out value="${threadId}" /> <c:out
						value="${op.getSubject()}" /></a></li>
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
		</ul>
	</div>

	<table id="${reported.getId()}" border="1px solid black">
		<tr>
			<td height="150px" width="150px" align="center" rowspan="3"><c:if
					test="${reported.getImage() != null}">
					<a target="_blank" href="/ProjectTwo/board/img/${reported.getId()}">
						<img src="/ProjectTwo/board/thmb/${reported.getId()}" />
					</a>
				</c:if></td>
			<td><c:out value="${reported.getName()}" /> <c:if
					test="${reported.getName() == null}">Anonymous</c:if></td>
			<td><c:out value="${reported.getSubject()}" /></td>
			<td><c:out value="${reported.getTimeFormatted()}" /></td>
			<td class="postRow" data-post="${reported.getId()}">No. <c:out
					value="${reported.getId()}" /></td>
		</tr>
		<tr>
			<td id="postComment" rowspan="2" colspan="5"><c:out
					value="${reported.getComment()}" /></td>
		</tr>
		<tr></tr>
	</table>

	<c:if test="${action == 'report'}">
		<form method="POST" action="/ProjectTwo/board/thread/flagPost">
			<input name="postId" type="hidden" value="${reported.getId()}" /> <input
				type="submit" value="Confirm Report" />
		</form>
	</c:if>

	<c:if test="${action == 'delete'}">
		<form method="POST"
			action="/ProjectTwo/board/thread/${reported.getId()}/delete">
			<input type="submit" value="Confirm Delete" />
		</form>
	</c:if>
</body>
</html>