<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="POST"
	action="${pageContext.request.contextPath}/updateproject"
	modelAttribute="project" class="form-horizontal">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4>Edit project ${project.name}</h4>
		</div>
	</div>

	<form:input type="hidden" path="id" id="id" />

	<div class="form-group">
		<label class="col-sm-2 control-label">Name</label>
		<div class="col-sm-6">
			<form:input type="text" path="name" id="name1" class="form-control"
				placeholder="Enter the name" />
			<div style="color: red">
				<form:errors path="name" class="help-inline" />
			</div>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Description</label>
		<div class="col-sm-6">
			<form:textarea path="description" id="description"
				class="form-control" placeholder="Enter the description" rows="3" />
			<div style="color: red">
				<form:errors path="description" class="help-inline" />
			</div>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Builds</label>
		<div class="col-sm-6">
			<form:select path="builds" class="form-control" id="builds">
				<c:forEach items="${project.builds}" var="build">
					<option value="${build.id}" disabled>${build.name}</option>
				</c:forEach>
			</form:select>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Manager</label>
		<div class="col-sm-6">
			<form:select path="manager" class="form-control" id="manager">
				<c:forEach items="${users}" var="user">
					<option ${user.id == project.manager.id ? 'selected' : ''}
						value="${user.id}">${user.firstName}</option>
				</c:forEach>
			</form:select>
			<div style="color: red">
				<form:errors path="manager" class="help-inline" />
			</div>
		</div>
	</div>

	<div style="text-align: right;">
		<input type="submit" value="Save" class="btn btn-success" /> <a
			href="<c:url value='/listprojects' />" class="btn btn-danger">Cancel</a>
	</div>

</form:form>

<form method="POST" action="${pageContext.request.contextPath}/addbuild"
	class="form-horizontal">
	<div class="form-group">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="hidden" name="project"
			value="${project.id}" /> <label class="col-sm-2 control-label">New
			build</label>
		<div class="col-sm-6">
			<input type="text" name="name" class="form-control"
				placeholder="Enter the name" />
			<div style="color: red">
				<form:errors path="name" class="help-inline" />
			</div>
		</div>
		<div class="col-sm-2">
			<input type="submit" value="Add new build" class="btn btn-success" />
		</div>
	</div>
</form>
