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
    <div class="panel panel-primary">
      <div class="panel-heading"><h4>Edit project</h4></div>
    </div>
	<form:form method="POST" action="${pageContext.request.contextPath}/saveproject" modelAttribute="project" class="form-horizontal">
	
		<form:input type="hidden" path="id" id="id"/>
		<div class="input-group">
    		<span class="input-group-addon">Name</span>
    		<form:input type="text" path="name" id="name" class="form-control" placeholder="Enter the name"/>
  		</div>
  		<div class="has-error">
			<form:errors path="name" class="help-inline"/>
		</div>
		
		<div class="input-group">
    		<span class="input-group-addon">Description</span>
    		<form:input type="text" path="description" id="description" class="form-control" placeholder="Enter the description"/>
  		</div>
  		<div class="has-error">
			<form:errors path="description" class="help-inline"/>
		</div>
		
		<div class="input-group">
    		<span class="input-group-addon">Manager</span>
			<form:select path="userList">
    			<form:options items="${userList.firstName}" />
			</form:select>
      	</div>
      	
		<div style="text-align: right;">
			<input type="submit" value="Save" class="btn btn-success"/>
			<a href="<c:url value='/listprojects' />" class="btn btn-danger">Cancel</a>
		</div>

	</form:form>
</body>
</html>