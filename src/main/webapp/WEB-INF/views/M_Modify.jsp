<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정 페이지</title>
</head>
<body>

<%-- 	<table>
		<caption>회원 수정 페이지</caption>
		
		<tr>
			<th>아이디</th>
			<td>${modify.memId}</td>
		</tr>

		<tr>
			<th>비밀번호</th>
			<td>${modify.memPw}</td>
		</tr>

		<tr>
			<th>이름</th>
			<td>${modify.memName}</td>
		</tr>

		<tr>
			<th>생년월일</th>
			<td>${modify.memBirth}</td>
		</tr>

		<tr>
			<th>성별</th>
			<td>${modify.memGender}</td>
		</tr>

		<tr>
			<th>이메일</th>
			<td>${modify.memEmail}</td>
		</tr>

		<tr>
			<th>연락처</th>
			<td>${modify.memPhone}</td>
		</tr>
	</table> --%>
	
	<form action="mModify" method="POST">
		<input type="hidden" name="memId" value="${modify.memId}"/> <br/>
		비밀번호 :		<input type="password"	name="memPw" /> <br/> 
		이름 :		<input type="text"		name="memName" placeholder="${modify.memName}"/> <br/>
		생년월일 :		<input type="date"		name="memBirth" /> <br/>
		성별 : 남성	<input type="radio"		name="memGender" value="남"/> 
			  여성 	<input type="radio" 	name="memGender" value="여"/> <br/>
		이메일 :		<input type="email"		name="memEmail" /> <br/>
		연락처 :		<input type="text"		name="memPhone" /> <br/>
		<input type="submit" value="수정"/>
	</form>
</body>
</html>