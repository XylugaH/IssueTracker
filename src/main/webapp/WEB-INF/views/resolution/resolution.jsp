<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resolution</title>
<link href="<c:url value='/resources/css/bootstrap.min.css' />"
	rel="stylesheet"></link>
</head>

<body>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/saveresolution"
		modelAttribute="resolution" class="form-horizontal">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Edit resolution</h4>
			</div>
		</div>

		<form:input type="hidden" path="id" id="id" />

		<div class="form-group">
			<label class="col-sm-2 control-label">Name</label>
			<div class="col-sm-6">
				<form:input type="text" path="name" id="name" class="form-control"
					placeholder="Enter the name" />
				<div style="color: red">
					<form:errors path="name" class="error" />
				</div>
			</div>
		</div>

		<div class="text-right">
			<input type="submit" value="Save" class="btn btn-success" /> <a
				href="<c:url value='/listresolutions' />" class="btn btn-danger">Cancel</a>
		</div>
	</form:form>
</body>
</html>