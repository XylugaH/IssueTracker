<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<tilesx:useAttribute name="current" />

<div class="panel panel-primary">
	<div class="panel-heading">
		<h4>Issue Tracker</h4>
	</div>
</div>

<sec:authorize access="isAuthenticated()">
	<ul class="nav nav-pills nav-stacked">
		<li class="${current == 'editprofile' ? 'active' : ''}"><a
			href="${contextPath}/editprofile">Edit profile</a></li>
		<li class="${current == 'changepassword' ? 'active' : ''}"><a
			href="${contextPath}/changepassword">Change password</a></li>
	</ul>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
	<form method="POST" action="${contextPath}/login"
		class="form-horizontal">

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<div style="color: red; text-align: center;">${error}</div>

		<div class="form-group" ${error != null ? 'has-error' : ''}>
			<label class="col-sm-4 control-label">E-mail:</label>

			<div class="col-sm-8">
				<input type="text" name='username' class="form-control"
					placeholder="Enter the E-mail" />
			</div>

		</div>

		<div class="form-group">
			<label class="col-sm-4 control-label">Password:</label>
			<div class="col-sm-8">
				<input type="password" name='password' class="form-control"
					placeholder="Enter the E-mail" />
			</div>
		</div>

		<div style="text-align: right;">
			<input type="submit" value="Sign in" class="btn btn-success" />
		</div>

	</form>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<form method="POST" action="${contextPath}/logout"
		class="form-horizontal">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<h2></h2>
		<div class="form-group">
			<label class="col-sm-8 control-label"><sec:authentication property="principal.username" /></label>
			<div class="col-sm-4">
				<input type="submit" value="Sign out" class="btn btn-success" />
			</div>
		</div>

	</form>
</sec:authorize>

<ul class="nav nav-pills nav-stacked">
	<li class="${current == 'issue' ? 'active' : ''}"><a
		href="${contextPath}/listissues">Issues</a></li>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<li class="${current == 'status' ? 'active' : ''}"><a
			href="${contextPath}/liststatus">Statuses</a></li>
		<li class="${current == 'type' ? 'active' : ''}"><a
			href="${contextPath}/listtypes">Types</a></li>
		<li class="${current == 'resolution' ? 'active' : ''}"><a
			href="${contextPath}/listresolutions">Resolutions</a></li>
		<li class="${current == 'priority' ? 'active' : ''}"><a
			href="${contextPath}/listpriorities">Priorities</a></li>
		<li class="${current == 'project' ? 'active' : ''}"><a
			href="${contextPath}/listprojects">Projects</a></li>
		<li class="${current == 'user' ? 'active' : ''}"><a
			href="${contextPath}/listusers">Users</a></li>
	</sec:authorize>
</ul>
<br>