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
	<form:form method="POST" modelAttribute="user" class="form-horizontal">
		<div class="generic-container">
			<div class="panel panel-primary">
				<div class="panel-heading"><h4>User Registration Form</h4></div>
			</div>
 	
			<form:input type="hidden" path="id" id="id"/>
			
		    <div class="form-group">
    			<label class="col-sm-2 control-label">First Name</label>
    			<div class="col-sm-6">
      				<form:input type="text" path="firstName" id="firstName" class="form-control" placeholder="Enter the first name"/>
      				<div class="has-error">
						<form:errors path="firstName" class="help-inline"/>
					</div>
    			</div>
  			</div>
    		
		    <div class="form-group">
    			<label class="col-sm-2 control-label">Last Name</label>
    			<div class="col-sm-6">
      				<form:input type="text" path="lastName" id="lastName" class="form-control" placeholder="Enter the last name"/>
      				<div class="has-error">
						<form:errors path="lastName" class="help-inline"/>
					</div>
    			</div>
  			</div>
  			
		    <div class="form-group">
    			<label class="col-sm-2 control-label">E-mail</label>
    			<div class="col-sm-6">
      				<form:input type="text" path="email" id="email" class="form-control" placeholder="Enter the E-mail"/>
      				<div class="has-error">
						<form:errors path="email" class="help-inline"/>
					</div>
    			</div>
  			</div>
  			
  			<div class="form-group">
    			<label class="col-sm-2 control-label">Password</label>
    			<div class="col-sm-6">
      				<form:input type="password" path="password" id="password" class="form-control" placeholder="Enter the password"/>
      				<div class="has-error">
						<form:errors path="password" class="help-inline"/>
					</div>
    			</div>
  			</div>
  			
	  		<div class="form-group">
    			<label class="col-sm-2 control-label">Password confirm</label>
    			<div class="col-sm-6">
      				<form:input type="password" path="passwordConfirm" id="passwordConfirm" class="form-control" placeholder="Confirm the password"/>
      				<div class="has-error">
						<form:errors path="passwordConfirm" class="help-inline"/>
					</div>
    			</div>
  			</div>

			<div style="text-align: right;">
				<input type="submit" value="Save" class="btn btn-success"/>
				<a href="<c:url value='/listusers' />" class="btn btn-danger">Cancel</a>
			</div>
		</div>
	</form:form>
</body>
</html>