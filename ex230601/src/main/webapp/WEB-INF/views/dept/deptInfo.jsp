<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="frm" action="deptUpdate" method="get">
	<div>
		<label for="id">부서번호</label>
		<input type="number" id="id" name="departmentId" value="${dept.departmentId }" readonly="readonly">
	</div>
	<div>
		<label for="name">부서이름</label>
		<input type="text" id="name" name="departmentName" value="${dept.departmentName }" readonly="readonly">
	</div>
	<div>
		<label for="mid">매니저번호</label>
		<input type="number" id="mid" name="managerId" value="${dept.managerId }" readonly="readonly">
	</div>
	<div>
		<label for="lid">지역번호</label>
		<input type="number" id="lid" name="locationId" value="${dept.locationId }" readonly="readonly">
	</div>
	<button type="submit">수정</button>
	<button type="button" onclick="location.href='deptList'">목록</button>
</form>
<script>
	let result="${updateRes}";
	if(result !=""&& result!=null){
		result=JSON.parse(result);
		let msg=`결과 : ${result.result} \n 
				 성공 : ${result.success}\n
				 대상 : ${result.deptList[0]}`;
		alert(msg);
	}
	
	/* document.querySelector('button[type="submit"]').addEventListener('click',function(e){
		let data = [{
				'departmentId':frm.departmentId.value,
				'departmentName':frm.departmentName.value,
				'managerId':frm.managerId.value,
				'locationId':frm.locationId.value
		}]
		fetch('deptUpdate',{
			method:'POST',
			headers:{
				'content-type':'application/json'
			},
			body:JSON.stringify(data)
		})
		.then(response=>response.text())
		.then(result=>console.log(result))
		.catch(err=>console.log(err));
		/* .then(response =>response.json())
		.then(result=>{
			if(result !=""&& result!=null){
				result=JSON.parse(result);
				let msg=`결과 : ${result.result} \n 
						 성공 : ${result.success}\n
						 대상 : ${result.deptList[0]}`;
				alert(msg);
			}
		})
		.catch(err=>console.log(err)); */
	}) */
</script>
</body>
</html>