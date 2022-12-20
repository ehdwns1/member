<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>
table, th, td {
	border: 1px solid;
	border-collapse: collapse;
	padding: 10px;
}
</style>
</head>
<body>

<h1>회원목록</h1>
	<table>
		<caption>회원정보 상세보기</caption>

		<tr>
			<th>아이디</th>
			<td>${view.memId}</td>
		</tr>
		
		<tr>
			<th>이름</th>
			<td>${view.memName}</td>
		</tr>

		<tr>
			<th>생년월일</th>
			<td>${view.memBirth}</td>
		</tr>

		<tr>
			<th>성별</th>
			<td>${view.memGender}</td>
		</tr>

		<tr>
			<th>이메일</th>
			<td>${view.memEmail}</td>
		</tr>

		<tr>
			<th>연락처</th>
			<td>${view.memPhone}</td>
		</tr>
		
		<tr>
			<th>주소</th>
			<td>${view.memAddr}</td>
		</tr>
		
		<tr>
			<th>프로필사진</th>
			<td>${view.memProfileName}</td>
		</tr>
	</table>
</body>
</html>