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
<%-- http://localhost:8080/jsp20220405/chap03/05request/ex05.jsp?num1=99&num2=88 --%>
<%-- num1, num2 파라미터의 값을 더해서 출력하는 코드 작성 --%>
<%-- num1이나 num2 파라미터가 없다면 입력해달라는 메세지 출력 --%>
<%
String num1Str = request.getParameter("num1");
String num2Str = request.getParameter("num2");
int result;
if(num1Str==null || num2Str==null){
%>
<h1>num1와 num2 모두 입력해주세요</h1>
<%
} else {
%>

<h1><%= num1Str %> + <%= num2Str %> = <%= Integer.parseInt(num1Str) + Integer.parseInt(num2Str) %></h1>

<%
}
%>

</body>
</html>