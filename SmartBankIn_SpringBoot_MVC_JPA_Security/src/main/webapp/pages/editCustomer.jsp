<%@ include file="index.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>newCustomer</title>
<script type="text/javascript">
	var x = document.getElementById("custType");
	function myFunction(evt) {
		console.log("MyFunction : ", evt.target.value)
		var x = document.getElementById("checkCustType");
		if (evt.target.value === "Corporate Customer") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>
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

	<sql:setDataSource var="dbsource" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/smartbank" user="root"
		password="#Mahe9966" />
	<sql:query var="AllCorporate" dataSource="${dbsource}">
    SELECT * FROM corporate_model;
</sql:query>

	<div class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<h3>Welcome</h3>
				<p>You are 30 seconds away from update your own profile!</p>
			</div>
			<div class="col-md-9 register-right ">

				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading ">Add Customer</h3>
						<form:form action="./updateCustomer?cust_id=${custModel.cust_id }"
							modelAttribute="custModel">
							<div class="row register-form">
								<div class="col-md-6">
									<div class="form-group">
										<form:input type="text" path="cust_id" disabled="true"
											class="form-control" />

									</div>
									<div class="form-group">
										<form:input type="text" path="cust_name" class="form-control"
											placeholder="Name *" />

									</div>
									<div class="form-group">
										<form:input type="email" class="form-control"
											pattern="[^@\s]+@[^@\s]+\.[^@\s]+" placeholder="Your Email *"
											value="" path="cust_email" />
									</div>

									<div class="form-group">
										<form:input type="password" class="form-control"
											placeholder="Password *" value="" path="password" />
									</div>

									<div class="form-group" id="setCustType">
										<form:select class="form-control" path="cust_type"
											onchange="myFunction(event)" onclick="myFunction(event)">
											<%-- <form:option disabled class="hidden" selected
												value="selectAccountType" /> --%>
											<form:option lable="Customer" value="Customer" />
											<form:option lable="Corporate Customer"
												value="Corporate Customer" />
										</form:select>
									</div>

									<div class="form-group" id="checkCustType"
										style="display: none">
										<form:select class="form-control" path="cust_corpName">

											<c:forEach var="corp" items="${AllCorporate.rows}">
												<option value="${corp.name}">${corp.name}</option>
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group">

										<form:textarea placeholder="Address" path="cust_address"
											class="form-control" id="exampleFormControlTextarea1"
											rows="3" />
									</div>

									<div class="form-group">
										<div class="maxl">
											<label class="radio inline"> <form:radiobutton
													path="gender" value="Male" /><span> Male </span>
											</label> <label class="radio inline"> <form:radiobutton
													path="gender" value="Female" /> <span>Female </span>
											</label>
										</div>
									</div>
									<div class="form-group">
										<div class="maxl">
											<label class="radio inline"> <form:radiobutton
													path="isActive" value="true" /> <span> Active </span>
											</label> <label class="radio inline"> <form:radiobutton
													path="isActive" value="false" /> <span>InActive </span>
											</label>
										</div>
									</div>
									<div class="form-group">
										<div class="maxl">
											<label class="radio inline"> <form:radiobutton
													path="isAdmin" value="true" /> <span> isAdmin </span>
											</label> <label class="radio inline"> <form:radiobutton
													path="isAdmin" value="false" /> <span>NotAdmin</span>
											</label>
										</div>
									</div>
									<input type="submit" class="btn btn-primary btn-sm btn-block"
										value="updateCustomer" />
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ include file="Footer.html"%>