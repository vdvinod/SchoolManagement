<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Student</title>

<script src="<core:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>

<link rel="stylesheet"
	href="<core:url value="/resources/css/bootstrap.min.css"/>">
	<script>
	//function to get division from specific School's Classes

	function getDivision(val) {

		if(val>10)
			{
			
			$("#stream").fadeIn(1000);
			$("#stream1").fadeIn(1000);
			}
		else
			{
			$("#stream").fadeOut(1000);
			$("#stream1").fadeOut(1000);
			}
		
		$.ajax({
			url : 'getSchoolDivisionSch',
			success : function(data) {
				$('#division').find('option').remove();

				showDivision(data);
			},
			error : function(data, status, errorThrown) {
				alert("Error= " + errorThrown + " Status= " + status);

			}

		});
	}
	function showDivision(data) {
		
		for (i = 0; i < data.length; i++)
			$('#division').append(
					'<option value="' + data[i] + '">' + data[i] + '</option>');

	}
	</script>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
				<jsp:include page="/WEB-INF/jsp/school/navlink.jsp" />
			<div class="col-md-10 col-xs-10 col-sm-10 col-md-offset-2 col-sm-offset-2" style="padding-top:56px">
			
			<div class="panel panel-default" id="studentInput" >
					<div class="panel-body">
						<div class="page-header ">
						<div>
							<h3 align="center">Edit Student</h3>	
						</div>	
						</div>
						<div class="table-responsive">

							<form:form action="editStudentSch" modelattribute="addStudent">
							<input type="text" name="schoolId" value="${editStudent.schoolId}" hidden>
							<input type="text" name="approver1Status" value="${editStudent.approver1Status}" hidden>
							<input type="text" name="approver2Status" value="${editStudent.approver2Status}" hidden>
								
								<table class="table ">
<tr>
										<td colspan="2"><div class="alert alert-info"
												role="alert">Student New Admission Details</div></td>
									</tr>
									<tr>
										<th>School Name</th>
										<th>Class</th>
									</tr>
									<tr>
										<td><input type="text" name="schooolName" 
											value="${schName}" disabled></td>
										<td><select name="standard" id="standard" 
											onchange="getDivision(this.value);" class="form-control">
												<option value="${editStudent.standard }" label="${editStudent.standard }" />
												<core:forEach items="${schoolClass}" var="classDeatils">
													<option value="${classDeatils}">${classDeatils}</option>
												</core:forEach>
										</select></td>

									</tr>


									<tr>
										<th>Division</th>

										<th id="stream">Stream</th>
									</tr>
									<tr>
										<td><select name="division" id="division" 
											class="form-control">
												<option value="${editStudent.division }" label="${editStudent.division }" />

										</select></td>
										<td id="stream1" ><select 
											name="stream" class="form-control">
												<option value="${editStudent.stream }" label="${editStudent.stream }" />
												<option value="science">Science</option>
												<option value="arts">Arts</option>
												<option value="commerce">Commerce</option>
										</select></td>
									</tr>
									<tr>
										<td colspan="2"><div class="alert alert-info"
												role="alert">Student Personal Details</div></td>
									</tr>
									<tr>
										<th>Roll No</th>
										<th>Unique Id(Aadhar No)</th>
									</tr>
									<tr>
										<td><input type="text" class="form-control" name="rollNo" value="${editStudent.rollNo}"></td>
										<td><input type="text" class="form-control" name="uniqueId" value="${editStudent.uniqueId}"></td>

									</tr>
									<tr>
										<th>Student Name (First)</th>
										<th>(Middle)</th>
									</tr>
									<tr>
										<td><input type="text" class="form-control" value="${editStudent.stuFirstName }"
											name="stuFirstName"></td>
										<td><input type="text" class="form-control" value="${editStudent.stuMiddleName }"
											name="stuMiddleName"></td>
									</tr>
									<tr>
										<th>(Last)</th>
										<th>Mother's Name</th>
									</tr>
									<tr>
										<td><input type="text" class="form-control" value="${editStudent.stuLastName }"
											name="stuLastName"></td>
										<td><input type="text" class="form-control" value="${editStudent.motherName }"
										name="motherName"></td>
									</tr>
									<tr>
										<th>Nationality</th>
										<th>Mother Tongue</th>
									</tr>
									<tr>
										<td><input type="text" class="form-control" value="${editStudent.nationality }"
											name="nationality"></td>
										<td><input type="text" class="form-control" value="${editStudent.motherTongue }"
											name="motherTongue"></td>
									</tr>
									<tr>
										<th>Religion</th>
										<th>Cast</th>
									</tr>
									<tr>
										<td><select name="religion" class="form-control" >
												<option value="${editStudent.religion }" label="${editStudent.religion }" />
												<option value="hindu">HINDU</option>
												<option value="muslim">MUSLIM</option>
												<option value="sikh">SIKH</option>
												<option value="christian">CHRISTIAN</option>

										</select></td>
										<td><input type="text" class="form-control" value="${editStudent.cast }" name="cast"></td>
									</tr>
									<tr>
										<th>Sub Cast</th>
										<th>Birth Place</th>
									</tr>
									<tr>
										<td><input type="text" class="form-control" name="subCast" value="${editStudent.subCast }"></td>
										<td><input type="text" class="form-control" name="birthPlace" value="${editStudent.birthPlace }"></td>
									</tr>
									<tr>
										<th>Taluka</th>
										<th>District</th>
									</tr>
									<tr>
										<td><input type="text" class="form-control" name="taluka" value="${editStudent.taluka }"></td>
										<td><input type="text" class="form-control" name="district" value="${editStudent.district }"></td>
									</tr>
									<tr>
										<th>State</th>
										<th>Country</th>
									</tr>
									<tr>
										<td><input type="text" class="form-control" name="state" value="${editStudent.state }"></td>
										<td><input type="text" class="form-control" name="country" value="${editStudent.country }"></td>
									</tr>
									<tr>
										<th>Date Of Birth</th>
										<th>Date Of Birth in Words</th>
									</tr>
									<tr>
										<td><input type="date" name="dob" class="form-control" value="${editStudent.dob }"></td>
										<td><input type="text" name="dobWords" class="form-control"></td>
									</tr>

									<tr>
										<th>Gender</th>
										<th>Language</th>
									</tr>
									<tr>
										<td><select name="gender" class="form-control" >
												<option value="${editStudent.gender }"  label="${editStudent.gender }" />
												<option value="male">MALE</option>
												<option value="female">FEMALE</option>

										</select></td>
										<td><select name="language" class="form-control" >
												<option value="${editStudent.language }" label="${editStudent.language }" />
												<option value="hindi">HINDI</option>
												<option value="english">ENGLISH</option>
												<option value="marathi">MARATHI</option>
										</select></td>

									</tr>
									<tr>
										<th>Mobile No</th>
										<th>Category</th>

									</tr>
									<tr>
										<td><input type="text" name="mobileNo" class="form-control" value="${editStudent.mobileNo }"></td>
<td colspan="2"><select name="category" class="form-control" value="${editStudent.category }">
												<option value="" label="Select Category " />
												<core:forEach items="${customerList}" var="customerDetails">
													<option value="${customerDetails.userName}">${customerDetails.userName}</option>
												</core:forEach>
										</select></td>
									</tr>
									<tr>
										<td colspan="2"><div class="alert alert-info"
												role="alert">Bank Details</div></td>
									</tr>
									<tr>
										<th>Bank Name</th>
										<th>Bank Account No</th>
										
									</tr>
									<tr>
										<td><input type="text" name="bankName" class="form-control" value="${editStudent.bankName }"></td>
										<td><input type="text" name="bankAccNo" class="form-control" value="${editStudent.bankAccNo }"></td>

									</tr>
									<tr>
									<th colspan="2">IFSC Code / Branch Name</th>
									</tr>
									<tr>
									<td colspan="2"><input type="text" name="branchOrIfsc" class="form-control" value="${editStudent.branchOrIfsc }"></td>
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
										<td><input type="text" name="previousSchName" value="${editStudent.previousSchName }"
											class="form-control"></td>
										<td><input type="text" name="previousSchClass" value="${editStudent.previousSchClass }"
											class="form-control"></td>
									</tr>


									

								</table>
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