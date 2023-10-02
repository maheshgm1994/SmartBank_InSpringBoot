<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.virtusa.model.CustomerModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="index.jsp"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

	<div class="container-fluid">
		<table
			class="table table-hover text-left table-striped container-fluid">
			<thead style="background-color: #808080">
				<tr>
					<th scope="col-2">id</th>
					<th scope="col-2">name</th>
					<th scope="col-2">email</th>
					<th scope="col-2">password</th>
					<th scope="col-2">gender</th>
					<th scope="col-2">type</th>
					<th scope="col-2">address</th>
					<th scope="col-2">isAdmin</th>
					<th scope="col-2">isActive</th>
					<th scope="col-2">cust_corpName</th>
					<th scope="col-2">Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="cust" items="${AllCust}">
					<tr>
						<td><c:out value="${cust.cust_id}" /></td>
						<td><c:out value="${cust.cust_name}" /></td>
						<td><c:out value="${cust.cust_email}" /></td>
						<td><c:out value="${cust.password}" /></td>
						<td><c:out value="${cust.gender}" /></td>
						<td><c:out value="${cust.cust_type}" /></td>
						<td><c:out value="${cust.cust_address}" /></td>
						<td><c:out value="${cust.isAdmin}" /></td>
						<td><c:out value="${cust.isActive}" /></td>
						<td><c:out value="${cust.cust_corpName}" /></td>
						<td>
							<button type="button" class="btn btn-outline-primary btn-sm"text-light">
								<a href="editCustomer?id=<c:out value="${cust.cust_id}"/>">Update</a>
							</button>
							<button type="button" class="btn btn-outline-danger btn-sm"">
								<a
									href="./deleteCustomer?id=<c:out value="${cust.cust_id}" />
							&action=delete">Delete</a>
							</button> <c:if test="${!cust.isActive}">
								<button type="button" class="btn btn-outline-primary btn-sm"">
									<a href="createAccount?id=<c:out value="${cust.cust_id}" />">CreateAccount</a>
								</button>
							</c:if> <c:if test="${cust.isActive}">
								<button type="button" class="btn btn-outline-info btn-sm"">
									<a href="./accountSummary?id=<c:out value="${cust.cust_id}" />">ShowAccount</a>
								</button>
							</c:if>


						</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
		<Button class="btn btn-success btn-sm btn-block">
			<a class="text-light" href="./NewCustomer">New Customer</a>
		</Button>
	</div>

</body>
</html>

<%-- <%@ include file="Footer.html"%> --%>