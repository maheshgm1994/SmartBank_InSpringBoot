<%@ include file="index.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.virtusa.model.CustomerModel"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<sql:setDataSource var="dbsource" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/smartbank" user="root"
		password="#Mahe9966" />

	<c:catch var="catchtheException">
		<sql:query var="AllCust" dataSource="${dbsource}">
	select distinct account_branch,account_type,account_num,cust_corp_name,account_Balance,cust_email,cust_id,cust_name
	 from account_model,customer_model where account_cust in(select cust_id from customer_model where cust_id=account_cust);
	
		</sql:query>
	</c:catch>
	<!-- cust_id=
	 ?) and  -->

	<div class="container-fluid">
		<table
			class="table table-hover text-left table-striped container-fluid">
			<thead style="background-color: #808080">
				<tr>
					<th scope="col-2">cust_id</th>
					<th scope="col-2">cust_name</th>
					<th scope="col-2">cust_email</th>
					<th scope="col-2">account_num</th>
					<th scope="col-2">account_branch</th>
					<th scope="col-2">account_type</th>
					<th scope="col-2">account_Balance</th>
					<th scope="col-2">cust_corp_name</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach var="cust" items="${AllCust.rows}">
					<tr>
						<td><c:out value="${cust.cust_id}" /></td>
						<td><c:out value="${cust.cust_name}" /></td>
						<td><c:out value="${cust.cust_email}" /></td>
						<td><c:out value="${cust.account_num}" /></td>
						<td><c:out value="${cust.account_branch}" /></td>
						<td><c:out value="${cust.account_type}" /></td>

						<td><c:out value="${cust.account_Balance}" /></td>
						<td><c:out value="${cust.cust_corp_name}" /></td>


					</tr>
				</c:forEach>


			</tbody>
		</table>

	</div>

</body>
</html>

<%-- <%@ include file="Footer.html"%> --%>