<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Insert title here</title>
</head>
<body>
<%
List<String> list = new ArrayList<>();
list.add("item1");
list.add("item2");
list.add("item3");
list.add("item4");
list.add("item5");
pageContext.setAttribute("myList", list);
%>

<%
for(int i = 0; i<list.size(); i++){
	pageContext.setAttribute("index", i);
%>
	<p>${myList[index] }</p> <%-- 5개 출력되도록 코드 작성 --%>
<%
}
%>
</body>
</html>