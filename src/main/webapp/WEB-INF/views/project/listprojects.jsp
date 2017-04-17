<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h4>Projects</h4>
	</div>
</div>



<table class="table table-hover">
	<thead>
		<tr>
			<th>Name</th>
			<th>Manager</th>
			<th>Description</th>
			<th width="100"><a href="<c:url value='/addproject' />"
				class="btn btn-success">New project</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listprojects}" var="project">
			<tr>
				<td>${project.name}</td>
				<td>${project.manager.firstName}</td>
				<td>${project.description}</td>
				<td align="right"><a
					href="<c:url value='/editproject?id=${project.id}' />"
					class="btn btn-success">edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${empty listprojects}">
	<div class="text-align-center">
		<em class="text-gray">No projects found</em>
	</div>
</c:if>