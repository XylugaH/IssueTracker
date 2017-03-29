<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Priorities List</title>
	<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
</head>

<body>
    <div class="panel panel-primary">
      <div class="panel-heading"><h4>List of priorities</h4></div>
    </div>
		  	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th width="100"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listpriorities}" var="listpriorities">
				<tr>
					<td>${listpriorities.name}</td>
					<td><a href="<c:url value='/edittype/${listpriorities.id}' />" class="btn btn-success">edit</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td/>
				<td><a href="<c:url value='/addpriority' />" class="btn btn-success">+Add</a></td>
			</tr>
		</tbody>
	</table>
	

</body>
</html>