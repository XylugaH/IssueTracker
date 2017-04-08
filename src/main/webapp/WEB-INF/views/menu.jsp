<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="true" %>
<tilesx:useAttribute name="current" />

<div class="panel panel-primary">
	<div class="panel-heading">
		<h4>Issue Tracker</h4>
	</div>
</div>

<c:out value="${sessionScope.currentUser}"/>
<c:choose>
	<c:when test="${currentUser.role.id == 1}">
		<h3></h3>
		<hr color="red" size="10">

		<form method="POST" action="${pageContext.request.contextPath}/login"
			class="form-horizontal">

			<div class="form-group">
				<label class="col-sm-4 control-label">E-mail:</label>
				<div class="col-sm-8">
					<input type="text" name='email' id="email" class="form-control"
						placeholder="Enter the E-mail" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label">Password:</label>
				<div class="col-sm-8">
					<input type="password" name='password' id="password"
						class="form-control" placeholder="Enter the E-mail" />
				</div>
			</div>

			<div style="color: red; text-align: center;">${errorOut}</div>

			<div style="text-align: right;">
				<input type="submit" value="Sign in" class="btn btn-success" />
			</div>
		</form>
		<hr size="10">
		<h4></h4>
	</c:when>
	<c:otherwise>
        <form method="POST" action="${pageContext.request.contextPath}/logout"
			class="form-horizontal">

			<div style="text-align: right;">
				<input type="submit" value="Sign out" class="btn btn-success" />
			</div>
		</form>
    </c:otherwise>
</c:choose>

<ul class="nav nav-pills nav-stacked">
	<li class="${current == 'issue' ? 'active' : ''}"><a
		href="${pageContext.request.contextPath}/listissues">Issues</a></li>
	<li class="${current == 'status' ? 'active' : ''}"><a
		href="${pageContext.request.contextPath}/liststatus">Statuses</a></li>
	<li class="${current == 'type' ? 'active' : ''}"><a
		href="${pageContext.request.contextPath}/listtypes">Types</a></li>
	<li class="${current == 'resolution' ? 'active' : ''}"><a
		href="${pageContext.request.contextPath}/listresolutions">Resolutions</a></li>
	<li class="${current == 'priority' ? 'active' : ''}"><a
		href="${pageContext.request.contextPath}/listpriorities">Priorities</a></li>
	<li class="${current == 'project' ? 'active' : ''}"><a
		href="${pageContext.request.contextPath}/listprojects">Projects</a></li>
	<li class="${current == 'user' ? 'active' : ''}"><a
		href="${pageContext.request.contextPath}/listusers">Users</a></li>
</ul>
<br>