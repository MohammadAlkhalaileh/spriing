<%@include file="../../taglib_includes.jsp"%>
<nav role="navigation" class="navbar navbar-inverse">

	<div class="navbar-header">
		<button type="button" data-target="#navbarCollapse"
			data-toggle="collapse" class="navbar-toggle">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a href="${pageContext.request.contextPath}/index" class="navbar-brand">Human Resources</a>
	</div>

	<div id="navbarCollapse" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="${pageContext.request.contextPath}/index">Home</a></li>
			<sec:authorize access="hasRole('ViewDept')">
				<li><a href="${pageContext.request.contextPath}/department/departments-form">Departments</a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ViewEmp')">
			<li><a href="${pageContext.request.contextPath}/employee/employees-form">Employees</a></li>
			</sec:authorize>
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#">Reports<b class="caret"></b></a>
				<ul role="menu" class="dropdown-menu">
				<sec:authorize access="hasRole('DepartmentsEmployeesSummaryReport')">
					<li><a
						href="${pageContext.request.contextPath}/department/DepartmentsEmployeesSummaryReport">Report
							1</a></li>
							</sec:authorize>
							<sec:authorize access="hasRole('DepartmentsEmployeesCountReport')">
					<li><a
						href="${pageContext.request.contextPath}/department/DepartmentsEmployeesCountReport">Report
							2</a></li>
							</sec:authorize>
							<sec:authorize access="hasRole('EmployeesSalariesSummary')">
					<li><a
						href="${pageContext.request.contextPath}/employee/EmployeesSalariesSummary">Report
							3</a></li>
							</sec:authorize>
							<sec:authorize access="hasRole('SumOfSalaryInCity')">
					<li><a
						href="${pageContext.request.contextPath}/employee/SumOfSalaryInCityReport">Report
							4</a></li>
							</sec:authorize>
							<sec:authorize access="hasRole('EmployeesMaritalStatus')">
					<li><a
						href="${pageContext.request.contextPath}/employee/EmployeesMaritalStatus">Report
							5</a></li>
							</sec:authorize>	
							<sec:authorize access="hasRole('TotalSalaryInDepartment')">
					<li><a
						href="${pageContext.request.contextPath}/employee/TotalSalaryInDepartment">Report
							6</a></li>
							</sec:authorize>	
				</ul></li>
		</ul>
		<form role="search" class="navbar-form navbar-left">
			<div class="form-group">
				<input type="text" placeholder="Search" class="form-control">
			</div>
		</form>
		
		<ul class="nav navbar-nav navbar-right">
			<li><a href="${pageContext.request.contextPath}/logout">Log Out</a></li>
		</ul>
	</div>

</nav>