<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>

<html>
<head>
	<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
</head>
<body>
	<tilesx:useAttribute name="current" />
    <div class="panel panel-primary">
      <div class="panel-heading"><h4>Issue Tracker</h4></div>
    </div>

	<h3></h3>
	<hr color="red" size="10">
	<form:form method="POST" action="${pageContext.request.contextPath}/login" class="form-horizontal">

		<div class="form-group">
    			<label class="col-sm-4 control-label">E-mail:</label>
    			<div class="col-sm-8">
      				<input type="text" class="form-control" id="usr" placeholder="Enter the E-mail">
    			</div>
  			</div>
    		
		<div class="form-group">
    			<label class="col-sm-4 control-label">Password:</label>
    			<div class="col-sm-8">
      				<input type="password" class="form-control" id="usr" placeholder="Enter the password">
    			</div>
  			</div>

		<div style="text-align: right;">
			<input type="submit" value="Sign in" class="btn btn-success"/>
		</div>

	</form:form>
		<hr size="10">
	<h4></h4>

      <ul class="nav nav-pills nav-stacked">
        <li class="${current == 'issue' ? 'active' : ''}"><a href="${pageContext.request.contextPath}/">Issues</a></li>
        <li class="${current == 'status' ? 'active' : ''}"><a href="${pageContext.request.contextPath}/liststatus">Statuses</a></li>
        <li class="${current == 'type' ? 'active' : ''}"><a href="${pageContext.request.contextPath}/listtypes">Types</a></li>
        <li class="${current == 'resolution' ? 'active' : ''}"><a href="${pageContext.request.contextPath}/listresolutions">Resolutions</a></li>
        <li class="${current == 'priority' ? 'active' : ''}"><a href="${pageContext.request.contextPath}/listpriorities">Priorities</a></li>
        <li class="${current == 'project' ? 'active' : ''}"><a href="${pageContext.request.contextPath}/listprojects">Projects</a></li>
        <li class="${current == 'user' ? 'active' : ''}"><a href="${pageContext.request.contextPath}/listusers">Users</a></li>
      </ul><br>
</body>
</html>