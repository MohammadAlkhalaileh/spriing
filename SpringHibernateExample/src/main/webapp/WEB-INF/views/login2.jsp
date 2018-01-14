<%@include file="taglib_includes.jsp"%>
<%@ page isELIgnored="false" %>
<html>

<head>
<title>Login</title>
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
		<c:url var="loginUrl" value="/login2" />
		<form:form action="${loginUrl}" method="POST" class="form-horizontal"
			role="form">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					<p>Invalid username and password.</p>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">
					<p>You have been logged out successfully.</p>
				</div>
			</c:if>
			<div class="input-group input-sm">
				<label class="input-group-addon" for="username"><i
					class="fa fa-user"></i></label> <input type="text" class="form-control"
					id="username" name="ssoId" placeholder="Enter Username" required>
			</div>
			<div class="input-group input-sm">
				<label class="input-group-addon" for="password"><i
					class="fa fa-lock"></i></label> <input type="password" class="form-control"
					id="password" name="password" placeholder="Enter Password" required>
			</div>
			<div class="input-group input-sm">
				<div class="checkbox">
					<label><input type="checkbox" id="rememberme"
						name="remember-me"> Remember Me</label>
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

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
