<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

<script src="<core:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>

<link rel="stylesheet"
	href="<core:url value="/resources/css/bootstrap.min.css"/>">


</head>

<body>
	<div class="container-fluid">
		<div class="row">
      		 <jsp:include page="/WEB-INF/jsp/approver/navlink.jsp"/>
			<div class="col-md-10 col-xs-12 col-sm-12 col-md-offset-2 col-sm-offset-2" style="padding-top:56px">
			

						
			<div class="panel panel-default" >
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">Students for Approver</h3>
						</div>
						<div class="table-responsive">
						
						<table class="table">
							<tr>
								<th>Student Name</th>
								<th>Address</th>
								<th>Mother's Name</th>
								<th>Previous School and Class</th>
								<th>Admission For Class</th>
								<th colspan="3" ><center>Actions</center></th>
							</tr>
															<core:forEach items="${stuDetails}" var="stuDet">
							
							<tr>
								<td>${stuDet.stuFirstName } ${stuDet.stuMiddleName } ${stuDet.stuLastName }</td>
								<td>${stuDet.taluka } ${stuDet.district } ${stuDet.state }</td>
								<td>${stuDet.motherName }</td>
								<td>${stuDet.previousSchName }${schDet.previousSchClass }</td>
								<td>${stuDet.standard }</td>
								
								<td><a href="approveStu?approverEmail=${loginSession.email }&rollNo=${stuDet.rollNo}" class="btn btn-primary btn-xs">Approve</a></td>
								<td><a href="rejectStu" class="btn btn-primary btn-xs">Reject</a></td>
								<td><a href="moreDetails?rollNo=${stuDet.rollNo }&schoolId=${stuDet.schoolId}" class="btn btn-primary btn-xs ">More Details</a>
							</tr>
															</core:forEach>
							
						</table>
						</div>
					</div>
					<h3 style="color: green">${resultSuccess}</h3>
						<h3 style="color: red">${resultFail}</h3>
				</div>


			</div>
		</div>
	</div>
</body>
</html>