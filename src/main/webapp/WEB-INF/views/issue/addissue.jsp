<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<form:form method="POST"
	action="${pageContext.request.contextPath}/saveissue"
	modelAttribute="issue" class="form-horizontal">
	<div class="generic-container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Issue Form</h4>
			</div>
		</div>

		<form:input type="hidden" path="id" id="id" />

		<div class="form-group">
			<label class="col-sm-2 control-label">Summary</label>
			<div class="col-sm-6">
				<form:input type="text" path="summary" id="summary"
					class="form-control" placeholder="Enter the summary" />
				<div style="color: red">
					<form:errors path="summary" class="error" />
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
			<label class="col-sm-2 control-label">Status</label>
			<div class="col-sm-6">
				<form:select path="status" class="form-control" id="status">
					<option selected="selected" disabled>Select the status</option>
					<c:forEach items="${statuses}" var="status">
						<c:if
							test="${(status.name == 'New' || status.name == 'Assigned')}">
							<option ${status.id == issue.status.id ? 'selected' : ''}
								value="${status.id}">${status.name}</option>
						</c:if>
					</c:forEach>
				</form:select>
				<div style="color: red">
					<form:errors path="status" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Type</label>
			<div class="col-sm-6">
				<form:select path="type" class="form-control" id="type">
					<option selected="selected" disabled>Select the type</option>
					<c:forEach items="${types}" var="type">
						<option ${type.id == issue.type.id ? 'selected' : ''}
							value="${type.id}">${type.name}</option>
					</c:forEach>
				</form:select>
				<div style="color: red">
					<form:errors path="type" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Priority</label>
			<div class="col-sm-6">
				<form:select path="priority" class="form-control" id="priority">
					<option selected="selected" disabled>Select the priority</option>
					<c:forEach items="${priorities}" var="priority">
						<option ${priority.id == issue.priority.id ? 'selected' : ''}
							value="${priority.id}">${priority.name}</option>
					</c:forEach>
				</form:select>
				<div style="color: red">
					<form:errors path="priority" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Project</label>
			<div class="col-sm-6">
				<form:select path="project" class="form-control" id="project">
					<option selected="selected" disabled>Select the project</option>
					<c:forEach items="${projects}" var="project">
						<option ${project.id == issue.project.id ? 'selected' : ''}
							value="${project.id}">${project.name}</option>
					</c:forEach>
				</form:select>
				<div style="color: red">
					<form:errors path="project" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Build</label>
			<div class="col-sm-6">
				<form:select path="build" class="form-control" id="build">
					<option selected="selected" disabled>Select the build</option>
					<c:forEach items="${builds}" var="build">
						<option ${build.id == issue.build.id ? 'selected' : ''}
							value="${build.id}">${build.name}</option>
					</c:forEach>
				</form:select>
				<div style="color: red">
					<form:errors path="build" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Assignee</label>
			<div class="col-sm-6">
				<form:select path="assignee" class="form-control" id="assignee">
					<option selected="selected">Select the assignee</option>
					<c:forEach items="${users}" var="user">
						<option ${user.id == issue.assignee.id ? 'selected' : ''}
							value="${user.id}">${user.firstName}</option>
					</c:forEach>
				</form:select>
				<div style="color: red">
					<form:errors path="assignee" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="text-right">
			<input type="submit" value="Add" class="btn btn-success" /> <a
				href="<c:url value='/listissues' />" class="btn btn-danger">Cancel</a>
		</div>
	</div>
</form:form>
