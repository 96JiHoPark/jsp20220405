<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="viewParameter.jsp" method="get">
이름: <input type="text" name="name" size="10"/> <br />
주소: <input type="text" name="address" size="30"/> <br />
좋아하는 동물 : <br />
	<input type="text" name="pet" value="dog"/> 강아지 <br />
	<input type="text" name="pet" value="cat"/> 고양이<br />
	<input type="text" name="pet" value="pig"/> 돼지 <br />
	<input type="submit" value="전송" />
</form>
</body>
</html>