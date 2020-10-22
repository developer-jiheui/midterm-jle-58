
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
			<c:forEach var="order" items="${orderList}" varStatus="status">
				<tr>
					<td>${order.id}</td>
					<td>${order.firstname}</td>
					<td>${order.lastname}</td>
					<td>${order.size}</td>
					<td>${order.numToppings}</td>
					<td>%${order.discount}</td>	
					<td>$ ${ priceList[status.index] }</td>	
				</tr>
			</c:forEach>
		</table>
		<h3>Create Order</h3>
		<form:form action="${pageContext.request.contextPath}/createOrder/"
			cssClass="form-horizontal" method="post" modelAttribute="order">
			<div class="form-group">
				<label for="firstname" class="col-md-3 controllabel">First Name</label>
				<div class="col-md-9">
					<form:input path="firstname" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-md-3 controllabel">Last Name</label>
				<div class="col-md-9">
					<form:input path="lastname" cssClass="form-control" />
				</div>
			</div>		
			<div class="form-group">
				<form:select path="size" id="size">
					<form:option value="">Select Size</form:option>
					<form:options items="${sizes}" />
				</form:select>
			</div>
			<div class="form-group">
				<label for="discount" class="col-md-3 controllabel">Discount</label>
				<div class="col-md-9">
					<form:input type="number" path="discount" cssClass="form-control" />
				</div>
			</div>	
			<div class="form-group">
				<label for="numToppings" class="col-md-3 controllabel">Number of Toppings</label>
				<div class="col-md-9">
					<form:input type="number" path="numToppings" cssClass="form-control" />
				</div>
			</div>	
			<div class="form-group">
				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<form:button class="btn btn-primary">Submit</form:button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>