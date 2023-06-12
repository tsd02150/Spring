<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>부서 조회</h1>
		<a href="deptInsert">등록</a>
		<button type="button" id="checkDel">선택삭제</button>
		<table>
			<thead>
				<tr>
					<th><input type="checkbox" /></th>
					<th>부서번호</th>
					<th>부서명</th>
					<th>매니저번호</th>
					<th>지역번호</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${deptList }" var="dept">
					<tr onclick="findDeptInfo(event,${dept.departmentId})">
					<%-- <tr onclick="location.href='deptInfo?departmentId=${dept.departmentId}'"> --%>
						<td><input type="checkbox" /></td>
						<td>${dept.departmentId }</td>
						<td>${dept.departmentName }</td>
						<td>${dept.managerId }</td>
						<td>${dept.locationId }</td>
						<td><button type="button" onclick="deleteCheck(${dept.departmentId})">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form name="del" action="deptDelete" method="POST">
		
		</form>
	</div>
	<script>

		function findDeptInfo(event,deptNo){
			if(event.target.tagName !='INPUT' && event.target.tagName !='BUTTON')
				location.href='deptInfo?departmentId='+deptNo;
			
			/* 
			event.target; // 실제 이벤트가 발생한 태그 : 고정값
			event.currentTarget; // this와 같은 의미-> 지금 해당 이벤틍에 대해 동작을 하는 태그
			event.preventDefault(); // 기본으로 등록된 이벤트 동작을 막음
			event.stopPropagation(); // 이벤트 버블링(전파)를 막음
			 */
		}
		
		document.getElementById('checkDel').addEventListener('click',function(e){
			let checked = document.querySelectorAll('input[type="checkbox"]:checked');
			for(let i=0;i<checked.length;i++){
				let deptNo = checked[i].parentElement.nextElementSibling.textContent;
				insertDeptInfo(i,deptNo);
			}
			del.submit();
		})
		
		function insertDeptInfo(index,deptNo){
			let inputTag = document.createElement('input');
			inputTag.type='hidden';
			inputTag.name='deptList['+index+'].departmentId';
			inputTag.value=deptNo;
			
			let formTag = document.getElementsByName('del')[0];
			formTag.append(inputTag);
		}
		
		function deleteCheck(deptNo){
			/* event.stopPropagation(); */
			insertDeptInfo(0,deptNo);
			del.submit();
		}
	</script>
</body>
</html>