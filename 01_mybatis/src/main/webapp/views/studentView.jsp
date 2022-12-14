<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>학생 정보</h3>
	
<%-- <c:if test="${s == null}">--%>
	<c:if test="${empty s}">
		조회된 학생이 없습니다.	
	</c:if>
	
	<c:if test="${!empty s}">
		<table border="1">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>가입일</th>
			</tr>
			<tr>
				<td>${s.no}</td>
				<td>${s.name}</td>
				<td>${s.tel}</td>
				<td>${s.email}</td>
				<td>${s.address}</td>
				<td>${s.regDate}</td>
			</tr>
		</table>
	</c:if>


</body>
</html>