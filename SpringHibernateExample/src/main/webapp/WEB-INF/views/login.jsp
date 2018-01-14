<%@include file="taglib_includes.jsp" %>
<html>

<head>
<title>Login</title>
<meta charset="UTF-8">
<!-- let's add tag srping:url -->
<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
<spring:url value="/resources/css/Style.css" var="styleCSS" />
<spring:url value="/resources/js/bootstrap.min.js" var="crunchifyJS" />
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link href="${bootstrapCSS}" rel="stylesheet" />
<link href="${styleCSS}" rel="stylesheet" />
<script src="${crunchifyJS}"></script>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<div class="container1 container">


		<div class="PushDiv"></div>


		<h2>HR Application Login</h2>

		<form:form method="POST" modelAttribute="user" class="form-horizontal"
			role="form">
			<form:input type="hidden" path="id" id="id" />
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
				<div class="col-xs-9">
					<form:input path="username" type="text" class="form-control"
						id="inputEmail3" placeholder="Email" />
				</div>

				<div class="col-xs-9">
					<form:errors path="username" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-xs-9">
					<form:input path="password" type="password" class="form-control"
						id="inputPassword3" placeholder="Password" />
				</div>
				<div class="col-xs-9">
					<form:errors path="password" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label> <input type="checkbox"> Remember me
						</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-1">
					<button type="submit" class="btn btn-primary">Sign in</button>
				</div>

				<div class="col-sm-offset-1 col-sm-1">
					<button type="submit" class="btn btn-danger">Cancel</button>
				</div>
			</div>

		</form:form>


		<div class="PushDiv"></div>




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
