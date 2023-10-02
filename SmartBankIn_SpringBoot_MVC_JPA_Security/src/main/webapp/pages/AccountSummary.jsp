<%@ include file="index.jsp"%>
<!DOCTYPE html>
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
		<sql:query var="AllCustmers" dataSource="${dbsource}">
	select distinct account_branch,account_type,account_num,account_Balance,cust_email,cust_id,cust_name
	 from account_model,customer_model where account_cust in(select cust_id from customer_model where cust_id=
	 ?) and cust_id=account_cust;
		<sql:param value="${param.id}" />
		</sql:query>
	</c:catch>


	<c:if test="${catchtheException != null}">
		<p>
			The type of exception is : ${catchtheException} <br /> There is ann
			exception: ${catchtheException.message}
		</p>
	</c:if>
	<div class="list-group container">
		<h4>Account Holder Details</h4>
		<c:forEach var="cust" items="${AllCustmers.rows}">
			<a href="#" class="list-group-item list-group-item-action">name :
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
			<a href="#" class="list-group-item list-group-item-action "
				title="update balance">Balance : <c:out
					value="${cust.account_Balance}" />
			</a>
		</c:forEach>
	</div>
</body>

<%@ include file="Footer.html"%>