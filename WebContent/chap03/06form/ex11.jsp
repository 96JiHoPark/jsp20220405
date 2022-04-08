<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
	<form action="ex12.jsp">
		<input type="text" name="num1" />
		<select name="calculation" id="">
			<option value="addition">+</option>
			<option value="subtraction">-</option>
			<option value="multiplication">X</option>
			<option value="division">/</option>
		</select>
		<input type="text" name="num2"/>
		<input type="submit" value="계산" />
	</form>
</body>
</html>