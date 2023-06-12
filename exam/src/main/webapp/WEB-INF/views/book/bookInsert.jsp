<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>도서 등록</h3>
<form name="insertForm" action="bookInsert" method="post">
	<table>
		<tr>
			<th>도서번호</th>
			<td><input type="number" name="bookNo" value="${bookNo }" readonly> </td>
		</tr>
		<tr>
			<th>도서명</th>
			<td><input type="text" name="bookName"> </td>
		</tr>
		<tr>
			<th>도서표지</th>
			<td><input type="text" name="bookCoverimg"> </td>
		</tr>
		<tr>
			<th>출판일자</th>
			<td><input type="text" name="bookDate"> </td>
		</tr>
		<tr>
			<th>금액</th>
			<td><input type="text" name="bookPrice"> </td>
		</tr>
		<tr>
			<th>출판사</th>
			<td><input type="text" name="bookPublisher"> </td>
		</tr>
		<tr>
			<th>도서소개</th>
			<td><textarea name="bookInfo" rows="2" cols="3" style="width:400px"></textarea> </td>
		</tr>
	</table>
	<button type="submit">등록</button>
	<button type="button" onclick="location.href='bookList'">조회</button>
</form>
<script>
	document.querySelector('form[name="insertForm"]').addEventListener('submit',function(e){
		e.preventDefault();
		let name= document.getElementsByName('bookName')[0];
		if(name.value==''){
			alert('도서명이 입력되지 않았습니다.');
			name.focus();
			return;
		}
		
		alert('도서등록이 완료되었습니다.');
		insertForm.submit();
	})
</script>
</body>
</html>