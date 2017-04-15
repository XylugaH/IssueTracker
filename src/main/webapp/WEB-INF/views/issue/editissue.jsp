<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="findBuilds" value="/builds" />

<script type="text/javascript">
$(document).ready(function() { 
	$('#project').change(
			function() {
				$.getJSON('${findBuilds}', {
					projectId : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="" selected="selected" disabled>Select the build</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id + '">'
								+ data[i].name + '</option>';
					}
					html += '</option>';

					$('#build').html(html);
				});
			});
});
</script>

<script type="text/javascript">
$(document).ready(
			function() {
				$.getJSON('${findBuilds}', {
					projectId : $('#project').val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="" selected="selected" disabled>Select the build</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
							html += '<option value="' + data[i].id + '">'
							+ data[i].name + '</option>';
					}
					html += '</option>';

					$('#build').html(html);
				});
			});
</script>

<form:form method="POST"
	action="${pageContext.request.contextPath}/updateissue"
	modelAttribute="issue" class="form-horizontal">
	<div class="generic-container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Edit issue ${issue.summary}</h4>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Id</label>
			<div class="col-sm-6">
				<form:input type="text" path="id" id="id" class="form-control"
					readonly="true" />
				<div class="has-error">
					<form:errors path="id" class="error" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Create date</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" readonly="readonly"
					value="${issue.createDate}" />
				<div class="has-error">
					<form:errors path="createDate" class="error" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Created by</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" readonly="readonly"
					value="${issue.createdBy.firstName}" />
				<div class="has-error">
					<form:errors path="createdBy" class="error" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Modify date</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" readonly="readonly"
					value="${issue.modifyDate}" />
				<div class="has-error">
					<form:errors path="modifyDate" class="error" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Modified by</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" readonly="readonly"
					value="${issue.modifiedBy.firstName}" />
				<div class="has-error">
					<form:errors path="modifiedBy" class="error" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Summary</label>
			<div class="col-sm-6">
				<form:input readonly="${issue.tempStatus.name == 'Closed'}"
					type="text" path="summary" id="summary" class="form-control"
					placeholder="Enter the summary" />
				<div class="has-error">
					<form:errors path="summary" class="error" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Description</label>
			<div class="col-sm-6">
				<form:textarea readonly="${issue.tempStatus.name == 'Closed'}"
					path="description" id="description" class="form-control"
					placeholder="Enter the description" rows="3" />
				<div class="has-error">
					<form:errors path="description" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Status</label>
			<div class="col-sm-6">
				<form:select path="status" class="form-control" id="status">
					<c:forEach items="${statuses}" var="status">
						<c:if test="${(issue.tempStatus.name == 'New')}">
							<c:if
								test="${(status.name == 'New' || status.name == 'Assigned')}">
								<option ${status.id == issue.status.id ? 'selected' : ''}
									value="${status.id}">${status.name}</option>
							</c:if>
						</c:if>
						<c:if test="${(issue.tempStatus.name == 'Assigned')}">
							<c:if
								test="${(status.name == 'Assigned' || status.name == 'In Progress')}">
								<option ${status.id == issue.status.id ? 'selected' : ''}
									value="${status.id}">${status.name}</option>
							</c:if>
						</c:if>
						<c:if test="${(issue.tempStatus.name == 'In Progress')}">
							<c:if
								test="${(status.name == 'In Progress' || status.name == 'Resolved' || status.name == 'Closed')}">
								<option ${status.id == issue.status.id ? 'selected' : ''}
									value="${status.id}">${status.name}</option>
							</c:if>
						</c:if>
						<c:if test="${(issue.tempStatus.name == 'Resolved')}">
							<c:if
								test="${(status.name == 'Resolved' || status.name == 'Closed')}">
								<option ${status.id == issue.status.id ? 'selected' : ''}
									value="${status.id}">${status.name}</option>
							</c:if>
						</c:if>
						<c:if test="${(issue.tempStatus.name == 'Closed')}">
							<c:if
								test="${(status.name == 'Closed' || status.name == 'Reopened')}">
								<option ${status.id == issue.status.id ? 'selected' : ''}
									value="${status.id}">${status.name}</option>
							</c:if>
						</c:if>
						<c:if test="${(issue.tempStatus.name == 'Reopened')}">
							<c:if
								test="${(status.name == 'Assigned' || status.name == 'In Progress' || status.name == 'Reopened')}">
								<option ${status.id == issue.status.id ? 'selected' : ''}
									value="${status.id}">${status.name}</option>
							</c:if>
						</c:if>
					</c:forEach>
				</form:select>
				<div class="has-error">
					<form:errors path="status" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Resolution</label>
			<div class="col-sm-6">
				<c:choose>
					<c:when test="${issue.tempStatus.name == 'Closed'}">
						<input type="hidden" name="resolution"
							value="${issue.resolution.id}" />
						<input type="text" class="form-control" readonly="readonly"
							value="${issue.resolution.name}" />
					</c:when>
					<c:otherwise>
						<form:select path="resolution" class="form-control"
							id="resolution">
							<c:if test="${issue.resolution == null}">
								<option selected="selected" disabled>Select the
									resolution</option>
							</c:if>
							<c:forEach items="${resolutions}" var="resolution">
								<option
									${resolution.id == issue.resolution.id ? 'selected' : ''}
									value="${resolution.id}">${resolution.name}</option>
							</c:forEach>
						</form:select>
					</c:otherwise>
				</c:choose>
				<div class="has-error">
					<form:errors path="resolution" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Type</label>
			<div class="col-sm-6">
				<c:choose>
					<c:when test="${issue.tempStatus.name == 'Closed'}">
						<input type="hidden" name="type" value="${issue.type.id}" />
						<input type="text" class="form-control" readonly="readonly"
							value="${issue.type.name}" />
					</c:when>
					<c:otherwise>
						<form:select path="type" class="form-control" id="type">
							<c:if test="${issue.type == null}">
								<option selected="selected" disabled>Select the type</option>
							</c:if>
							<c:forEach items="${types}" var="type">
								<option ${type.id == issue.type.id ? 'selected' : ''}
									value="${type.id}">${type.name}</option>
							</c:forEach>
						</form:select>
					</c:otherwise>
				</c:choose>
				<div class="has-error">
					<form:errors path="type" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Priority</label>
			<div class="col-sm-6">
				<c:choose>
					<c:when test="${issue.tempStatus.name == 'Closed'}">
						<input type="hidden" name="priority" value="${issue.priority.id}" />
						<input type="text" class="form-control" readonly="readonly"
							value="${issue.priority.name}" />
					</c:when>
					<c:otherwise>
						<form:select path="priority" class="form-control" id="priority">
							<c:if test="${issue.priority == null}">
								<option selected="selected" disabled>Select the
									priority</option>
							</c:if>
							<c:forEach items="${priorities}" var="priority">
								<option ${priority.id == issue.priority.id ? 'selected' : ''}
									value="${priority.id}">${priority.name}</option>
							</c:forEach>
						</form:select>
					</c:otherwise>
				</c:choose>
				<div class="has-error">
					<form:errors path="priority" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Project</label>
			<div class="col-sm-6">
				<c:choose>
					<c:when test="${issue.tempStatus.name == 'Closed'}">
						<input type="hidden" name="project" value="${issue.project.id}" />
						<input type="text" class="form-control" readonly="readonly"
							value="${issue.project.name}" />
					</c:when>
					<c:otherwise>
						<form:select path="project" class="form-control" id="project">
							<c:if test="${issue.project == null}">
								<option selected="selected" disabled>Select the project</option>
							</c:if>
							<c:forEach items="${projects}" var="project">
								<option ${project.id == issue.project.id ? 'selected' : ''}
									value="${project.id}">${project.name}</option>
							</c:forEach>
						</form:select>
					</c:otherwise>
				</c:choose>
				<div class="has-error">
					<form:errors path="project" class="help-inline" />
				</div>
			</div>
		</div>


		<div class="form-group">
			<label class="col-sm-2 control-label">Build</label>
			<div class="col-sm-6">
				<c:choose>
					<c:when test="${issue.tempStatus.name == 'Closed'}">
						<input type="hidden" name="build" value="${issue.build.id}" />
						<input type="text" class="form-control" readonly="readonly"
							value="${issue.build.name}" />
					</c:when>
					<c:otherwise>
						<form:select path="build" class="form-control" id="build">
							<option selected="selected"	
								value="${build.id}">${build.name}</option>
						</form:select>
					</c:otherwise>
				</c:choose>
				<div class="has-error">
					<form:errors path="build" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Assignee</label>
			<div class="col-sm-6">
				<c:choose>
					<c:when test="${issue.tempStatus.name == 'Closed'}">
						<input type="hidden" name="assignee" value="${issue.assignee.id}" />
						<input type="text" class="form-control" readonly="readonly"
							value="${issue.assignee.firstName}" />
					</c:when>
					<c:otherwise>
						<form:select path="assignee" class="form-control" id="assignee">
							<c:if test="${issue.assignee == null}">
								<option selected="selected" disabled>Select the
									assignee</option>
							</c:if>
							<c:forEach items="${users}" var="user">
								<option ${user.id == issue.assignee.id ? 'selected' : ''}
									value="${user.id}">${user.firstName}</option>
							</c:forEach>
						</form:select>
					</c:otherwise>
				</c:choose>
				<div class="has-error">
					<form:errors path="assignee" class="help-inline" />
				</div>
			</div>
		</div>

		<div class="text-right">
			<input type="submit" value="Update" class="btn btn-success" /> <a
				href="<c:url value='/listissues' />" class="btn btn-danger">Cancel</a>
		</div>
	</div>
	<div class="generic-container">
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
</form:form>

