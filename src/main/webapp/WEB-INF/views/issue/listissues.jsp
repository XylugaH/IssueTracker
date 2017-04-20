<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<title>Issues</title>
<form method="POST" action="${contextPath}/searchissue"
	class="form-horizontal">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<div style="width: 100%; height: 1px; clear: both;"></div>
			<div style="width: 60%; float: left; margin-left: 15px;">
				<h4>Issues</h4>
			</div>

			<div style="width: 35%; float: left; margin-left: 5px;">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="input-group">
					<input name="value" type="text" class="form-control"
						placeholder="Search issue"> <span class="input-group-btn">
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

<sec:authorize access="isAuthenticated()">
	<div class="text-right">
		<a href="<c:url value='/addissue' />" class="btn btn-success">Add
			issue</a>
	</div>
</sec:authorize>

<div style="text-align: center">
<nav aria-label="...">
  <ul class="pagination">
    <li class="page-item ${currentpage == 1 ? 'disabled' : ''}">
      <a class="page-link" href="${contextPath}/listissues?page=${currentpage-1}">Previous</a>
    </li>
    <c:forEach begin="1" end="${pagecount}" var="page">
    	<li class="page-item ${currentpage == page ? 'active' : ''}">
      		<a class="page-link" href="${contextPath}/listissues?page=${page}">${page}</a>
    	</li>
    </c:forEach>
    
    <li class="page-item ${currentpage == pagecount ? 'disabled' : ''}">
      <a class="page-link" href="${contextPath}/listissues?page=${currentpage+1}">Next</a>
    </li>
  </ul>
</nav>
</div>

<table class="table table-hover">
	<thead>
		<tr>
			<th><a href="<c:url value='/sortissue?field=id'/>">Id</a></th>
			<th><a href="<c:url value='/sortissue?field=priority' />">Priority</a></th>
			<th><a href="<c:url value='/sortissue?field=assignee' />">Assignee</a></th>
			<th><a href="<c:url value='/sortissue?field=type' />">Type</a></th>
			<th><a href="<c:url value='/sortissue?field=status' />">Status</a></th>
			<th><a href="<c:url value='/sortissue?field=summary' />">Summary</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${issues}" var="issue">
			<tr>
				<sec:authorize access="isAuthenticated()">
					<td><a href="<c:url value='/editissue?id=${issue.id}' />"><span
							class="badge">${issue.id}</span></a></td>
				</sec:authorize>
				<sec:authorize access="!isAuthenticated()">
					<td><a href="<c:url value='/viewissue?id=${issue.id}' />"><span
							class="badge">${issue.id}</span></a></td>
				</sec:authorize>
				<td style="color: ${issue.priority.color}">${issue.priority.name}</td>
				<td>${issue.assignee.firstName}</td>
				<td>${issue.type.name}</td>
				<td>${issue.status.name}</td>
				<td>${issue.summary}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${empty issues}">
	<div class="text-align-center">
		<em class="text-gray">No issues found</em>
	</div>
</c:if>

<div style="text-align: center">
<nav aria-label="...">
  <ul class="pagination">
    <li class="page-item ${currentpage == 1 ? 'disabled' : ''}">
      <a class="page-link" href="${contextPath}/listissues?page=${currentpage-1}">Previous</a>
    </li>
    <c:forEach begin="1" end="${pagecount}" var="page">
    	<li class="page-item ${currentpage == page ? 'active' : ''}">
      		<a class="page-link" href="${contextPath}/listissues?page=${page}">${page}</a>
    	</li>
    </c:forEach>
    
    <li class="page-item ${currentpage == pagecount ? 'disabled' : ''}">
      <a class="page-link" href="${contextPath}/listissues?page=${currentpage+1}">Next</a>
    </li>
  </ul>
</nav>
</div>
