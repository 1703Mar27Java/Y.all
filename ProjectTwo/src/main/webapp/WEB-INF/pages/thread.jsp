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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<style>
form {
	float: none;
	margin-left: 30px;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
}

.show {
	display: block;
}
</style>
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
			<li style="float: right"><a id="currentTime"></a></li>
		</ul>
	</div>

	<div class="postForm">
		<form method="POST" action="/ProjectTwo/board/post"
			enctype="multipart/form-data">
			<h3>Reply to Thread</h3>
			<input name="parent" type="hidden" value="${threadId}" />
			<table>
				<tr>
					<td>Name:</td>
					<td><input placeholder="Anonymous" type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Subject:</td>
					<td><input type="text" name="subject" /></td>
				</tr>
				<tr>
					<td>Comment:</td>
					<td><textarea id="comment" name="comment" rows="3" cols="20"></textarea></td>
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
	</div>

	<c:forEach var="row" items="${listPosts}">
		<table id="${row.getId()}" class="posts">
			<tr>
				<td height="150px" width="150px" align="center" rowspan="3"><c:if
						test="${row.getImage() != null}">
						<a target="_blank" href="/ProjectTwo/board/img/${row.getId()}">
							<img src="/ProjectTwo/board/thmb/${row.getId()}" />
						</a>
					</c:if></td>
				<td><c:out value="${row.getName()}" /> <c:if
						test="${row.getName() == null}">Anonymous</c:if></td>
				<td><c:out value="${row.getSubject()}" /></td>
				<td><c:out value="${row.getTimeFormatted()}" /></td>
				<td class="postRow" data-post="${row.getId()}">No. <c:out
						value="${row.getId()}" /></td>
				<td>
					<div class="dropdown">
						<button onclick="myFunction()" class="dropbtn">Tools</button>
						<div id="myDropdown" class="dropdown-content">
							<a href="/ProjectTwo/board/thread/${row.getId()}/report">Report</a>
							<c:if test="${moderator.exists()}">
								<a href="/ProjectTwo/board/thread/${row.getId()}/edit">Edit</a>
								<a href="/ProjectTwo/board/thread/${row.getId()}/delete">Delete</a>
							</c:if>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td id="postComment" rowspan="2" colspan="5"><c:out
						value="${row.getComment()}" /></td>
			</tr>
			<tr></tr>
		</table>
	</c:forEach>
</body>
<script>
	$(document).ready(
			function() {
				$(".postRow").click(
						function() {
							var post = $(this).data('post');
							var sel = $(this).closest('tr').next('tr').find(
									'td').text();
							var txt = $("#comment");
							if (sel) {
								sel = ">" + sel;
							}
							if (txt.val()) {
								txt.val(txt.val() + "\n")
							}
							txt.val(txt.val() + ">>" + post + "\n" + sel);
						});
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

				$(".dropbtn").click(function() {
					$(this).next().toggleClass("show");
				});
			});

	function myFunction() {
		document.getElementsByClassName("dropdown-content").classList
				.toggle("show");
	}

	window.onclick = function(event) {
		if (!event.target.matches('.dropbtn')) {

			var dropdowns = document.getElementsByClassName("dropdown-content");
			var i;
			for (i = 0; i < dropdowns.length; i++) {
				var openDropdown = dropdowns[i];
				if (openDropdown.classList.contains('show')) {
					openDropdown.classList.remove('show');
				}
			}
		}
	}
</script>
</html>