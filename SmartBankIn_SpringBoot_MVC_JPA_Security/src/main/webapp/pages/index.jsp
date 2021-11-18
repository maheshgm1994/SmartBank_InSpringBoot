<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.virtusa.model.CustomerModel"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HeaderPage</title>
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

	<nav class="navbar navbar-light navbar-expand-lg text-light"
		style="background-color: #ff0050;">
		<div class="container-fluid">

			<a class="navbar-brand" href="#"><span class="text-danger"><img
					width="100px" class="mk-desktop-logo dark-logo " title="" alt=""
					src="https://buildingbettervalue.smartbank.com/wp-content/uploads/2018/06/sb_horiz_logo_rgb_531x100_revrs.png"></span></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse " id="navbarNavDropdown">
				<ul class="navbar-nav">

					<!-- 	<li class="nav-item"><a class="nav-link" href="./NewCustomer">NewCustomer</a></li>
					<li class="nav-item"><a class="nav-link"
						href="./customersList">CustomersList</a></li>

					<li class="nav-item"><a class="nav-link"
						href="./NewCorporate">NewCorporate</a></li>

					<li class="nav-item"><a class="nav-link" href="./corporateList">CorporateList</a></li>

					<li class="nav-item"><a class="nav-link"
						href="./bankDetails">BankDetails</a></li>
					<li class="nav-item"><a class="nav-link" href="./withdraw">Withdraw</a></li>
					<li class="nav-item"><a class="nav-link" href="./deposit">Deposit</a></li>
					<li class="nav-item"><a class="nav-link" href="./logout">Log
							Out</a></li>
					<li class="nav-item"><a class="nav-link" href="./loginForm">Log
							In</a></li> -->


					<%
					if (session != null) {
						String isAdmin = (String) session.getAttribute("isAdmin");
						if (isAdmin != null) {
							if (isAdmin.equals("true")) {
					%>

					<li class="nav-item"><a class="nav-link" href="./NewCustomer">NewCustomer</a></li>
					<li class="nav-item"><a class="nav-link"
						href="./customersList">CustomersList</a></li>

					<li class="nav-item"><a class="nav-link" href="./NewCorporate">NewCorporate</a></li>

					<li class="nav-item"><a class="nav-link"
						href="./corporateList">CorporateList</a></li>
					<li class="nav-item"><a class="nav-link" href="./AllAccounts">AllAccounts</a></li>

					<%
					} else {
					%>

					<li class="nav-item"><a class="nav-link" href="./bankDetails">BankDetails</a></li>
					<li class="nav-item"><a class="nav-link" href="./withdrawForm">Withdraw</a></li>
					<li class="nav-item"><a class="nav-link" href="./depositForm">Deposit</a></li>
					<li class="nav-item"><a class="nav-link" href="./AllAccounts">AllAccounts</a></li>


					<%
					}
					}
					}
					%>


				</ul>
				<ul class="nav navbar-nav flex-row justify-content-between ml-auto">

					<%
					if (session != null) {
						String userName = (String) session.getAttribute("userName");
						if (userName != null) {
					%>
					<li class="nav-item"><a class="nav-link" href="./logout">Log
							Out</a></li>
					<%
					} else {
					%>
					<li class="nav-item"><a class="nav-link" href="./loginForm">Log
							In</a></li>
					<%
					}
					}
					%>

				</ul>
			</div>
		</div>
	</nav>




</body>
</html>