<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- C태그 쓰기 위해 넣은 taglib므로 반드시 확인 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content View</title>
</head>
<body>
	<form id="updateForm" action="modify" method="post">
		<input id="input_bid" type="hidden" name="bid"
			value="${content_view.bid}">
		<table width="700" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>번호</td>
				<td>${content_view.bid}</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${content_view.bhit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input id="input_bname" type="text" name="bname"
					value="${content_view.bname}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input id="input_btitle" type="text" name="btitle"
					value="${content_view.btitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea id="input_bcontent" rows="10" name="bcontent">${content_view.bcontent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">
					&nbsp;&nbsp; <a href="list">목록보기</a> &nbsp;&nbsp; <a
					href="delete?bid=${content_view.bid}">삭제</a> &nbsp;&nbsp; <a
					href="reply_view?bid=${content_view.bid}">답변</a></td>
			</tr>
		</table>
	</form>

</body>
</html>