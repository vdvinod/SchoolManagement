<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Student</title>
<script src="<core:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>

<link rel="stylesheet"
	href="<core:url value="/resources/css/bootstrap.min.css"/>">

</head>
<body>
<div class="container-fluid">
		<div class="row">
      		 <jsp:include page="/WEB-INF/jsp/school/navlink.jsp"/>
			<div class="col-md-10 col-xs-12 col-sm-10 col-md-offset-2 col-sm-offset-2" style="padding-top:56px">
			<div class="alert alert-success " 
												role="alert">
							<button id="" class="btn btn-info" >Generate TC</button>					
							<button id="" class="btn btn-info " >Generate Bonafide Certificate</button>					
												
												</div>
			<table class="table">
			<tr><td class="alert alert-info " role="alert" colspan="2">
			Personal Details 
			</td></tr>
			<tr>
			<td>Roll No.</td>
			<td>${showStudent.rollNo}</td>
			</tr>
			<tr>
			<td>Unique Id.</td>
			<td>${showStudent.uniqueId}</td>
			</tr>
			<tr>
			<td>Student Name</td>
			<td>${showStudent.stuFirstName} ${showStudent.stuMiddleName} ${showStudent.stuLastName}</td>
			</tr>
			<tr>
			<td>Mother's Name</td>
			<td>${showStudent.motherName}</td>
			</tr>
			<tr>
			<td>Nationality</td>
			<td>${showStudent.nationality}</td>
			</tr>
			<tr>
			<td>Mother Tongue</td>
			<td>${showStudent.motherTongue}</td>
			</tr>
			<tr>
			<td>Religion</td>
			<td>${showStudent.religion} </td>
			</tr>
			<tr>
			<td>Cast</td>
			<td>${showStudent.cast}</td>
			</tr>
			<tr>
			<td>Sub Cast</td>
			<td>${showStudent.subCast} </td>
			</tr>
			<tr>
			<td>Birth Place</td>
			<td>${showStudent.birthPlace}</td>
			</tr>
			<tr>
			<td>Taluka</td>
			<td>${showStudent.taluka} </td>
			</tr>
			<tr>
			<td>District</td>
			<td>${showStudent.district}</td>
			</tr>
			<tr>
			<td>State</td>
			<td>${showStudent.state} </td>
			</tr>
			<tr>
			<td>Country</td>
			<td>${showStudent.country}</td>
			</tr>
			<tr>
			<td>Date Of Birth</td>
			<td>${showStudent.dob}</td>
			</tr>
			<tr>
			<td>Gender</td>
			<td>${showStudent.gender} </td>
			</tr>
			<tr>
			<td>Language</td>
			<td>${showStudent.language}</td>
			</tr>
			<tr>
			<td>Mobile No</td>
			<td>${showStudent.mobileNo} </td>
			</tr>
			<tr>
			<td>Category</td>
			<td>${showStudent.category} </td>
			</tr>
			<tr><td class="alert alert-info " role="alert" colspan="2">
			Current School  Details 
			</td>
			</tr>
			<tr>
			<td>School Name</td>
			<td>${schName} </td>
			</tr>
			<tr>
			<td>Class</td>
			<td>${showStudent.standard}</td>
			</tr>
			<tr>
			<td>Division</td>
			<td>${showStudent.division} </td>
			</tr>
			<tr>
			<td>Stream</td>
			<td>${showStudent.stream}</td>
			</tr>
			
			<tr>
			<td>Approver 1 Status</td>
			<td>${showStudent.approver1Status}</td>
			</tr>
			<tr>
			<td>Approver 2 Status</td>
			<td>${showStudent.approver2Status} </td>
			</tr>
			
			
						<tr><td class="alert alert-info " role="alert" colspan="2">
			Bank Details 
			</td>
			</tr>
			<tr>
			<td>Bank Account No</td>
			<td>${showStudent.bankAccNo}</td>
			</tr>
			<tr>
			<td>Bank Name</td>
			<td>${showStudent.bankName} </td>
			</tr>
			<tr>
			<td>Branch Or IFSC</td>
			<td>${showStudent.branchOrIfsc}</td>
			</tr>
						<tr><td class="alert alert-info " role="alert" colspan="2">
			Previous School Details 
			</td>
			</tr>
			<tr>
			<td>Previous School Name</td>
			<td>${showStudent.previousSchName}</td>
			</tr>
			<tr>
			<td>Previous School Class</td>
			<td>${showStudent.previousSchClass}</td>
			</tr>
						
			</table>
			</div>
			</div>
			</div>
</body>
</html>