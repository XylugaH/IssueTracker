<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="true"%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Status</title>
	<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
</head>

<body>
    <div class="panel panel-primary">
      <div class="panel-heading"><h4>Edit status</h4></div>
    </div>
	<form:form method="POST" action="${pageContext.request.contextPath}/savestatus" modelAttribute="status" class="form-horizontal">
	
		<form:input type="hidden" path="id" id="id"/>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">First Name</label>
				<div class="col-md-7">
					<form:input type="text" path="name" id="name" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="name" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="form-actions floatRight">
			<input type="submit" value="Update" class="btn btn-success"/>
			<a href="<c:url value='/liststatus' />" class="btn btn-danger">Cancel</a>
		</div>

	</form:form>
</body>
</html>