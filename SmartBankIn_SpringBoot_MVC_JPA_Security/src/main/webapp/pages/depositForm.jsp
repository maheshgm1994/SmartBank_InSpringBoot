<%@ include file="index.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>deposit</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
</head>
<body>
	<div class="text-center">
		<h4>how much do you want to deposit...?</h4>
		<form class="form-inline" action="./depositMoney">
			<div class="form-group mx-sm-3 mb-2">
				<input type="number" class="form-control" min="1000"
					placeholder="enter your money" name="balance">
			</div>
			<button type="submit" class="btn btn-primary mb-2">Deposit</button>

		</form>

	</div>
</body>
</html>
<%@ include file="Footer.html"%>