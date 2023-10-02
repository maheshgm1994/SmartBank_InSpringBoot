<%@ include file="index.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/newAccount.css" rel="stylesheet" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


</head>
<body>
	<div class="container register">
		<div class="row">


			<div class="col-md-9 register-lift">

				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading text-primary">
							Creating New Account for
							<c:out value="${customer.cust_name}" />
						</h3>


						<p>id : ${customer.cust_id}</p>
						<p>name : ${customer.cust_name}</p>
						<p>email : ${customer.cust_email}</p>
						<p>Address : ${customer.cust_address}</p>


						<div class="col-md-9 register-right">


							<form:form modelAttribute="accountModel"
								action="./newBankAccount?cust_id=${customer.cust_id}"
								method="POST">
								<div class="row register-form">
									<div class="col-md-6">
										<div class="form-group">
											<input type="text" class="form-control" disabled
												name="cust_id" value="${customer.cust_id}" />
										</div>
										<div class="form-group">
											<input type="text" class="form-control" disabled
												placeholder="automatic generated account number"
												path="account_number" />
										</div>
										<div class="form-group">
											<form:select class="form-control" required="required"
												path="account_type">
												<option class="hidden" selected disabled>select
													account type</option>
												<form:option value="Salary">Salary</form:option>
												<form:option value="PF">PF</form:option>

											</form:select>
										</div>
										<div class="form-group">
											<form:select class="form-control" path="account_branch">
												<option class="hidden" disabled selected>select
													Branch</option>
												<form:option value="AP">AP</form:option>
												<form:option value="Chennai">Chennai</form:option>
												<form:option value="Hyd">Hyd</form:option>
												<form:option value="Bglr">Bglr</form:option>

											</form:select>
										</div>

										<div class="form-group">
											<form:input type="number" class="form-control" min="1000"
												required="required" placeholder="min balance 1000"
												path="account_Balance" />
										</div>
										<input type="submit" class="btn btn-primary" value="create" />
									</div>
							</form:form>
						</div>

					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ include file="Footer.html"%>