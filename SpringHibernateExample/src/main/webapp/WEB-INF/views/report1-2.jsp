<%@include file="taglib_includes.jsp"%>
<div class="container3 container">


	<div class="PushDiv3"></div>

	<h1>Report 1 table</h1>
	

	<div class="container5 container">
		<div class="table-responsive">
			<table class="table">

				<thead>
					<tr class="info">
						<th>#</th>
						<th>Department Name</th>
						<th>Department Manger</th>
						<th>Number of Employees</th>
						<th>Total Salary</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${departmentsReport}" var="dReport">
						<tr>
							<td>${dReport.departmentId}</td>
							<td>${dReport.departmentName}</td>
							<td>${dReport.departmentManager}</td>
							<td>${dReport.employeesCount}</td>
							<td>${dReport.totalSalaries}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>

	<div class="PushDiv3"></div>

</div>