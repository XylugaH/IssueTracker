<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h4>Priorities</h4>
	</div>
</div>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Name</th>
			<th width="100"><a href="<c:url value='/addpriority' />"
				class="btn btn-success">New priority</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listpriorities}" var="listpriorities">
			<tr>
				<td>${listpriorities.name}</td>
				<td align="right"><a
					href="<c:url value='/editpriority/${listpriorities.id}' />"
					class="btn btn-success">edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${empty listpriorities}">
	<div class="text-align-center">
		<em class="text-gray">No priorities found</em>
	</div>
</c:if>