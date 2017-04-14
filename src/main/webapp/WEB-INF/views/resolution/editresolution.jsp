<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="POST"
	action="${pageContext.request.contextPath}/updateresolution"
	modelAttribute="resolution" class="form-horizontal">

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4>Edit resolution ${resolution.name}</h4>
		</div>
	</div>

	<form:input type="hidden" path="id" id="id" />

	<div class="form-group">
		<label class="col-sm-2 control-label">Name</label>
		<div class="col-sm-6">
			<form:input type="text" path="name" id="name" class="form-control"
				placeholder="Enter the name" />
			<div class="has-error">
				<form:errors path="name" class="error" />
			</div>
		</div>
	</div>

	<div class="text-right">
		<input type="submit" value="Save" class="btn btn-success" /> <a
			href="<c:url value='/listresolutions' />" class="btn btn-danger">Cancel</a>
	</div>
</form:form>
