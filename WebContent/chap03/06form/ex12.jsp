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
<% 
String num1Str = request.getParameter("num1");
String num2Str = request.getParameter("num2");
String calculation = request.getParameter("calculation");
int result = 0;

if( (num1Str != null) && (num2Str != null) ){
	int num1 = Integer.parseInt(num1Str);	
	int num2 = Integer.parseInt(num2Str);
	
	switch(calculation){
	case "addition" :
		result = num1 + num2;
		break;
	case "subtraction" :
		result = num1 - num2;
		break;
	case "multiplication" :
		result = num1 * num2;
		break;
	case "division" :
		result = num1 / num2;
		break;
	}
%>

<p>
<h1>계산 결과 : <%= result %></h1>	

<%
} else{
%>
	<h1><%= "두 수를 모두 입력하세요." %></h1>
<%
}
%>


</body>
</html>