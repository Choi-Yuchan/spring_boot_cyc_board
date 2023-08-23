<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- C태그 쓰기 위해 넣은 taglib므로 반드시 확인 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserHome</title>
</head>
<body>
	<h1>userHome Page</h1>

	<sec:authorize aceess="isAuthenticated()">
		<p>
			principal:
			<sec:authentication property="principal" />
		</p>
		<h3>
			<sec:authentication property="principal.username" />
			님 환영합니다.
		</h3>
		<p>
			<a href="<c:url value="/" />">홈</a>
		</p>
	</sec:authorize>
	
 


</body>
</html>