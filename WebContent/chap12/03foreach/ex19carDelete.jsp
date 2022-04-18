<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="chap11.*" %>
<%request.setCharacterEncoding("utf-8");%>

<%
String idStr= request.getParameter("id");

int id = Integer.parseInt(idStr);

List<String> list = (List<String>) application.getAttribute("cars");

list.remove(id);

response.sendRedirect("ex18carForm.jsp");
%>