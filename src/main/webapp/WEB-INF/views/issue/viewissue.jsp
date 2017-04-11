<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="generic-container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4>Issue ${issue.summary}</h4>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Id</label>
		<div class="col-sm-6">
			<form:input type="text" path="id" id="id" class="form-control"
				readonly="true" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Create date</label>
		<div class="col-sm-6">
			<form:input type="text" path="createDate" id="createDate"
				class="form-control" readonly="true" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Created by</label>
		<div class="col-sm-6">
			<form:label path="createdBy" class="form-control">
					${issue.createdBy.firstName}
				</form:label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Modify date</label>
		<div class="col-sm-6">
			<form:input type="text" path="modifyDate" id="modifyDate"
				class="form-control" readonly="true" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Modified by</label>
		<div class="col-sm-6">
			<form:label path="modifiedBy" class="form-control">
					${issue.modifiedBy.firstName}
				</form:label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Summary</label>
		<div class="col-sm-6">
			<form:input type="text" path="summary" id="summary"
				class="form-control" placeholder="Enter the summary" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Description</label>
		<div class="col-sm-6">
			<form:textarea path="description" id="description"
				class="form-control" placeholder="Enter the description" rows="3" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Status</label>
		<div class="col-sm-6">
			<form:select path="status" class="form-control" id="status">
				<c:if test="${issue.status == null}">
					<option selected="selected" disabled>Select the status</option>
				</c:if>
				<c:forEach items="${statuses}" var="status">
					<option ${status.id == issue.status.id ? 'selected' : ''}
						value="${status.id}">${status.name}</option>
				</c:forEach>
			</form:select>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Resolution</label>
		<div class="col-sm-6">
			<form:select path="resolution" class="form-control" id="resolution">
				<c:if test="${issue.resolution == null}">
					<option selected="selected" disabled>Select the resolution</option>
				</c:if>
				<c:forEach items="${resolutions}" var="resolution">
					<option ${resolution.id == issue.resolution.id ? 'selected' : ''}
						value="${resolution.id}">${resolution.name}</option>
				</c:forEach>
			</form:select>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Type</label>
		<div class="col-sm-6">
			<form:select path="type" class="form-control" id="type">
				<c:if test="${issue.type == null}">
					<option selected="selected" disabled>Select the type</option>
				</c:if>
				<c:forEach items="${types}" var="type">
					<option ${type.id == issue.type.id ? 'selected' : ''}
						value="${type.id}">${type.name}</option>
				</c:forEach>
			</form:select>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Priority</label>
		<div class="col-sm-6">
			<form:select path="priority" class="form-control" id="priority">
				<c:if test="${issue.priority == null}">
					<option selected="selected" disabled>Select the priority</option>
				</c:if>
				<c:forEach items="${priorities}" var="priority">
					<option ${priority.id == issue.priority.id ? 'selected' : ''}
						value="${priority.id}">${priority.name}</option>
				</c:forEach>
			</form:select>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Project</label>
		<div class="col-sm-6">
			<form:select path="project" class="form-control" id="project">
				<c:if test="${issue.project == null}">
					<option selected="selected" disabled>Select the project</option>
				</c:if>
				<c:forEach items="${projects}" var="project">
					<option ${project.id == issue.project.id ? 'selected' : ''}
						value="${project.id}">${project.name}</option>
				</c:forEach>
			</form:select>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Assignee</label>
		<div class="col-sm-6">
			<form:select path="priority" class="form-control" id="priority">
				<c:if test="${issue.assignee == null}">
					<option selected="selected" disabled>Select the assignee</option>
				</c:if>
				<c:forEach items="${users}" var="user">
					<option ${user.id == issue.assignee.id ? 'selected' : ''}
						value="${user.id}">${user.firstName}</option>
				</c:forEach>
			</form:select>
		</div>
	</div>

	<div class="text-right">
		<input type="submit" value="Update" class="btn btn-success" /> <a
			href="<c:url value='/listissues' />" class="btn btn-danger">Cancel</a>
	</div>
</div>
