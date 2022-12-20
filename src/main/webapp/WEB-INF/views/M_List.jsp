<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>
	table, td, th{
		border : 1px solid black;
		border-collapse : collapse;
		padding : 10px;
	}
</style>
</head>
<body>
	<h1>회원목록</h1>
	<table>
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>생년월일</td>
			<td>성별</td>
			<td>이메일</td>
			<td>연락처</td>
			<td>수정</td>
			<td>삭제</td>

		</tr>
		
		<c:forEach var="list" items="${memberList}">
		<tr>
			<td><a href="mView?memId=${list.memId}">${list.memId}</a></td>
			<td>${list.memName}</td>
			<td>${list.memBirth}</td>
			<td>${list.memGender}</td>
			<td>${list.memEmail}</td>
			<td>${list.memPhone}</td>
			<td><button onclick="location.href='mModiForm?memId=${list.memId}'">수정</button></td>
			<td><button onclick="location.href='mDelete?memId=${list.memId}'">삭제</button></td>

		</tr>
		
		</c:forEach>
		
		
	
	</table>
</body>
</html>