<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>마이바티스(MyBatis)</h2>
	- 개발자가 사용할 SQL, 저장프로시저 그리고 고급 매핑을 지원하는 프레임워크<br>
	- 마이바티스는 JDBC로 처리해야하는 상당부의 코드부를 xml 파라메터 설정을 통해 자동으로 매핑이 가능하게끔 해준다
	 -> 개발 생산성, 효율성 향상과 우수한 코드 품질 확보, SQL-DB 간의 '종속성'제거 ★★★<br>
	- DB 테이블과 컬럼타입을 Map이나 컬렉션을 통해서 자바POJO(=VO, DTO)로 자동으로 변환하는것이 가능<br>
	<hr><br>
	
	
	<h2>1. insert문 활용</h2>
	<h3>1.1 기본적인 insert문 활용해보기</h3>
	<a href="${path}/insert.do">학생 등록하기</a>
	
	<h3>1.2 학생이름으로 Insert문 활용하기</h3>
	<form action="${path}/insertName.do" method="post">
		<input type="text" name="name" placeholder="이름"/>
		<input type="submit" value="저장">
	</form>
	
	<hr><br>
	
	<h3>1.3 학생정보(=객체)로 Insert문 활용하기 - VO 활용하는방법</h3>
	<form action="${path}/insertParamAll.do" method="post"><br>
		<input type="text" name="name" placeholder="이름"/><br>
		<input type="text" name="tel" placeholder="전화번호"/><br>
		<input type="text" name="address" placeholder="주소"/><br>
		<input type="text" name="email" placeholder="이메일"/><br>
		<input type="submit" value="저장"><br>
	</form>
	<hr><br>
		
	<h3>1.4 학생정보로 Insert문 활용하기 - Map(컬랙션) 활용하는 방법</h3>
	<form action="${path}/insertParamAllMap.do" method="post"><br>
		<input type="text" name="name" placeholder="이름"/><br>
		<input type="text" name="tel" placeholder="전화번호"/><br>
		<input type="text" name="address" placeholder="주소"/><br>
		<input type="text" name="email" placeholder="이메일"/><br>
		<input type="submit" value="저장"><br>
	</form>
	<hr><br>
	
	<h2>2. Update</h2>
	<h3>2.1 등록된 학생의 이름, 주소 전화번호, 이메일을 받아서 수정하는 방법</h3>
	<form action="${path}/update.do" method="post"><br>
		찾을이름      : <input type="text" name="name" placeholder="이름"/><br>
		수정될 전화번호 : <input type="text" name="tel" placeholder="전화번호"/><br>
		수정될 주소    :<input type="text" name="address" placeholder="주소"/><br>
		수정될 이메일  :<input type="text" name="email" placeholder="이메일"/><br>
		<input type="submit" value="저장"><br>
	</form>
	<hr><br>
	
	<h2>3. Delete</h2>
	<h3>3.1 학생이름으로 delete문 활용하기</h3>
	<form action="${path}/delete.do" method="post">
		<input type="text" name="name" placeholder="이름"/>
		<input type="submit" value="삭제">
	</form>
	<hr><br>
	
	<h2>4. Select - 단일 행 조회하기</h2>
	<h3>4.1 테이블의 학생수 구하기 (인자없는 단순 select문)</h3>
		<a href="${path}/selectCount.do">학생수 조회하기</a><br>
		
	<h3>4.2 학번으로 학생조회하기 (객체로 받아오는 테스트)</h3>
	<form action="${path}/selectOne.do" method="get">
		<input type="number" name="no" placeholder="학번"/>
		<input type="submit" value="찾기">
	</form>
	<br>
		
	<h3>4.3 학번으로 학생조회하기(ResultMap을 활용해서 객체로 받아오는 법)</h3>
	<form action="${path}/selectOne2.do" method="get">
		<input type="number" name="no" placeholder="학번"/>
		<input type="submit" value="찾기">
	</form>
	<br>
	
	<h3>4.4 학번으로 학생조회하기(컬렉션 Map 형태로 조회값 가져오기)</h3>
	<form action="${path}/selectOne3.do" method="get">
		<input type="number" name="no" placeholder="학번"/>
		<input type="submit" value="찾기">
	</form>
	<br>
	
	<h3>5.1 전체 학생을 조회하기 (as 활용)</h3>
	<a href="${path}/selectAll.do"> 조회 </a>
	<br>
	
	<h3>5.2 전체 학생을 조회하기 (Result Map)</h3>
	<a href="${path}/selectAllResultMap.do"> 조회 </a>
	<br>
	
	<h3>5.3 전체 학생을 조회하기 (List + Map)</h3>
	<a href="${path}/selectAllListMap.do"> 조회 </a>
	<br>
	<h3>5.4 email 키워드로 조회 하기</h3>
	<form action="${path}/searchEmail.do" method="get">
		검색 키워드 <input type="text" name="email" placeholder="이메일 주소 키워드"><br>
		<input type="submit" value="찾기">
	</form>

	
		
	
	
	
	
	<br><br><br><br><br><br><br><br>
	
	
	
	
	
</body>
</html>