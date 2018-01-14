<%@include file="../taglib_includes.jsp"%>
<html>

<head>
<title>Employees</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
<spring:url value="/resources/css/Style.css" var="styleCSS" />
<spring:url value="/resources/js/bootstrap.min.js" var="crunchifyJS" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
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
				<li><a href="/SpringHibernateExample/department/departments-form">Departments</a></li>
				<li class="active"><a href="employees-form">Employees</a></li>
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#">Reports<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="report1.html">Report 1</a></li>
						<li><a href="report2.html">Report 2</a></li>
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

		<h1>Employees Form</h1>
		<div class="container2 container">
			<form:form method="POST" modelAttribute="employee"
				class="form-horizontal" role="form">
				<div class="form-group">
					<label for="inputName" class="col-sm-3 control-label">Employee
						Name</label>
					<div class="col-sm-7">
						<form:input path="name" type="text"
							class="form-control col-sm-offset-1" placeholder="Employee Name" />
					</div>
				</div>

				<div class="form-group">
					<label for="inputBirth" class="col-sm-3 control-label">Date
						of Birth</label>
					<div class="col-sm-4 col-sm-offset-13">

						<div class="input-group date">
							<form:input path="dateOfBirth" type="text" class="form-control"
								placeholder="Choose Date" />
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-th"></i></span>
						</div>

					</div>
				</div>

				<div class="form-group">
					<label for="inputMarital" class="col-sm-3 control-label">Marital
						Status</label>
					<div class="col-sm-4 col-sm-offset-13">
						<form:select path="maritalStatus.id" class="form-control">
							<form:options items="${maritalStatuses}" itemValue="id"
								itemLabel="name" />
						</form:select>
					</div>
				</div>

				<div class="form-group">
					<label for="inputSalary" class="col-sm-3 control-label">Employee
						Salary</label>
					<div class="col-sm-7">
						<form:input path="salary" type="text"
							class="form-control col-sm-offset-1"
							placeholder="Employee Salary" />
					</div>
				</div>

				<div class="form-group">
					<label for="inputHigher" class="col-sm-3 control-label">Date
						of Higher</label>
					<div class="col-sm-4 col-sm-offset-13">

						<div class="input-group date">
							<form:input path="dateOfHire" type="text" class="form-control"
								placeholder="Choose Date" />
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-th"></i></span>
						</div>
					</div>
				</div>


				<div class="form-group">
					<label for="inputPosition" class="col-sm-3 control-label">Employee
						Title</label>
					<div class="col-sm-4 col-sm-offset-13">
						<form:select path="title.id" class="form-control">
							<form:options items="${titles}" itemValue="id" itemLabel="name" />
						</form:select>
					</div>
				</div>

				<div class="form-group">
					<label for="inputDepartment" class="col-sm-3 control-label">Department
					</label>
					<div class="col-sm-4 col-sm-offset-13">
						<form:select path="department.id" class="form-control">
							<form:options items="${departments}" itemValue="id"
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

		<h1>Employees Details</h1>


		<div class="container5 container">
			<div class="table-responsive">
				<table class="table">

					<thead>
						<tr class="info">
							<th>#</th>
							<th>Employee Name</th>
							<th>Date of Birth</th>
							<th>Marital Status</th>
							<th>Employee Salary</th>
							<th>Date of Higher</th>
							<th>Employee Department</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employees}" var="employee">
							<tr class="active">
								<td>${employee.id}</td>
								<td>${employee.name}</td>
								<td>${employee.dateOfBirth}</td>
								<td>${employee.maritalStatus.name}</td>
								<td>${employee.salary}</td>
								<td>${employee.dateOfHire}</td>
								<td>${employee.department.name}</td>
								<td><a
									href="<c:url value='edit-${employee.id}-employee' />">Edit</a></td>
								<td><a
									href="<c:url value='delete-${employee.id}-employee' />">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>

				</table>
			</div>
		</div>

		<div class="PushDiv2"></div>


		<script>
			$('.input-group.date').datepicker({
				format : "dd/mm/yyyy",
				todayBtn : "linked",
				autoclose : true,
				todayHighlight : true
			});
		</script>
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
