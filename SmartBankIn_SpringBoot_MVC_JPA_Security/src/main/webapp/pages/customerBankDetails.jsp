<%@ include file="index.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

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
	<div class="container-fluid">
		<c:catch var="catchtheException">
			<sql:query var="AllCustmers" dataSource="${dbsource}">
	select distinct account_branch,account_type,account_num,account_Balance,cust_email,cust_id,cust_name
	 from account_model,customer_model where account_cust in(select cust_id from customer_model where cust_id=
	 <c:out value="${sessionScope.cid}" />) and cust_id=account_cust;

	</sql:query>
		</c:catch>


		<c:if test="${catchtheException != null}">
			<p>
				The type of exception is : ${catchtheException} <br /> There is ann
				exception: ${catchtheException.message}
			</p>
		</c:if>
	</div>
	<div class="list-group container-fluid">

		<c:forEach var="cust" items="${AllCustmers.rows}">
			<c:if test="${cust != null}">
				<h4>Account Holder Details</h4>
				<a href="#" class="list-group-item list-group-item-action">name
					:
					<td><c:out value="${cust.cust_name}" /></td>
				</a>
				<a href="#" class="list-group-item list-group-item-action">Account
					Num :
					<td><c:out value="${cust.account_num}" /></td>
				</a>
				<a href="#" class="list-group-item list-group-item-action">Branch
					: <c:out value="${cust.account_branch}" />
				</a>
				<a href="#" class="list-group-item list-group-item-action ">Type
					: <c:out value="${cust.account_type}" />
				</a>
				<a href="./depositForm"
					class="list-group-item list-group-item-action "
					title="update balance">Balance : <c:out
						value="${cust.account_Balance}" />
				</a>
			</c:if>

			<c:if test="${cust == null}">
				<p>you don't have an account please contact to admin</p>
			</c:if>

			<c:if test="${cust != null}">
				<button type="submit" class="btn btn-warning sm-3">
					<a href="./withdrawForm">Withdraw</a>
				</button>
			</c:if>
		</c:forEach>


	</div>

</body>

<%@ include file="Footer.html"%>

