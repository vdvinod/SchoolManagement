<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add School</title>
<script src="<core:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>

<link rel="stylesheet"
	href="<core:url value="/resources/css/bootstrap.min.css"/>">


</head>
<body>
<div class="container-fluid">
		<div class="row">
			<jsp:include page="/WEB-INF/jsp/admin/navlink.jsp" />
			<div
				class="col-md-10 col-xs-12 col-sm-10 col-md-offset-2 col-sm-offset-2"
				style="padding-top: 56px">
				<div class="panel panel-default"  id="add-school-div">
					<div class="panel-body">
						<div class="page-header ">

							<h3 align="center">Edit School</h3>
						</div>
						<div class="table-responsive">

							<form:form action="editSchoolAdmin" modelattribute="addSchool">
								<table class="table ">
									<tr>
										<th>School Name</th>
										<th>Contact No</th>
									</tr>
									<tr>
										<td><input type="text" name="schoolId" value="${editSch.schoolId}" hidden> 
											<input type="text" name="schoolName" value="${schoolName }"
											class="input-sm"></td>
										<td><input type="text" name="contactNo" class="input-sm" value="${editSch.contactNo }"></td>
									</tr>
									<tr>
										<th>Address</th>
										<th>Sender Name</th>
									</tr>
									<tr>
										<td><textarea name="address" class="input-sm" value="${editSch.address }"></textarea></td>
										<td><select name="senderName" class="input-sm">
												<option value="${editSch.senderName }" label="${editSch.senderName }" />
												<core:forEach items="${customerList}" var="customerDetails">
													<option value="${customerDetails.userName}">${customerDetails.userName}</option>
												</core:forEach>
										</select></td>
									</tr>
									<tr>
										<th colspan="2">Language</th>
									</tr>
									<tr>
										<td><select name="language" class="input-sm">
												<option value="${editSch.language }" label="${editSch.language }" />
												<option value="marathi">Marathi</option>
												<option value="english">English</option>
										</select></td>
									</tr>
									<tr>
										<td colspan="2"><div class="alert alert-info"
												role="alert">Principal</div></td>
									</tr>
									<tr>
										<th>Name</th>
										<th>Contact No</th>
									</tr>
									<tr>
										<td><input type="text" name="principalName" value="${editSch.principalName }"
											class="input-sm"></td>
										<td><input type="text" name="principalContact" value="${editSch.principalContact }"
											class="input-sm"></td>
									</tr>
									<tr>
										<td colspan="2"><div class="alert alert-info"
												role="alert">Vice Principal</div></td>
									</tr>
									<tr>
										<th>Name</th>
										<th>Contact No</th>
									</tr>
									<tr>
										<td><input type="text" name="vicePrincipalName" value="${editSch.vicePrincipalName }"
											class="input-sm"></td>
										<td><input type="text" name="vicePrincipalContact" value="${editSch.vicePrincipalContact }"
											class="input-sm"></td>
									</tr>
									<tr>
										<td><div class="alert alert-info" role="alert">Approver
												1</div></td>
										<td><div class="alert alert-info" role="alert">Approver
												2</div></td>
									</tr>
									<tr>
										<th>Name</th>
										<th>Name</th>
									</tr>

									<tr>
										<td><input type="text" name="approverName1" value="${editSch.approverName1 }"
											class="input-sm"></td>
										<td><input type="text" name="approverName2" value="${editSch.approverName2 }"
											class="input-sm"></td>

									</tr>

									<tr>
										<th>Contact</th>
										<th>Contact</th>

									</tr>
									<tr>
										<td><input type="text" name="approverContact1" value="${editSch.approverContact1 }"
											class="input-sm"></td>
										<td><input type="text" name="approverContact2" value="${editSch.approverContact2 }"
											class="input-sm"></td>
									</tr>
									
									
								</table>
								<input type="text" name="approverEmail1" value="${editSch.approverEmail1 }" class="input-sm" hidden>
								<input type="text" name="approverEmail2" value="${editSch.approverEmail2 }" class="input-sm" hidden>
								<input type="text" name="approverPassword1" value="${editSch.approverPassword1 }" class="input-sm" hidden>
								<input type="text" name="approverPassword2" value="${editSch.approverPassword2 }" class="input-sm" hidden>
								<input type="text" name="emailSchool" value="${editSch.emailSchool }" class="input-sm" hidden>
								<input type="text" name="passwordSchool" value="${editSch.passwordSchool }" class="input-sm" hidden>
								
								<input type="submit" value="Update" class="btn btn-primary ">
								<input type="reset" value="Clear" class="btn btn-primary ">
							</form:form>
						</div>
						<h3 style="color: green">${resultSuccess}</h3>
						<h3 style="color: red">${resultFail}</h3>
					</div>
				</div>
				</div>
				</div>
				</div>
				

</body>
</html>