<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%request.setCharacterEncoding("utf-8");%>

<%
//ex04to.jsp로 전달
request.setAttribute("movie", "doctor");
response.sendRedirect("ex04to.jsp?age=90");
%>