<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%request.setCharacterEncoding("utf-8");%>

<%
String str = "직업";
List<String> list = new ArrayList<>();
list.add("이름1");
list.add("이름2");
list.add("이름3");

request.setAttribute("job", str);
request.setAttribute("names",list);
%>

<jsp:forward page="ex06to.jsp" />