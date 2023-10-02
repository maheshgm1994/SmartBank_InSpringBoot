<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="index.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>


	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<h4>New Corporate</h4>
				<form:form action="./registerCorporate" modelAttribute="corpoModel"
					method="post">
					<%-- <h2>
						<c:if test="${corpoModel.name != null}">
                                    Edit Corporate Customers
                                </c:if>
						<c:if test="${user.name == null}">
                                 
                                </c:if>
					</h2> --%>

					<%-- <input type="hidden" path="id" value="<c:out value='${user.id}' />" />
 --%>

					<fieldset class="form-group">
						<label>Corporate Name</label>
						<form:input type="text" class="form-control" path="name"
							required="required" />
					</fieldset>

					<fieldset class="form-group">
						<label>Corporate Branch</label>
						<form:input type="text" class="form-control" path="branch" />
					</fieldset>

					<fieldset class="form-group">
						<label>Corporate Address</label>

						<div class="form-group">

							<form:textarea placeholder="Address" path="address"
								class="form-control" id="exampleFormControlTextarea1" rows="3" />
						</div>
					</fieldset>
					<button type="submit" class="btn btn-success">Save</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>