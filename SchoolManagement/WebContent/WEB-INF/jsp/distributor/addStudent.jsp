<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
<script src="<core:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>

<link rel="stylesheet"
	href="<core:url value="/resources/css/bootstrap.min.css"/>">

<script>
	//function to get division from specific School's Classes

	function getDivision() {

		$.ajax({
			url : 'getSchoolDivisionSch',
			success : function(data) {

				showDivision(data);
			},
			error : function(data, status, errorThrown) {
				alert("Error= " + errorThrown + " Status= " + status);

			}

		});
	}
	function showDivision(data) {
		$("#stream").show(800);

$("#stream1").show(800);
		for (i = 0; i < data.length; i++)
			$('#division').append(
					'<option value="' + data[i] + '">' + data[i] + '</option>');

	}
</script>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
      		 <jsp:include page="/WEB-INF/jsp/admin/navlink.jsp"/>
			<div class="col-md-10 col-xs-12 col-sm-12 col-md-offset-2 col-sm-offset-2" style="padding-top:56px">
			<div class="panel panel-default">
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">Add Student</h3>
						</div>
						<div class="table-responsive">

							<form:form action="addStudentSch" modelattribute="addStudent">
								<table class="table ">
									<tr>
										<td colspan="2"><div class="alert alert-info"
												role="alert">Student Personal Details</div></td>
									</tr>
									<tr>
										<th>Roll No</th>
										<th>Unique Id(Aadhar No)</th>
									</tr>
									<tr>
										<td><input type="text" class="input-sm" name="rollNo"></td>
										<td><input type="text" class="input-sm" name="uniqueId"></td>

									</tr>
									<tr>
										<th>Student Name (First)</th>
										<th>(Middle)</th>
									</tr>
									<tr>
										<td><input type="text" class="input-sm"
											name="stuFirstName"></td>
										<td><input type="text" class="input-sm"
											name="stuMiddleName"></td>
									</tr>
									<tr>
										<th>(Last)</th>
										<th>Mother's Name</th>
									</tr>
									<tr>
										<td><input type="text" class="input-sm"
											name="stuLastName"></td>
										<td><input type="text" class="input-sm" name="motherName"></td>
									</tr>
									<tr>
										<th>Nationality</th>
										<th>Mother Tongue</th>
									</tr>
									<tr>
										<td><input type="text" class="input-sm"
											name="nationality"></td>
										<td><input type="text" class="input-sm"
											name="motherTongue"></td>
									</tr>
									<tr>
										<th>Religion</th>
										<th>Cast</th>
									</tr>
									<tr>
										<td><select name="religion" class="input-sm">
												<option value="" label="Select Religion " />
												<option value="hindu">HINDU</option>
												<option value="muslim">MUSLIM</option>
												<option value="sikh">SIKH</option>
												<option value="christian">CHRISTIAN</option>

										</select></td>
										<td><input type="text" class="input-sm" name="cast"></td>
									</tr>
									<tr>
										<th>Sub Cast</th>
										<th>Birth Place</th>
									</tr>
									<tr>
										<td><input type="text" class="input-sm" name="subCast"></td>
										<td><input type="text" class="input-sm" name="birthPlace"></td>
									</tr>
									<tr>
										<th>Taluka</th>
										<th>District</th>
									</tr>
									<tr>
										<td><input type="text" class="input-sm" name="taluka"></td>
										<td><input type="text" class="input-sm" name="district"></td>
									</tr>
									<tr>
										<th>State</th>
										<th>Country</th>
									</tr>
									<tr>
										<td><input type="text" class="input-sm" name="state"></td>
										<td><input type="text" class="input-sm" name="country"></td>
									</tr>
									<tr>
										<th>Date Of Birth</th>
										<th>Date Of Birth in Words</th>
									</tr>
									<tr>
										<td><input type="date" name="dob" class="input-sm"></td>
										<td><input type="text" name="dobWords" class="input-sm"></td>
									</tr>

									<tr>
										<th>Gender</th>
										<th>Language</th>
									</tr>
									<tr>
										<td><select name="gender" class="input-sm">
												<option value="" label="Select Gender " />
												<option value="male">MALE</option>
												<option value="female">FEMALE</option>

										</select></td>
										<td><select name="language" class="input-sm">
												<option value="" label="Select Language " />
												<option value="hindi">HINDI</option>
												<option value="english">ENGLISH</option>
												<option value="marathi">MARATHI</option>
										</select></td>

									</tr>
									<tr>
										<th>Mobile No</th>
										<th>Bank Account No</th>

									</tr>
									<tr>
										<td><input type="text" name="mobileNo" class="input-sm"></td>
										<td><input type="text" name="bankAccNo" class="input-sm"></td>

									</tr>
									<tr>
										<th colspan="2">Category</th>
									</tr>
									<tr>
										<td colspan="2"><select name="category" class="input-sm">
												<option value="" label="Select Category " />
												<core:forEach items="${customerList}" var="customerDetails">
													<option value="${customerDetails.userName}">${customerDetails.userName}</option>
												</core:forEach>
										</select></td>
									</tr>
									<tr>
										<td colspan="2"><div class="alert alert-info"
												role="alert">Previous School Details</div></td>
									</tr>
									<tr>
										<th>School Name</th>
										<th>Class</th>
									</tr>
									<tr>
										<td><input type="text" name="previousSchName"
											class="input-sm"></td>
										<td><input type="text" name="previousSchClass"
											class="input-sm"></td>
									</tr>


									<tr>
										<td colspan="2"><div class="alert alert-info"
												role="alert">Student New Admission Details</div></td>
									</tr>
									<tr>
										<th>School Name</th>
										<th>Class</th>
									</tr>
									<tr>
									<td><input type="text"  name="schooolName" value="${schName}" disabled></td>
										<td><select name="standard" id="standard"
											onchange="getDivision();" class="input-sm">
												<option value="" label="Select Class " />
												<core:forEach items="${schoolClass}" var="classDeatils">
													<option value="${classDeatils}">${classDeatils}</option>
												</core:forEach>
										</select></td>

									</tr>


									<tr>
										<th>Division</th>

										<th id="stream" style="display: none">Stream</th>
									</tr>
									<tr>
										<td><select name="division" id="division"
											class="input-sm">
												<option value="" label="Select Division " />

										</select></td>
										<td id="stream1" style="display: none"><select
											name="stream" class="input-sm">
												<option value="" label="Select Stream " />
												<option value="science">Science</option>
												<option value="arts">Arts</option>
												<option value="commerce">Commerce</option>
										</select></td>
									</tr>

								</table>
								<input type="submit" value="Add" class="btn btn-primary ">
								<input type="reset" value="Clear" class="btn btn-primary ">
							</form:form>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>