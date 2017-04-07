<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Project</title>
	<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
</head>

<body>
	<form:form method="POST" action="${pageContext.request.contextPath}/saveproject" modelAttribute="project" class="form-horizontal">
    	<div class="panel panel-primary">
      		<div class="panel-heading"><h4>Edit project</h4></div>
    	</div>
	
		<form:input type="hidden" path="id" id="id"/>
		
		<div class="form-group">
    		<label class="col-sm-2 control-label">Name</label>
    		<div class="col-sm-6">
      			<form:input type="text" path="name" id="name1" class="form-control" placeholder="Enter the name"/>
      			<div class="has-error">
					<form:errors path="name" class="help-inline"/>
				</div>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label class="col-sm-2 control-label">Description</label>
    		<div class="col-sm-6">
      			<form:textarea path="description" id="description" class="form-control" placeholder="Enter the description" rows="3"/>
      			<div class="has-error">
					<form:errors path="description" class="help-inline"/>
				</div>
    		</div>
  		</div>
  				
	  	<div class="form-group">
    		<label class="col-sm-2 control-label">Build</label>
    		<div class="col-sm-6">
      			<form:input type="text" path="builds[0].name" id="builds[0].name" class="form-control" placeholder="Enter the description" rows="3"/>
      			<div class="has-error">
					<form:errors path="builds[0].name" class="help-inline"/>
				</div>
    		</div>
  		</div>
  		
  		<div class="form-group">
  			<label class="col-sm-2 control-label">Manager</label>
    		<div class="col-sm-6">
  				<form:select path="manager" class="form-control" id="manager">
  					<c:forEach items="${users}" var="user">
    					<option value="${user.id}">${user.firstName}</option>
					</c:forEach>
  				</form:select>
  			</div>
  			<div class="has-error">
				<form:errors path="manager" class="help-inline"/>
			</div>
		</div>

		<div style="text-align: right;">
			<input type="submit" value="Save" class="btn btn-success"/>
			<a href="<c:url value='/listprojects' />" class="btn btn-danger">Cancel</a>
		</div>
		

	</form:form>
</body>
</html>