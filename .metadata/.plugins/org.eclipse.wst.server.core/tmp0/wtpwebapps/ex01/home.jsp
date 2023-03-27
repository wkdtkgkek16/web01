<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="home.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="div_menu">
		<a href="/">home</a>
		<a href="/posts">posts</a>
		<a href="/login">login</a>
		<a href="/users">users</a>
	</div>
	<hr/>
	<jsp:include page="${pageName}"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>