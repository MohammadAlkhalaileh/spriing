<%@include file="taglib_includes.jsp"%>
<div class="container3 container">

	<div class="PushDiv2"></div>

	<h1>Departments Form</h1>
	<div class="container2 container">
		<!--<form class="form-horizontal" role="form">-->
		<form:form method="POST" modelAttribute="department"
			class="form-horizontal" role="form">
			<div class="form-group">
				<label for="inputName" class="col-sm-3 control-label">Department
					Name</label>
				<div class="col-sm-7">
					<form:input path="name" type="text"
						class="form-control col-sm-offset-1" placeholder="Department Name" />
				</div>
				<div class="col-xs-9">
					<form:errors path="name" cssClass="error" />
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
				<div class="col-xs-9">
					<form:errors path="location" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="inputManger" class="col-sm-3 control-label">Department
					Manger</label>
				<div class="col-sm-4 col-sm-offset-13">
					<form:select path="manager.id" class="form-control">

						<form:options items="${employees}" itemValue="id" itemLabel="name" />
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-1">
					<c:choose>
						<c:when test="${edit}">
							<sec:authorize access="hasRole('UpdateDept')">
								<button type="submit" class="btn btn-primary">Update</button>
							</sec:authorize>
						</c:when>
						<c:otherwise>
							<sec:authorize access="hasRole('AddDept')">
								<button type="submit" class="btn btn-primary">Register</button>
							</sec:authorize>
						</c:otherwise>
					</c:choose>
				</div>

				<div class="col-sm-offset-1 col-sm-1">
					<sec:authorize access="hasRole('UpdateDept') or hasRole('AddDept')">
						<button type="submit" class="btn btn-danger">Cancel</button>
					</sec:authorize>
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
							<td><sec:authorize access="hasRole('UpdateDept')">
									<a href="<c:url value='edit-${department.id}-department' />">Edit</a>
								</sec:authorize></td>
							<td><sec:authorize access="hasRole('DeleteDept')">
									<a href="<c:url value='delete-${department.id}-department' />">Delete</a>
								</sec:authorize></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>

	<div class="PushDiv2"></div>


</div>