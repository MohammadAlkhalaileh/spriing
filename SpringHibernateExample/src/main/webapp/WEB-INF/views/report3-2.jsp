<%@include file="taglib_includes.jsp"%>
<div class="container4 container">

	<div class="PushDiv3"></div>
	<h1>Report 3 table</h1>
	
	<div class="container2 container">
		<div class="table-responsive">
			<table class="table">

				<thead>
					<tr class="info">
						<th>#</th>
						<th>Employee Name</th>
						<th>Employee Salary</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employeesReport}" var="eReport">
						<tr>
							<td>${eReport.id}</td>
							<td>${eReport.name}</td>
							<td>${eReport.salary}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>

	<div class="PushDiv3"></div>

</div>