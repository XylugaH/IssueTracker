<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Issues</title>
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet"></link>
</head>

<body>
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
				<th width="100"><a href="<c:url value='/registration' />"
					class="btn btn-success">New issue</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${issues}" var="issue">
				<tr>
					<td>${issue.id}</td>
					<td>${issue.priority.name}</td>
					<td>${issue.assignee.name}</td>
					<td>${issue.type.name}</td>
					<td>${issue.status.name}</td>
					<td>${issue.summary}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>