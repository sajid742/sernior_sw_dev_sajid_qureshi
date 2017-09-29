<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Products List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Products </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Product</th>
				        <th>Product ID</th>
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td>${product.name}</td>
						<td>${product.id}</td>
						<td><a href="<c:url value='/Product/edit-product-${product.id}' />" class="btn btn-success custom-width">edit</a></td>
						<td><a href="<c:url value='/Product/delete-product-${product.id}' />" class="btn btn-danger custom-width">delete</a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/Product/newproduct' />">Add New Product</a>
	 	</div>
   	</div>
</body>
</html>