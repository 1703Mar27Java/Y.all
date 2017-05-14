<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://blackrockdigital.github.io/startbootstrap-3-col-portfolio/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://blackrockdigital.github.io/startbootstrap-3-col-portfolio/css/3-col-portfolio.css">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/imageboard.css" />">
<title>Flagged Posts</title>
</head>
<body>
	<div id="nav">
		<ul>
			<li><a href="/ProjectTwo/board/index"><img src="<c:url value="/resources/static-images/merjpostSmall.png" />" style="max-height:30px;"></a></li>
			<li><a href="/ProjectTwo/board/catalog">Catalog</a></li>
			<c:if test="${moderator.exists()}">
				<li style="float: right"><a href="/ProjectTwo/board/logout">Logout</a></li>
				<li style="float: right"><a class="active"
					href="/ProjectTwo/board/modFlags">Flags</a></li>
				<li><a>Logged in as Moderator</a></li>
			</c:if>
			<c:if test="${!moderator.exists()}">
				<li style="float: right"><a href="/ProjectTwo/board/modLogin">Admin Login</a></li>
			</c:if>
			<li style="float: right"><a id="currentTime"></a></li>
		</ul>
	</div>
	<div class="row">
			<c:forEach var="row" items="${flaggedPosts}">
				<div class="col-md-4 portfolio-item" style="max-height:375px; max-width:300px;overflow:hidden;float:left;">
				<center>
					<a target="_blank" href="/ProjectTwo/board/img/${row.getId()}">
					<img src="/ProjectTwo/board/thmb/${row.getId()}" /></a><br/>
					<a id="ignore" href="/ProjectTwo/board/thread/${row.getId()}/unflag">
						<img src="<c:url value="/resources/static-images/ignore.png" />" style="max-width:30px;">
					</a>
					<a id="edit" href="/ProjectTwo/board/thread/${row.getId()}/edit">
						<img src="<c:url value="/resources/static-images/edit.png" />" style="max-width:20px;">
					</a>
					<a id="delete" href="/ProjectTwo/board/thread/${row.getId()}/delete">
						<img src="<c:url value="/resources/static-images/delete.png" />" style="max-width:20px;">
					</a>
					<h3><c:out value="${row.getSubject()}" /></h3>
					<p><c:out value="${row.getComment()}" /></p>
				</center>
				</div>
			</c:forEach>
	</div>
</body>
</html>