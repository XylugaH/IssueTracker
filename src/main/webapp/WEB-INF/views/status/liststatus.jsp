<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h4>Statuses</h4>
	</div>
</div>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Name</th>
			<th width="100"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listStatus}" var="listStatus">
			<tr>
				<td>${listStatus.name}</td>
				<td><a href="<c:url value='/editstatus/${listStatus.id}' />"
					class="btn btn-success custom-width">edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${empty listStatus}">
	<div class="text-align-center">
		<em class="text-gray">No statuses found</em>
	</div>
</c:if>