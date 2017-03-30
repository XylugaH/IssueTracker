<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
</head>
<body>

    <div class="panel panel-primary">
      <div class="panel-heading"><h4>Issue Tracker</h4></div>
    </div>


	<h3></h3>
	<hr color="red">
	<form:form method="POST" action="${pageContext.request.contextPath}/login" class="form-horizontal">

		<div class="row content">
			<div class="col-sm-3 sidenav">
				<label for="usr">E-mail:</label>
			</div>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="usr">
			</div>
		</div>

		<div class="row content">
			<div class="col-sm-3 sidenav">
				<label for="pwd">Password:</label>
			</div>
			<div class="col-sm-9">
				<input type="password" class="form-control" id="pwd">
			</div>
		</div>
		<div style="text-align: right;">
			<input type="submit" value="Sign in" class="btn btn-success"/>
			</div>
	</form:form>
		<hr>
	<h4></h4>

      <ul class="nav nav-pills nav-stacked">
        <li><a href="${pageContext.request.contextPath}/liststatus">List of statuses</a></li>
        <li><a href="${pageContext.request.contextPath}/listtypes">List of types</a></li>
        <li><a href="${pageContext.request.contextPath}/listresolutions">List of resolutions</a></li>
        <li><a href="${pageContext.request.contextPath}/listpriorities">List of priorities</a></li>
        <li><a href="${pageContext.request.contextPath}/listprojects">List of projects</a></li>
      </ul><br>
</body>
</html>