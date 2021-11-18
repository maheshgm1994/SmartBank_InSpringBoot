<%-- <%@ include file="index.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>updateCustomer</title>
<link href="/newAccount.css" rel="stylesheet" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<script type="text/javascript">
	var x = document.getElementById("custType");
	function myFunction(evt) {
		var x = document.getElementById("checkCustType");
		if (evt.target.value === "Corporate Customer") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>

</head>
<body>
	<div class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="ntg" />
				<h3>Welcome</h3>
				<p>You are 30 seconds to update your details!</p>

			</div>
			<div class="col-md-9 register-right">

				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading">Welcome to SmartBank</h3>

						<form:form action="./updateCustomer" modelAttribute="custModel1"
							method="POST">
							<c:forEach var="cust" items="${custModel}">
								<div class="row register-form">
									<div class="col-md-6">
										<div class="form-group">

											<form:hidden path="cust_id" value="${cust.cust_id}" />
											<form:input type="text" class="form-control"
												placeholder="Name *" value="${cust.cust_name}"
												path="cust_name" />
										</div>
										<div class="form-group">
											<form:input type="email" class="form-control"
												placeholder="Your Email *" value="${cust.cust_email}"
												path="cust_email" />
										</div>

										<div class="form-group">
											<form:input type="password" class="form-control"
												placeholder="Password *" value="${cust.password}"
												path="password" />
										</div>

										<div class="form-group" id="setCustType">
											<form:select class="form-control" path="cust_type"
												value="${cust.cust_type}" onchange="myFunction(event)"
												onload="myFunction(event)">

												<form:option value="Customer">Customer</form:option>
												<from:option value="Corporate Customer">Corporate Customer</from:option>
											</form:select>
										</div>

										<div class="form-group" id="checkCustType"
											style="display: none">
											<form:select class="form-control" path="cust_corpName">

												<c:forEach var="corp" items="${AllCorporate.rows}">
													<form:option value="${corp.name}">
														${corp.name}
													</form:option>
												</c:forEach>
											</form:select>
										</div>
										<div class="form-group">
											<label for="exampleFormControlTextarea1">Address</label>
											<form:textarea path="cust_address" class="form-control"
												id="exampleFormControlTextarea1" rows="3"
												value="${cust.cust_address}" />

										</div>

										<div class="form-group">
											<div class="maxl">
												<label class="radio inline"> <form:radiobutton
														path="gender" value="${cust.gender}" /> <span>
														male </span></label> <label class="radio inline"> <input
													type="radio" path="gender" value="${cust.gender}">
													<span>female </span>
												</label>
											</div>
										</div>
										<div class="form-group">
											<div class="maxl">
												<label class="radio inline"> <form:radiobutton
														path="isActive" value="${cust.isActive}" /> <span>
														Active </span></label> <label class="radio inline"> <form:radiobutton
														path="isActive" value="${cust.isActive}" /> <span>NotActive
												</span>
												</label>
											</div>
										</div>
										<div class="form-group">
											<div class="maxl">
												<label class="radio inline"> <<form:radiobutton
														path="isAdmin" value="${cust.isAdmin}" /> <span>
														isAdmin </span>
												</label> <label class="radio inline"> <form:radiobutton
														path="isAdmin" value="${cust.isAdmin}" /> <span>NotAdmin
												</span>
												</label>
											</div>
										</div>

										<input type="submit" class="btn btn-primary" value="update" />
									</div>
							</c:forEach>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ include file="Footer.html"%> --%>