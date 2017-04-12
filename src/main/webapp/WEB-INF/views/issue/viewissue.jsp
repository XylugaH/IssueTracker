<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="form-horizontal">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4>Issue: ${issue.summary}</h4>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Id</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.id}" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Create date</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.createDate}" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Created by</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.createdBy.firstName}" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Modify date</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.modifyDate}" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Modified by</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.modifiedBy.firstName}" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Summary</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.summary}" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Description</label>
		<div class="col-sm-6">
			<textarea class="form-control" rows="3" readonly="readonly">
					${issue.description}
				</textarea>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Status</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.status.name}" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Resolution</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.resolution.name}" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Type</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.type.name}" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Priority</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.priority.name}" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Project</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.project.name}" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Build</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.build.name}" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Assignee</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" readonly="readonly"
				value="${issue.assignee.firstName}" />
		</div>
	</div>

	<div class="text-right">
		<a href="<c:url value='/listissues' />" class="btn btn-success">Back</a>
	</div>

	<c:forEach items="${issue.comments}" var="comment">
		<div class="form-group">
			<div class="col-sm-2">
				<div><label class="control-label">${comment.createDate}</label></div>
				<div>${comment.createdBy.firstName}</div>
			</div>
			<div class="col-sm-6">${comment.comment}</div>
		</div>
	</c:forEach>
</div>
