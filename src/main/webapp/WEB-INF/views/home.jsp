<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- C태그 쓰기 위해 넣은 taglib므로 반드시 확인 --> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
   <h1>Main Page</h1>
   
      <!-- 로그인을 했다면 -->
   <sec:authorize access="isAuthenticated()">
   
      <sec:authentication property="principal.username"/> 님 환영합니다.
      <%-- <h1>${auth.username}</h1> --%>
   </sec:authorize>
   
   <sec:authorize access="isAnonymous()">      
      로그인이 필요합니다.         
   </sec:authorize>
</body>
</html>