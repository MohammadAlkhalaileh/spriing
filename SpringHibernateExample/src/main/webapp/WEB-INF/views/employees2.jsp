<%@include file="taglib_includes.jsp"%>
<div class="container3 container">

	<div class="PushDiv2"></div>
<h1>total number loggedin,${toot}
		</h1>
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
				<div class="col-xs-9">
					<form:errors path="name" cssClass="error" />
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
					<div class="col-xs-9">
						<form:errors path="dateOfBirth" cssClass="error" />
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
				<div class="col-xs-9">
					<form:errors path="maritalStatus.id" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="inputSalary" class="col-sm-3 control-label">Employee
					Salary</label>
				<div class="col-sm-7">
					<form:input path="salary" type="text"
						class="form-control col-sm-offset-1" placeholder="Employee Salary" />
				</div>
				<div class="col-xs-9">
					<form:errors path="salary" cssClass="error" />
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
					<div class="col-xs-9">
						<form:errors path="dateOfHire" cssClass="error" />
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
				<label for="inputcountry" class="col-sm-3 control-label">country</label>
				<div class="col-sm-7">
					<form:input path="address.country" type="text"
						class="form-control col-sm-offset-1" placeholder="country" />
				</div>
				<div class="col-xs-9">
					<form:errors path="address.country" cssClass="error" />
				</div>
			</div>
			
<div class="form-group">
				<label for="inputcity" class="col-sm-3 control-label">city</label>
				<div class="col-sm-7">
					<form:input path="address.city" type="text"
						class="form-control col-sm-offset-1" placeholder="city" />
				</div>
				<div class="col-xs-9">
					<form:errors path="address.city" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputarea" class="col-sm-3 control-label">area</label>
				<div class="col-sm-7">
					<form:input path="address.area" type="text"
						class="form-control col-sm-offset-1" placeholder="area" />
				</div>
				<div class="col-xs-9">
					<form:errors path="address.area" cssClass="error" />
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-1">
					<c:choose>
						<c:when test="${edit}">
							<sec:authorize access="hasRole('UpdateEmp')">
								<button type="submit" class="btn btn-primary">Update</button>
							</sec:authorize>
						</c:when>
						<c:otherwise>
							<sec:authorize access="hasRole('AddEmp')">
								<button type="submit" class="btn btn-primary">Register</button>
							</sec:authorize>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="col-sm-offset-1 col-sm-1">
					<sec:authorize access="hasRole('UpdateEmp') or hasRole('AddEmp')">
						<button type="submit" class="btn btn-danger">Cancel</button>
					</sec:authorize>
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
						<th>country</th>
						<th>city</th>
						<th>area</th>
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
							<td>${employee.address.country}</td>
							<td>${employee.address.city}</td>
							<td>${employee.address.area}</td>
							<td><sec:authorize access="hasRole('UpdateEmp')">
									<a href="<c:url value='edit-${employee.id}-employee' />">Edit</a>
								</sec:authorize></td>
							<td><sec:authorize access="hasRole('DeleteEmp')">
									<a href="<c:url value='delete-${employee.id}-employee' />">Delete</a>
								</sec:authorize></td>
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
