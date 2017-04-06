<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<title>Issues</title>
<div class="panel panel-primary">
	<div class="panel-heading">
		<h4>Issues</h4>
	</div>
</div>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Priority</th>
			<th>Assignee</th>
			<th>Type</th>
			<th>Status</th>
			<th>Summary</th>
			<th width="100"><a href="<c:url value='/addissue' />"
				class="btn btn-success">New issue</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${issues}" var="issue">
			<tr>
				<td>${issue.id}</td>
				<td>${issue.priority.name}</td>
				<td>${issue.assignee.firstName}</td>
				<td>${issue.type.name}</td>
				<td>${issue.status.name}</td>
				<td>${issue.summary}</td>
				<td align="right"><a
					href="<c:url value='/editissue/${issue.id}' />"
					class="btn btn-success">edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

