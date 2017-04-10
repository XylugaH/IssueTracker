<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form method="POST"
	action="${pageContext.request.contextPath}/saveprofile"
	modelAttribute="userprofile" class="form-horizontal">
	<div class="generic-container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Edit profile</h4>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">First Name</label>
			<div class="col-sm-6">
				<form:input type="text" path="firstName" id="firstName"
					class="form-control" placeholder="Enter the first name" />
				<div style="color: red">
					<form:errors path="firstName" class="error" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Last Name</label>
			<div class="col-sm-6">
				<form:input type="text" path="lastName" id="lastName"
					class="form-control" placeholder="Enter the last name" />
				<div style="color: red">
					<form:errors path="lastName" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">E-mail</label>
			<div class="col-sm-6">
				<form:input type="text" path="email" id="email" class="form-control"
					placeholder="Enter the E-mail" />
				<div style="color: red">
					<form:errors path="email" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="text-right">
			<input type="submit" value="Save" class="btn btn-success" /> <a
				href="<c:url value='/listissues' />" class="btn btn-danger">Cancel</a>
		</div>
	</div>
</form:form>