<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%request.setCharacterEncoding("utf-8");%>

<% 
Map<String, String> map = new HashMap<>();
map.put("movie1", "m1");
map.put("movie2", "m2");

request.setAttribute("movieMap", map);
%>

<jsp:forward page="ex05to.jsp"/>