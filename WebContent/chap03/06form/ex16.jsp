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
String contents = request.getParameter("contents");
String reverse = new StringBuilder(contents).reverse().toString();
%>

<textarea name="" id="" cols="30" rows="10"><%=reverse%></textarea>

</body>
</html>