<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="../taglib_includes.jsp"%>
<html>

<head>
<title>Departments</title>

<meta charset="UTF-8">
<!-- let's add tag srping:url -->
<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
<spring:url value="/resources/css/Style.css" var="styleCSS" />
<spring:url value="/resources/js/bootstrap.min.js" var="crunchifyJS" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link href="${bootstrapCSS}" rel="stylesheet" />
<link href="${styleCSS}" rel="stylesheet" />
<script src="${crunchifyJS}"></script>

</head>

<body>

	<nav role="navigation" class="navbar navbar-inverse">

		<div class="navbar-header">
			<button type="button" data-target="#navbarCollapse"
				data-toggle="collapse" class="navbar-toggle">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="/SpringHibernateExample/index" class="navbar-brand">Human Resources</a>
		</div>

		<div id="navbarCollapse" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/SpringHibernateExample/index">Home</a></li>
				<li class="active"><a href="departments-form">Departments</a></li>
				<li><a href="/SpringHibernateExample/employee/employees-form">Employees</a></li>
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#">Reports<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="DepartmentsEmployeesSummaryReport">Report 1</a></li>
						<li><a href="DepartmentsEmployeesCountReport">Report 2</a></li>
						<li><a href="report3.html">Report 3</a></li>
					</ul></li>
			</ul>
			<form role="search" class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" placeholder="Search" class="form-control">
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.html">Log Out</a></li>
			</ul>
		</div>

	</nav>

	<div class="container3 container">


		<div class="PushDiv2"></div>

		<h1>Departments Form</h1>
		<div class="container2 container">
			<!--<form class="form-horizontal" role="form">-->
			<form:form method="POST" modelAttribute="department" class="form-horizontal"
				role="form">
				<div class="form-group">
					<label for="inputName" class="col-sm-3 control-label">Department
						Name</label>
					<div class="col-sm-7">
						<form:input path="name" type="text"
							class="form-control col-sm-offset-1"
							placeholder="Department Name" />
					</div>
				</div>

				<div class="form-group">
					<label for="inputLocation" class="col-sm-3 control-label">Department
						Location</label>
					<div class="col-sm-7">
						<form:input path="location" type="text"
							class="form-control col-sm-offset-1"
							placeholder="Department Location" />
					</div>
				</div>

				<div class="form-group">
					<label for="inputManger" class="col-sm-3 control-label">Department
						Manger</label>
					<div class="col-sm-4 col-sm-offset-13">
						<form:select path="manager.id" class="form-control">
							
							<form:options items="${employees}" itemValue="id"
								itemLabel="name" />
						</form:select>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-1">
						<c:choose>
						<c:when test="${edit}">
							<button type="submit" class="btn btn-primary">Update</button>
						</c:when>
						<c:otherwise>
							<button type="submit" class="btn btn-primary">Register</button>
						</c:otherwise>
					</c:choose>
					</div>

					<div class="col-sm-offset-1 col-sm-1">
						<button type="submit" class="btn btn-danger">Cancel</button>
					</div>
				</div>

			</form:form>
		</div>

		<div class="PushDiv3"></div>

		<h1>Departments Details</h1>

		<div class="container2 container">
			<div class="table-responsive">
				<table class="table">

					<thead>
						<tr class="info">
							<th>#</th>
							<th>Department Name</th>
							<th>Department Location</th>
							<th>Department Manger</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${departments}" var="department">
							<tr class="active">
								<td>${department.id}</td>
								<td>${department.name}</td>
								<td>${department.location}</td>
								<td>${department.manager.name}</td>
								<td><a href="<c:url value='edit-${department.id}-department' />">Edit</a></td>
								<td><a href="<c:url value='delete-${department.id}-department' />">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>

		<div class="PushDiv2"></div>


	</div>

	<div class="panel panel-default">
		<div class="panel-body">All Copyright © MCC Arabia 2014</div>
		<div class="panel-footer clearfix">
			<div class="pull-right">
				<a href="#" class="btn btn-primary">Back to top</a>
			</div>
		</div>
	</div>


</body>

</html>
