<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Class</title>
<script src="<core:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>

<link rel="stylesheet"
	href="<core:url value="/resources/css/bootstrap.min.css"/>">
	
<script type="text/javascript">
 var i=1;
var j=1;
function addRow()
{ 
	     var tbl = document.getElementById("addSubject");
     	 var lastRow = tbl.rows.length;
      	 var row = tbl.insertRow(lastRow);
      	 var length=(tbl.rows.length)-2;
		 j=length+1;
		
          var firstCell = row.insertCell(0);
          var inputSrNo = document.createElement("input");
          inputSrNo.type = "text";
          inputSrNo.name =  "subjectAdd["+length+"].srNo";
          inputSrNo.id = "subjectAdd["+length+"].srNo";
          inputSrNo.value=j;
          inputSrNo.className="input-sm";          
          firstCell.appendChild(inputSrNo); 
          
          var secondCell = row.insertCell(1);
          var inputName = document.createElement("input");
          inputName.type = "text";          
          inputName.name = "subjectAdd["+length+"].subName";
          inputName.id ="subjectAdd["+length+"].subName";          
          inputName.className="input-sm";
          secondCell.appendChild(inputName);
          
          
	      var thirdCell = row.insertCell(2);
			var inputDelete = document.createElement("input");
			inputDelete.type = 'button';
			inputDelete.id = "btndel" + length;
			inputDelete.name = "btndel" + length;
			inputDelete.value="-";		
			inputDelete.className="btn btn-danger";			
			inputDelete.onclick=function(){delrow(this);};		
			thirdCell.appendChild(inputDelete);
}
function delrow(obj)
{
  		var tbl = document.getElementById('addSubject');
	    var last = (tbl.rows.length)-1;		
	     var txtSrNo,Customer_Name,Mail,Con,Desg,btndel,next;		
	    if(last == 1)
		 {
			subName=document.getElementById("subjectAdd["+length+"].subName");
			subName.value="";
		 	
		 }
	   else
	     {			
		   var current = window.event.srcElement;							 
		   while ( (current = current.parentElement)  && current.tagName !="TR");
           current.parentElement.removeChild(current);	
		   var counter = obj.id.slice(6);     
	    while(counter<last)
		 {
		next = counter;
	 	next++;	
	 	var txtSrNo = document.getElementById("subjectAdd["+next+"].srNo");	 	
	 	txtSrNo.id = "subjectAdd["+counter+"].srNo";
	 	txtSrNo.name = "subjectAdd["+counter+"].srNo";
	 	var sr=txtSrNo.value-1;	 	
	 	txtSrNo.value =sr;
	 	
	 	var name = document.getElementById("subjectAdd["+next+"].subName");
	 	name.id = "subjectAdd["+counter+"].subName";	 	
	 	name.name = "subjectAdd["+counter+"].subName";
	 
	 	 
	 	btndel = document.getElementById("btndel"+next);
	 	btndel.id = "btndel"+counter;
	 	btndel.name = "btndel"+counter;
	 		
	 	counter++;
	  }
   }   
}
</script>
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
							<h3 align="center">New Class</h3>
						</div>
						<form:form action="addClassSch" modelattribute="newClass">
							<table class="table ">
							<tr>
							<th colspan="3">Class Name</th>
							</tr>
							<tr>
							<td colspan="3"><input type="text" name="className" class="input-sm"></td>
							</tr>
							<tr>
								<td colspan="3"><div class="alert alert-info" role="alert" >Subject Details</div></td>
								</tr>
								<tr>
								<td>
								<table class="table" id="addSubject">
								<tr>
								<th>Sr No.</th>
								<th> Subject Name</th>
								<th>Action</th>
								</tr>
								<tr>
								<td><input type="text" name="subjectAdd[0].srNo" id="subjectAdd[0].srNo" class="input-sm" value="1"></td>
								<td><input type="text" name="subjectAdd[0].subName" id="subjectAdd[0].subName" class="input-sm"></td>
								<td><input type="button" value="-"  name="button"  class="btn btn-danger" onclick="delrow(this);"></td>
								</tr>
								</table>
								<input type="button" value="+" name="btnAdd" class="btn-info" onclick="addRow();">
								
								</td>
								</tr>
							</table>
							<input type="submit" value="Add Class" class="btn btn-primary " >
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