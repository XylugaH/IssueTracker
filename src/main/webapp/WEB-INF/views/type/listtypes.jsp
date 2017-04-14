<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h4>Types</h4>
	</div>
</div>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Name</th>
			<th width="100"><a href="<c:url value='/addtype' />"
				class="btn btn-success">New type</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listtypes}" var="listtypes">
			<tr>
				<td>${listtypes.name}</td>
				<td align="right"><a
					href="<c:url value='/edittype/${listtypes.id}' />"
					class="btn btn-success">edit</a></td>
			</tr>
		</c:forEach>

	</tbody>
</table>

<c:if test="${empty listtypes}">
	<div class="text-align-center">
		<em class="text-gray">No types found</em>
	</div>
</c:if>