<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
</head>
<body>
	<h4>Issue Tracker</h4>
	<form:form name="submitForm" method="POST">
	<div class="form-group">
  		<label for="usr">Name:</label>
  		<input type="text" class="form-control" id="usr">
	</div>
	<div class="form-group">
  		<label for="pwd">Password:</label>
  		<input type="password" class="form-control" id="pwd">
	</div>
	<button type="button" class="btn btn-success">Sing in</button>
	</form:form>
	<h4></h4>

      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="#section1">Home</a></li>
        <li><a href="/liststatus">List of statuses</a></li>
        <li><a href="#section3">Family</a></li>
        <li><a href="#section3">Photos</a></li>
      </ul><br>
</body>
</html>