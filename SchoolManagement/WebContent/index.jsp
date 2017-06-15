<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>School Management</title>
<!-- BOOTSTRAP CORE STYLE CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" href="<core:url value="/resources/css/bootstrap.min.css"/>"  >
<!-- FONT AWESOME CSS -->
<link href="resources/css/font-awesome.min.css" rel="stylesheet" />
<!-- FLEXSLIDER CSS -->
<link href="resources/css/flexslider.css" rel="stylesheet" />
<!-- CUSTOM STYLE CSS -->
<link href="resources/css/style.css" rel="stylesheet" />
<!-- Google	Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
	rel='stylesheet' type='text/css' />
	<style>
	#loginForm{
	display: none;
	opacity: .7;
 	position: fixed; 
	top: 0px;
	left: 0px;
	background: #4e5260;
	width: 100%;
	z-index: -1;
	}
	#loginFormInner{
	display: none;
 	position: fixed;  
	border-radius:7px; 
	width:100%;
	z-index: 1;
	opacity:1;
	}

</style>
<script>
 	function changePassword(){
			var winW = window.innerWidth;
	        var winH = window.innerHeight;
	        loginForm.style.display = "block";
	        loginForm.style.height = winH+"px";
	       // loginFormInner.style.left = (winW/2) - (550 * .4)+"px";
	        loginFormInner.style.top = "100px";
	        loginFormInner.style.display = "block";
		
		
	}
 	 function closeEmailPopUp(){
 		loginForm.style.display = "none";
 		 loginFormInner.style.display = "none";
 	 }
</script>
</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top " id="menu">
		<div class="container">
		  	<div id="loginForm"></div>
	
  	<div id="loginFormInner">
  	<div class="row">
	<div class="col-md-8 col-sm-8 col-xs-9 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
  	<div class="panel panel-info">
			  <div class="panel-heading loginfont">Change Password
			
			<span class="glyphicon glyphicon-remove pull-right" style="color:#ed6d6d;" onclick="closeEmailPopUp()"></span>
			  </div>
			  <div class="panel-body" style="padding-left:15%">
  	
		<form action="changePassword" modelattribute="email">
		<div class="form-group">
						<input type="text" class="form-control " required="required"
							name="email" placeholder="Email Id" /></br>
							<div class="form-group">
						<button type="submit" class="btn btn-info btn-block btn-lg">Submit
						</button>
						
					</div>
					</div>
		</form>
		</div>
		</div>
		</div>
		</div>
		</div>
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img class="logo-custom"
					src="resources/images/logo180-50.png" alt="" /></a>
			</div>
			<div class="navbar-collapse collapse move-me">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#home">HOME</a></li>
					<li><a href="#faculty-sec">FACULTY</a></li>
					<li><a href="#course-sec">COURSES</a></li>
					<li><a href="#contact-sec">CONTACT</a></li>
				</ul>
				
			</div>

		</div>
	</div>
	<!--NAVBAR SECTION END-->
	<div class="home-sec" id="home">
		<div class="overlay">
			<div class="container">
				<div class="row text-center ">

					<div class="col-lg-12  col-md-12 col-sm-12">

						<div class="flexslider set-flexi" id="main-section">
							<ul class="slides move-me">
								<!-- Slider 01 -->
								<li>
									<h3>Delivering Quality Education</h3>
									<h1>THE UNIQUE METHOD</h1> <a href="#login-sec"
									class="btn btn-info btn-lg"> Login </a>

								</li>
								<!-- End Slider 01 -->

								<!-- Slider 02 -->
								<li>
									<h3>Delivering Quality Education</h3>
									<h1>UNMATCHED APPROACH</h1> <a href="#login-sec"
									class="btn btn-primary btn-lg"> Login </a>

								</li>
								<!-- End Slider 02 -->

								<!-- Slider 03 -->
								<li>
									<h3>Delivering Quality Education</h3>
									<h1>AWESOME FACULTY PANEL</h1> <a href="#login-sec"
									class="btn btn-default btn-lg"> Login </a>

								</li>
								<!-- End Slider 03 -->
							</ul>
						</div>




					</div>

				</div>
			</div>
		</div>

	</div>
	<!--HOME SECTION END-->
	<div class="tag-line">
		<div class="container">
			<div class="row  text-center">

				<div class="col-lg-12  col-md-12 col-sm-12">

					<h2 data-scroll-reveal="enter from the bottom after 0.1s">
						<i class="fa fa-circle-o-notch"></i> WELCOME TO THE EDU-CENTER <i
							class="fa fa-circle-o-notch"></i>
					</h2>
				</div>
			</div>
		</div>

	</div>
	<!--HOME SECTION TAG LINE END-->
	<div id="login-sec" class="container set-pad">
		<div class="row text-center">
			<div
				class="col-lg-8 col-lg-offset-2 col-md-8 col-sm-8 col-md-offset-2 col-sm-offset-2">
				<h1 data-scroll-reveal="enter from the bottom after 0.2s"
					class="header-line">Login</h1>

			</div>

		</div>
		<!--/.HEADER LINE END-->


		<div class="row">
			<div
				class="col-lg-8 col-lg-offset-2 col-md-8 col-sm-8 col-md-offset-2 col-sm-offset-2" data-scroll-reveal="enter from the bottom after 0.4s">

				<form action="login" modelattribute="login">
					<div class="form-group">
						<input type="text" class="form-control " required="required"
							name="email" placeholder="Email Id" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control " required="required"
							name="password" placeholder="Password" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-info btn-block btn-lg">Login
						</button>
						
					</div>
					<div id="message">
					${message }${msg }</div>
					<a  onclick="changePassword();" style="color:red">Change Password ?</a>
				</form>


</div>

			</div>
		</div>
		<!-- FEATURES SECTION END-->
		<div id="faculty-sec">
			<div class="container set-pad">
				<div class="row text-center">
					<div
						class="col-lg-8 col-lg-offset-2 col-md-8 col-sm-8 col-md-offset-2 col-sm-offset-2">
						<h1 data-scroll-reveal="enter from the bottom after 0.1s"
							class="header-line">OUR FACULTY</h1>
						<p data-scroll-reveal="enter from the bottom after 0.3s">Lorem
							ipsum dolor sit amet, consectetuer adipiscing elit. Aenean
							commodo. Lorem ipsum dolor sit amet, consectetuer adipiscing
							elit. Aenean commodo.</p>
					</div>

				</div>
				<!--/.HEADER LINE END-->

				<div class="row">


					<div class="col-lg-4  col-md-4 col-sm-4"
						data-scroll-reveal="enter from the bottom after 0.4s">
						<div class="faculty-div">
							<img src="resources/images/faculty/1.jpg" class="img-rounded" />
							<h3>ROXI CHI LUENA</h3>
							<hr />
							<h4>
								Desigining <br /> Department
							</h4>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
								Aenean commodo .</p>
						</div>
					</div>
					<div class="col-lg-4  col-md-4 col-sm-4"
						data-scroll-reveal="enter from the bottom after 0.5s">
						<div class="faculty-div">
							<img src="resources/images/faculty/2.jpg" class="img-rounded" />
							<h3>JANE DEO ALEX</h3>
							<hr />
							<h4>
								Enginering <br /> Department
							</h4>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
								Aenean commodo .</p>
						</div>
					</div>
					<div class="col-lg-4  col-md-4 col-sm-4"
						data-scroll-reveal="enter from the bottom after 0.6s">
						<div class="faculty-div">
							<img src="resources/images/faculty/3.jpg" class="img-rounded" />
							<h3>RUBY DECORSA</h3>
							<hr />
							<h4>
								Management <br /> Department
							</h4>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
								Aenean commodo .</p>
						</div>
					</div>

				</div>
			</div>
		</div>
		<!-- FACULTY SECTION END-->
		<div id="course-sec" class="container set-pad">
			<div class="row text-center">
				<div
					class="col-lg-8 col-lg-offset-2 col-md-8 col-sm-8 col-md-offset-2 col-sm-offset-2">
					<h1 data-scroll-reveal="enter from the bottom after 0.1s"
						class="header-line">OUR COURSES</h1>
					<p data-scroll-reveal="enter from the bottom after 0.3s">Lorem
						ipsum dolor sit amet, consectetuer adipiscing elit. Aenean
						commodo. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
						Aenean commodo.</p>
				</div>

			</div>
			<!--/.HEADER LINE END-->


			<div class="row set-row-pad">
				<div class="col-lg-6 col-md-6 col-sm-6 "
					data-scroll-reveal="enter from the bottom after 0.4s">
					<img src="resources/images/building.jpg" class="img-thumbnail" />
				</div>
				<div
					class="col-lg-4 col-md-4 col-sm-4 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
					<div class="panel-group" id="accordion">
						<div class="panel panel-default"
							data-scroll-reveal="enter from the bottom after 0.5s">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse1" class="collapsed"> <strong>
											350+</strong> DESIGNING COURSES
									</a>
								</h4>
							</div>
							<div id="collapse1" class="panel-collapse collapse"
								style="height: 0px;">
								<div class="panel-body">
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Vivamus sagittis egestas mauris ut vehicula. Cras viverra ac
										orci ac aliquam. Nulla eget condimentum mauris, eget tincidunt
										est.</p>
								</div>
							</div>
						</div>
						<div class="panel panel-default"
							data-scroll-reveal="enter from the bottom after 0.7s">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse2" class="collapsed"> <strong>
											250+</strong> ENGINEERING COURSES
									</a>
								</h4>
							</div>
							<div id="collapse2" class="panel-collapse collapse"
								style="height: 0px;">
								<div class="panel-body">
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Vivamus sagittis egestas mauris ut vehicula. Cras viverra ac
										orci ac aliquam. Nulla eget condimentum mauris, eget tincidunt
										est.</p>
								</div>
							</div>
						</div>
						<div class="panel panel-default"
							data-scroll-reveal="enter from the bottom after 0.9s">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse3" class="collapsed"> <strong>
											153+</strong> MANAGEMENT COURSES
									</a>
								</h4>
							</div>
							<div id="collapse3" class="panel-collapse collapse"
								style="height: 0px;">
								<div class="panel-body">
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Vivamus sagittis egestas mauris ut vehicula. Cras viverra ac
										orci ac aliquam. Nulla eget condimentum mauris, eget tincidunt
										est.</p>
								</div>
							</div>
						</div>
					</div>
					<div class="alert alert-info"
						data-scroll-reveal="enter from the bottom after 1.1s">
						<span style="font-size: 40px;"> <strong> 2500 + </strong>
							<hr /> Centers
						</span>
					</div>
				</div>



			</div>
		</div>
		<!-- COURSES SECTION END-->
		<div id="contact-sec">
			<div class="overlay">
				<div class="container set-pad">
					<div class="row text-center">
						<div
							class="col-lg-8 col-lg-offset-2 col-md-8 col-sm-8 col-md-offset-2 col-sm-offset-2">
							<h1 data-scroll-reveal="enter from the bottom after 0.1s"
								class="header-line">CONTACT US</h1>
							<p data-scroll-reveal="enter from the bottom after 0.3s">
								Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean
								commodo. Lorem ipsum dolor sit amet, consectetuer adipiscing
								elit. Aenean commodo.</p>
						</div>

					</div>
					<!--/.HEADER LINE END-->
					<div class="row set-row-pad"
						data-scroll-reveal="enter from the bottom after 0.5s">


						<div
							class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
							<form>
								<div class="form-group">
									<input type="text" class="form-control " required="required"
										placeholder="Your Name" />
								</div>
								<div class="form-group">
									<input type="text" class="form-control " required="required"
										placeholder="Your Email" />
								</div>
								<div class="form-group">
									<textarea name="message" required="required"
										class="form-control" style="min-height: 150px;"
										placeholder="Message"></textarea>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-info btn-block btn-lg">SUBMIT
										REQUEST</button>
								</div>

							</form>
						</div>






					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row set-row-pad">
				<div
					class="col-lg-4 col-md-4 col-sm-4   col-lg-offset-1 col-md-offset-1 col-sm-offset-1 "
					data-scroll-reveal="enter from the bottom after 0.4s">

					<h2>
						<strong>Our Location </strong>
					</h2>
					<hr />
					<div">
						<h4>234/80 -UFG , New Street,</h4>
						<h4>Switzerland.</h4>
						<h4>
							<strong>Call:</strong> + 67-098-907-1269 / 70 / 71
						</h4>
						<h4>
							<strong>Email: </strong>info@yourdomain.com
						</h4>
					</div>


				</div>
				<div
					class="col-lg-4 col-md-4 col-sm-4   col-lg-offset-1 col-md-offset-1 col-sm-offset-1"
					data-scroll-reveal="enter from the bottom after 0.4s">

					<h2>
						<strong>Social Conectivity </strong>
					</h2>
					<hr />
					<div>
						<a href="#"> <img src="resources/images/Social/facebook.png"
							alt="" />
						</a> <a href="#"> <img
							src="resources/images/Social/google-plus.png" alt="" /></a> <a
							href="#"> <img src="resources/images/Social/twitter.png"
							alt="" /></a>
					</div>
				</div>


			</div>
		</div>
		<!-- CONTACT SECTION END-->
		<div id="footer">
			&copy 2017 yourdomain.com | All Rights Reserved | <a
				href="http://reformist.in" style="color: #fff" target="_blank">Design
				by : binarytheme.com</a>
		</div>
		<!-- FOOTER SECTION END-->

		<!--  Jquery Core Script -->
		<script src="resources/js/jquery-1.10.2.js"></script>
		<!--  Core Bootstrap Script -->
		<script src="resources/js/bootstrap.js"></script>
		<!--  Flexslider Scripts -->
		<script src="resources/js/jquery.flexslider.js"></script>
		<!--  Scrolling Reveal Script -->
		<script src="resources/js/scrollReveal.js"></script>
		<!--  Scroll Scripts -->
		<script src="resources/js/jquery.easing.min.js"></script>
		<!--  Custom Scripts -->
		<script src="resources/js/custom.js"></script>
</body>
</html>
