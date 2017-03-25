<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User Registration Form</title>
	<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="generic-container">
	<div class="well lead">User Registration Form</div>
 	<form:form method="POST" modelAttribute="user" class="form-horizontal">
		<form:input type="hidden" path="id" id="id"/>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstName">First Name</label>
				<div class="col-md-7">
					<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="firstName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="lastName">Last Name</label>
				<div class="col-md-7">
					<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="lastName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="password">Password</label>
				<div class="col-md-7">
					<form:input type="password" path="password" id="password" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="password" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="email">Email</label>
				<div class="col-md-7">
					<form:input type="text" path="email" id="email" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="email" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-actions floatRight">
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Update" class="btn btn-primary btn-sm"/> 
						<a href="<c:url value='/listusers' />" class="btn-warning">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" class="btn btn-primary btn-sm"/>
						<a href="<c:url value='/listusers' />" class="btn-warning">Cancel</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>