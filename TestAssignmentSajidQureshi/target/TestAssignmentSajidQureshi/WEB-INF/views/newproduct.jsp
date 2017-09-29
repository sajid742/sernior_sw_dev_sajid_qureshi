<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Product Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="generic-container">
 	<c:choose>
					<c:when test="${edit}">
						<div class="well lead">Edit Product</div>
					</c:when>
					<c:otherwise>
						<div class="well lead">Add New Product</div>
					</c:otherwise>
	</c:choose>
 	<form:form method="POST" modelAttribute="product" class="form-horizontal">
		<form:input type="hidden" path="id" id="id"/>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Product Name</label>
				<div class="col-md-7">
					<form:input type="text" path="name" id="name" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="name" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<%-- <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Last Name</label>
				<div class="col-md-7">
					<form:input type="text" path="name" id="name" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="name" class="help-inline"/>
					</div>
				</div>
			</div>
		</div> --%>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="productType">Product Type</label>
				<div class="col-md-7">
					<form:select path="productType" items="${productTypes}" itemValue="id" itemLabel="name" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="productType" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="brand">Brand</label>
				<div class="col-md-7">
					<form:select path="brand" items="${brands}" itemValue="id" itemLabel="name" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="brand" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<%-- <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="size">Size</label>
				<div class="col-md-7">
					<form:select path="size" items="${sizes}" itemValue="id" itemLabel="name" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="size" class="help-inline"/>
					</div>
				</div>
			</div>
		</div> --%>

		<div class="row">
			<div class="form-actions floatRight">
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/Product/list' />">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/Product/list' />">Cancel</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>