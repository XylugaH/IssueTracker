<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<title>Users</title>
<form method="POST" action="${contextPath}/searchusers"
	class="form-horizontal">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<div style="width: 100%; height: 1px; clear: both;"></div>
			<div style="width: 60%; float: left; margin-left: 15px;">
				<h4>Users</h4>
			</div>
			<div style="width: 35%; float: left; margin-left: 5px;">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="input-group">
					<input name="value" type="text" class="form-control"
						placeholder="Search users"> <span class="input-group-btn">
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
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th width="100"><a href="<c:url value='/adduser' />"
				class="btn btn-success">New user</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td align="right"><a
					href="<c:url value='/edituser/${user.id}' />"
					class="btn btn-success">edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${empty users}">
	<div class="text-align-center">
		<em class="text-gray">No users found</em>
	</div>
</c:if>