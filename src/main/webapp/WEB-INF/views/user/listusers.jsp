<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Users</title>
	<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
</head>

<body>

   	<div class="panel panel-primary">
      <div class="panel-heading"><h4>Users</h4></div>
    </div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th width="100"><a href="<c:url value='/registration' />" class="btn btn-success">New user</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.email}</td>
					<td align="right"><a href="<c:url value='/edituser/${user.id}' />" class="btn btn-success">edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	  	
</body>
</html>