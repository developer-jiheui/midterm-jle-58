
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Orders</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />" 
	rel="stylesheet">
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">

		<h1>Pizza Orders - Jiheui Lee 300300658</h1>
		<hr />
		<c:if test="${ message != null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<table class="table table-striped table-bordered">

			<tr>
				<td>Id</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Size</td>
				<td>noToppings</td>
				<td>Discount</td>
				<td>Price</td>
			</tr>
			<c:forEach var="order" items="${orderList}">
				<tr>
					<td>${order.id}</td>
					<td>${order.firstname}</td>
					<td>${order.lastname}</td>
					<td>${order.size}</td>
					<td>${order.numToppings}</td>
					<td>%${order.discount}</td>	
					<td>$500</td>				
				</tr>
			</c:forEach>
		</table>
		
	</div>
</body>
</html>