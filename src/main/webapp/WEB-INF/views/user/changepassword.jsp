<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form method="POST"
	action="${pageContext.request.contextPath}/savepassword"
	modelAttribute="password" class="form-horizontal">
	<div class="generic-container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>User change password form</h4>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Password</label>
			<div class="col-sm-6">
				<form:input type="password" path="password" id="password"
					class="form-control" placeholder="Enter the password" />
				<div class="has-error">
					<form:errors path="password" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Password confirm</label>
			<div class="col-sm-6">
				<form:input type="password" path="passwordConfirm"
					id="passwordConfirm" class="form-control"
					placeholder="Confirm the password" />
				<div class="has-error">
					<form:errors path="passwordConfirm" class="error" />
				</div>
			</div>
		</div>

		<div class="text-right">
			<input type="submit" value="Save" class="btn btn-success" /> <a
				href="<c:url value='/listissues' />" class="btn btn-danger">Cancel</a>
		</div>
	</div>
</form:form>
