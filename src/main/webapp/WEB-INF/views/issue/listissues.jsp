<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Issues</title>
<form method="POST" action="${contextPath}/search"
	class="form-horizontal">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<div style="width: 100%; height: 1px; clear: both;"></div>
			<div style="width: 50%; float: left; margin-left: 15px;">
				<h4>Issue</h4>
			</div>
			<div style="float: left; margin-left: 0px;">
				<select id="param" name="param" class="form-control">
					<option selected value="1">Assignee</option>
					<option value="2">Project</option>
					<option value="3">Status</option>
					<option value="4">Priority</option>
				</select>
			</div>
			<div style="width: 35%; float: left; margin-left: 5px;">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="input-group">
					<input name="crit" type="text" class="form-control"
						placeholder="Search issue"> <span class="input-group-btn">
						<button class="btn btn-default" type="submit">
							&nbsp;&nbsp;&nbsp;<i class="glyphicon glyphicon-search"></i>&nbsp;&nbsp;&nbsp;
						</button>
					</span>
				</div>
			</div>
			<div style="width: 100%; height: 1px; clear: both;"></div>
		</div>
	</div>
</form>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Priority</th>
			<th>Assignee</th>
			<th>Type</th>
			<th>Status</th>
			<th>Summary</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${issues}" var="issue">
			<tr>
				<sec:authorize access="isAuthenticated()">
					<td><a href="<c:url value='/editissue/${issue.id}' />"><span
							class="badge">${issue.id}</span></a></td>
				</sec:authorize>
				<sec:authorize access="!isAuthenticated()">
					<td><a href="<c:url value='/viewissue/${issue.id}' />"><span
							class="badge">${issue.id}</span></a></td>
				</sec:authorize>
				<td>${issue.priority.name}</td>
				<td>${issue.assignee.firstName}</td>
				<td>${issue.type.name}</td>
				<td>${issue.status.name}</td>
				<td>${issue.summary}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

