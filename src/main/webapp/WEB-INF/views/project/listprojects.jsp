<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Projects List</title>
	<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
</head>

<body>
    <div class="panel panel-primary">
      <div class="panel-heading"><h4>List of projects</h4></div>
    </div>
		  	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Manager</th>
				<th>Description</th>
				<th width="100"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listprojects}" var="listprojects">
				<tr>
					<td>${listprojects.name}</td>
					<td>${listprojects.manager.firstName}</td>
					<td>${listprojects.description}</td>
					<td><a href="<c:url value='/edittype/${listprojects.id}' />" class="btn btn-success">edit</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td/>
				<td/>
				<td/>
				<td><a href="<c:url value='/addproject' />" class="btn btn-success">+Add</a></td>
			</tr>
		</tbody>
	</table>
	

</body>
</html>