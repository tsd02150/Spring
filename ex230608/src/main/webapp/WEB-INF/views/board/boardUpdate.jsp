<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<form id="form" name="updateForm" onsubmit="return false">
		<div>
			<h3>게시글 수정</h3>
		</div>
		<table class="table">
			<tr>
				<th>번호</th>
				<td><input name="bno" type="text" value="${board.bno }" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input name="title" type="text" value="${board.title }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input name="writer" type="text" value="${board.writer }" readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents" rows="2" cols="3" style="width:400px">${board.contents }</textarea> </td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input name="image" type="text" value="${board.image }"></td>
			</tr>
			<tr>
				<th>수정날짜</th>
				<td><input name="updatedate" type="date" value="<fmt:formatDate value="${board.updatedate }" pattern="yyyy-MM-dd" />" ></td>
			</tr>
		</table>
		<button type="submit">수정완료</button>
		<button type="button" onclick="location.href='boardInfo?bno=${board.bno}'">취소</button>
	</form>
	<script>
		document.querySelector('button[type="submit"]').addEventListener('click',function(e){
			let board = new FormData(document.querySelector('form[name="updateForm"]'));
			console.log(board);
			fetch('boardUpdate',{
				method:'POST',
 				body:board
			})
			.then(response=>response.json())
			.then(result=>{
				if(result.result=='success'){
					alert("성공!"+
						"\n------------------------------"+
						"\nboardNo : "+result.boardInfo.bno+
						"\ntitle : "+result.boardInfo.title+
						"\ncontents : "+result.boardInfo.contents+
						"\nupdatedate : "+result.boardInfo.updatedate+
						"\nimage : "+result.boardInfo.image+
						"\n------------------------------");
					location.href='boardInfo?bno='+result.boardInfo.bno;
				}else{
					alert("실패!");
				}
			})
			.catch(err=>console.log(err));
		})
/* 		document.querySelector('button[type="submit"]').addEventListener('click',function(e){
			let board={
				'bno':updateForm.bno.value,
				'title':updateForm.title.value,
				'writer':updateForm.writer.value,
				'contents':updateForm.contents.value,
				'image':updateForm.image.value,
				'updatedate':updateForm.updatedate.value
			}

			fetch('boardUpdate',{
				method:'POST',
				headers:{
					'content-type':'application/json'
				},

 				body:JSON.stringify(board) 
			})
			.then(response=>response.json())
			.then(result=>{
				if(result.result=='success'){
					alert("성공!"+
						"\n------------------------------"+
						"\nboardNo : "+result.boardInfo.bno+
						"\ntitle : "+result.boardInfo.title+
						"\ncontents : "+result.boardInfo.contents+
						"\nupdatedate : "+result.boardInfo.updatedate+
						"\nimage : "+result.boardInfo.image+
						"\n------------------------------");
					location.href='boardList';
				}else{
					alert("실패!");
				}
			})
			.catch(err=>console.log(err));
		}) */
	</script>
</body>
</html>