<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sender Name</title>
<script src="<core:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>

<link rel="stylesheet"
	href="<core:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
      		 <jsp:include page="/WEB-INF/jsp/admin/navlink.jsp"/>
			<div class="col-md-10 col-xs-12 col-sm-12 col-md-offset-2 col-sm-offset-2" style="padding-top:56px">
			<div class="panel panel-default">
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">New Sender</h3>
						</div>
						<form:form action="newSender" modelattribute="newSender">
							<table class="table " >
							<tr>
							<th>Sender Name</th>
							<th>Type</th>
							</tr>
							<tr>
								<td><input type="text" name="senderName" class="input-sm"></td>
								<td><select name="senderType" class="input-sm">
											<option value="" label="Select Type " />
											<option value="school">School</option>
											<option value="common">Common</option>

									</select></td>
							</tr>
							</table>
							<input type="submit" value="Add" class="btn btn-primary " >
		<input type="reset" value="Clear" class="btn btn-primary ">
							</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>