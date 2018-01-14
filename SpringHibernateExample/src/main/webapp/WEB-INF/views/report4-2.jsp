<%@include file="taglib_includes.jsp"%>
<div class="container4 container">

	<div class="PushDiv3"></div>

	<h1>Report 4 table</h1>


	<div class="container2 container">
		<div class="table-responsive">
			<table class="table">

				<thead>
					<tr class="info">
						<th>City</th>
						<th>Sum of Salary</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employeesReport}" var="eReport">
						<tr class="active">
							<td>${eReport.employeeCity}</td>
							<td>${eReport.totalSalaries}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>

	<div class="PushDiv3"></div>


</div>
