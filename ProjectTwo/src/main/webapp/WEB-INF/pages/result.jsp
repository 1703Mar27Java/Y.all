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
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/imageboard.css" />">
<title>Result</title>
<script type="text/javascript">
            function Redirect() {
               window.location="/ProjectTwo/board/${url}";
            }
            setTimeout('Redirect()', 2000);
      </script>
</head>
<body>
	<h1>${message}</h1>
	<p>
		Redirecting <a id="link" href="/ProjectTwo/board/${url}">(or click
			to continue)</a>
	</p>
</body>
</html>