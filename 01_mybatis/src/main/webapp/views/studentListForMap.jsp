<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>학생 정보</h3>
	
	<c:if test="${empty list}">
		조회된 학생이 없습니다.	
	</c:if>
	
	<c:if test="${!empty list}">
		총 ${fn:length(list)}명의 학생이 조회되었습니다. <br>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>가입일</th>
			</tr>
				<c:forEach var="map" items="${list}">
					<tr>
						<td>${map.STUDENT_NO}</td>
						<td>${map.STUDENT_NAME}</td>
						<td>${map.STUDENT_TEL}</td>
						<td>${map.STUDENT_EMAIL}</td>
						<td>${map.STUDENT_ADDR}</td>
						<td>${map.REG_DATE}</td>
					</tr>
					<tr>
						<td>${map['STUDENT_NO']}</td>
						<td>${map['STUDENT_NAME']}</td>
						<td>${map['STUDENT_TEL']}</td>
						<td>${map['STUDENT_EMAIL']}</td>
						<td>${map['STUDENT_ADDR']}</td>
						<td>${map['REG_DATE']}</td>
					</tr>
				</c:forEach>
		</table>
	</c:if>


</body>
</html>