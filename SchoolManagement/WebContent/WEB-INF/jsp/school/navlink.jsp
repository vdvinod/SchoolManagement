<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
<script src="<core:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
<link rel="stylesheet" href="<core:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<core:url value="/resources/css/mystle.css"/>">
<script src="<core:url value="/resources/js/bootstrap.js"/>"></script>
<style>
*{
	padding:0;
	margin:0;

}
	.sidelink{
		height:650px;
		background-color:#5baf88;;
		position:fixed;
		padding-top:50px;
		color:white;
		font-family:JosefinSans-Light;
		margin-left:0px;
	}
	.sidelink li{
		padding-top:12px;
		font-size:18px;
		text-decoration:none;
		
	}
	.sidelink li:hover{
		padding-top:12px;
		font-size:20px;
		color:#84e6ff;
		cursor:pointer;
		font-size:20px;
		font-style:italic;
		text-decoration:none;
	}
	.active{
		color:#84e6ff;
	}
	.droplinks{

		padding-top:12px;
		font-size:18px;
		cursor:pointer;
	}
	#school{
		color:green;
		font-size:35px;
		font-family:Junction-light;
		padding-left:15px;
	}
	
/* 	Hover On Configuration */
	.config{
	position:relative;
	}
	.config .configlinks{
	visibility:hidden;
	width:100px;
	background-color:gray;
	color:#fff;
	text-align:center;
	border-radius:6px;
	position:absolute;
	z-index:1;
	}
	.config:hover .configlinks
	{
	visibility:visible;
	}
	.configlinks li a{
    text-decoration: none;
    color:white;
	}
	.sidelink ul li a{
	text-decoration: none;
    color:white;
	}
	.link li a{
	text-decoration: none;
    color:black;
	}
</style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" style="margin:0px;">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed"  data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false" aria-controls="bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
	<span id="school">${schName}</span>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
  
      <ul class="nav navbar-nav">
    	
        <li>
        <ul style="list-style-type: none;" class="visible-xs droplinks pull-right link">
        			<li><a href="showStuSch">Students</a></li>
					<li class="config"><span class="glyphicon glyphicon-triangle-bottom"  ></span>Configuration
					<ul class="configlinks" style="list-style-type:none;">
					<li><a href="newClassSch"> New Class</a></li>
					<li><a href="newDivisionSch"> New Division</a></li>
					<li><a href=""> New Sport</a></li>
					
					</ul>
					</li>
					<li class="config">Activities<span class="glyphicon glyphicon-triangle-bottom "  ></span>
		<ul class="configlinks" style="list-style-type:none;">
					<li><a href=""> New Hobby</a></li>
					<li><a href=""> New Exam</a></li>
					<li><a href=""> New Sport</a></li>
					<li><a href="newCategorySch"> New Category</a></li>
					
					</ul>
		</li>
					<li>Example</li>
					
		</ul>
			</li>
		 <li role="separator" class="divider"></li>
           
        
      </ul>
       <a href="logout" style="color:#ed6d6d; padding-right:10px; padding-top:10px;" class="pull-right">LogOut<span class="glyphicon glyphicon-log-out"></span></a>
      </div>
      </nav>
<div class="col-md-2 hidden-xs sidelink">
	
	<ul style="list-style-type:none;" >
		<li class="active"><a href="showStuSch">Students</a></li>
		<li class="config">Configuration<span class="glyphicon glyphicon-triangle-bottom pull-right"  ></span>
					<ul class="configlinks" style="list-style-type:none;">
					<li><a href="newClassSch"> New Class</a></li>
					<li><a href="newDivisionSch"> New Division</a></li>
					<li><a href=""> New Sport</a></li>
					<li><a href="newCategorySch"> New Category</a></li>
		
					
					</ul>
					</li>
					<li class="config">Activities<span class="glyphicon glyphicon-triangle-bottom pull-right"  ></span>
		<ul class="configlinks" style="list-style-type:none;">
					<li><a href=""> New Hobby</a></li>
					<li><a href=""> New Exam</a></li>
					<li><a href=""> New Sport</a></li>
					
					</ul>
		</li>
		<li><a href="">Example</a></li>
		
	</ul>
</div>

</body>
</html>