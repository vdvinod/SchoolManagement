<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Division</title>
<script src="<core:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>

<link rel="stylesheet"
	href="<core:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<jsp:include
					page="/WEB-INF/jsp/school/navlink.jsp" />
			<div class="col-md-10 col-xs-10 col-sm-10 col-md-offset-2 col-sm-offset-2" style="padding-top:56px">
				
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">New Division</h3>
						</div>
						<form:form action="addDivisionSch" modelattribute="newDivision">
							<table class="table ">
							<tr>
							<th>New Division</th>
							</tr>
							<tr>
							<td><input type="text" name="newDivision" class="input-sm"></td>
							</tr>
							</table>
							<input type="submit" value="Add" class="btn btn-primary " >
		<input type="reset" value="Clear" class="btn btn-primary ">
						</form:form>
					</div>
					<h3 style="color:green">${resultSuccess}</h3>
<h3 style="color:red">${resultFail}</h3>
				</div>
			</div>
		</div>
	</div>
</body>
</html>