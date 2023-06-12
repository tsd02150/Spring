<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 조회</title>
</head>
<body>
	<table class="table">
		<tr>
			<th>번호</th>
			<td>${board.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="2" style="width: 400px;" readonly>${board.contents }</textarea></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td>
				<c:choose>
					<c:when test="${not empty board.image }">
						<img alt="첨부파일" src='<c:url value="/resources/image/${board.image }" />'> 
					</c:when>
					<c:otherwise>
						파일 없음
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
		</tr>
	</table>
	<button type="button" onclick="location.href='boardUpdate?bno=${board.bno}'">수정</button>
	<button type="button" onclick="location.href='boardDelete?bno=${board.bno}'">삭제</button>
</body>
</html>