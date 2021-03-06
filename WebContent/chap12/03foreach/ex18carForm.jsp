<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="chap11.*" %>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
<script>
	$(document).ready(function(){
		$("#addOwnerButton").click(function(){
			$("#ownerInputContainer").append("<input type='text' name='owner' /> <br>")
		});
	});
</script>

<title>Insert title here</title>
</head>
<body>
	<h1>차 등록 폼</h1>
	<form action="ex19carProcess.jsp" method="post">
		모델명 : <input type="text" name="model" /> <br />
		가격 : <input type="text" name="price" /> <br />
		사용가능 : <input type="checkbox" name="available" value="true"/> <br />
		사용자 
		<button id="addOwnerButton" type="button">
			<i class="fa-solid fa-plus"></i>
		</button>
		<div id="ownerInputContainer">
		
		</div>
		<input type="submit" value="등록" />
	</form>
	
	<hr />
	
	<c:if test="${empty applicationScope.cars }" var="emptyCars">
		<p class="test-warning">등록된 차가 없습니다.</p>
	</c:if>
	
	<c:if test="${not emptyCars }">
		<table class="table table-bordered">
		
			<thead>
				<tr>
					<th></th>
					<th>#</th>
					<th>모델</th>
					<th>가격</th>
					<th>가능여부</th>
					<th>소유자들</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${applicationScope.cars }" var="car" varStatus="status">
					
					<c:url value="ex19carDelete.jsp" var="deleteUrl">
						<c:param name="id" value="${status.index}"></c:param>
					</c:url>
					
					<tr>
						<td><a href="${deleteUrl }"><i class="fa-solid fa-trash-can"></i></a></td>
						<td>${status.count }</td>
						<td><c:out value="${car.model }"></c:out></td> <%-- 스크립트 공격 방지 --%>
						<td>${car.price }</td>
						<td>${car.available }</td>
						<td>
							<c:forEach items="${car.owners }" var="owner" varStatus="status">
								<c:out value="${owner }"></c:out> <%-- 스크립트 공격 방지 --%>
								<c:if test="${not status.last }"> 
								,
								</c:if>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
	</c:if>
</body>
</html>