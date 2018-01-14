<%@include file="taglib_includes.jsp"%>
<div class="container4 container">

	<div class="PushDiv3"></div>

	<h1>Report 2 table</h1>


	<div class="container2 container">
		<div class="table-responsive">
			<table class="table">

				<thead>
					<tr class="info">
						<th>#</th>
						<th>Department Name</th>
						<th>Number of Employees</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${departmentsReport}" var="dReport">
						<tr class="active">
							<td>${dReport.departmentId}</td>
							<td>${dReport.departmentName}</td>
							<td>${dReport.employeesCount}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>

	<div class="PushDiv3"></div>


</div>
