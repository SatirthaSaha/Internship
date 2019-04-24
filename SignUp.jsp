<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles/custom.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<!-- <script src="js/validator.js"></script> -->
<title>Home</title>

<link
	href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"
	integrity="sha256-0YPKAwZP7Mp3ALMRVB2i8GXeEndvCq3eSl/WsAl1Ryk="
	crossorigin="anonymous"></script>
<!-- <script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script> -->
<style type="text/css">
.errors {
	color: red;
}

.has-error {
	color: red;
	border: 1px solid red;
}

.no-error {
	color: green;
	border: 1px solid green;
}

.row-style {
	background-color: #e9ecef;
	color: black;
	padding: 50px 10px 40px 10px;
	border-radius: 5px;
}
</style>
<!-- <script type="text/javascript">
	$(document).ready(function() {
		window.x = false;
	})
</script> -->

<script>
	/* /* $(document).ready(function() { // <-- enclose your code in a DOM ready handler

		console.log("inside validator");

		jQuery.validator.addMethod("avail", function() {
			//var bool=false;
			$.ajax({
				url : "checkEmail",
				data : {
					email : $("#AsID4").val()
				},
				async : false,
				success : function(data) {
					var m = data;
					if (m == "Email id is Available") {
						/*alert("In avail");
						window.bool = true;
					}
					if (m == "Email id is taken") {
						
						window.bool = false;
					}
				}
				error:function(){
					alert("error");
				}

			});
		
			return window.bool;;
		})
		
		jQuery.validator.addMethod("avail", function() {
			//var bool=false;
			$.ajax({
				url : "checkAdminid",
				data : {
					email : $("#AsID6").val()
				},
				async : false,
				success : function(data) {
					var m = data;
					if (m == "Admin id is Available") {
				
						window.bool = true;
					}
					if (m == "Admin id is taken") {
					
						window.bool = false;
					}
				}

			});
		
			return window.bool;;
		})

		$("#signup-form").validate({
			rules : {
				"emailid" : {
					required : true,
					avail : true,
					email : true
				},
				"firstname" : {
					required : true,
				},
				"adminid" : {
					required : true,
					avail : true,
					email : true
				}

			},
			messages : {

				"emailid" : {
					required : "mandatory",
					avail : "Present",
					email : "Invalid"
				},
				"firstname" : {
					required : "mandatory",
				},
				"adminid" : {
					required : "mandatory",
					avail : "Present",
					email : "Invalid"
				}

			},

			highlight : function(element) {
				$(element).parent().find('input').removeClass('no-error');
				$(element).parent().find('input').addClass('has-error');
			},
			unhighlight : function(element) {
				$(element).parent().find('input').removeClass('has-error');
				$(element).parent().find('input').addClass('no-error');
			},
			errorClass : "errors"

		});

	}); */ 
	
	
	/* $("#AsID4").keyup(function(){
		alert($("#AsID4").val());

		$.ajax({
					url : "checkAdminid",
					data : {
						email : $("#AsID4").val()
					},
					success : function(data) {
						var m = data;
						if (m == "Admin id is Available") {
							
							
						}
						if (m == "Admin id is taken") {
							alert("Email id already associated with another account");
							$("#AsID4").val("");
						}
					},
					error : function(){
						alert("Error");
					}

				});
	}); */
	
	 function avail(){
		

		$.ajax({
					url : "checkEmail",
					data : {
						email : $("#AsID4").val()
					},
					success : function(data) {
						var m = data;
						if (m == "Email is Available") {
							/*alert("In avail");*/
							//alert("In avail");
						}
						if (m == "Email id is taken") {
							alert("Email id already associated with another account");
							$("#AsID4").val("");
						}
					},
					error : function(){
						alert("Error");
					}

				});
	}
	
	function avail1(){
		

		$.ajax({
					url : "checkAdminid",
					data : {
						admin : $("#AsID6").val()
					},
					success : function(data) {
						var m = data;
						if (m == "Admin Id is Available") {
							/*alert("In avail");*/
							//alert("In avail");
						}
						if (m == "Admin Id is taken") {
							alert("Admin id already associated with another account");
							$("#AsID6").val("");
						}
					},
					error : function(){
						alert("Error");
					}

				});
	}
	
</script>
</head>
<body>
	<nav class="navbar navbar-expand-md fixed-top navbar-dark  bg-dark">
	<a class="navbar-brand" href="LogOption.jsp">Academy Portal</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	</nav>


	<div class="container">
		<div class="jumbotron color-b">
			<h1>Welcome to Academy- Kolkata</h1>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="card" style="width: 18rem;">
					<img
						src="data:image/png;base64,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"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Academy</h5>
						<p class="card-text">Kolkata</p>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">Address: Unitech Infospace, DH
							Block(Newtown), Action Area I, Newtown, Kolkata-700156</li>
						<li class="list-group-item">email: xyz@academy.com</li>
						<li class="list-group-item">Phone:1234567890</li>
					</ul>

				</div>
			</div>
			<div class=" col-md-8 ">
				<!--Content area-->
				<div class="row">
					<div
						class="col-xs-12 col-sm-10 col-md-10 col-sm-offset-2 col-md-offset-3">
						<div class="card">
							<div class="card-body" style="background-color: #f5f5f5;">
								<form:form role="form" action="addadmin" commandName="addadmin"
									method="POST" onsubmit="showAlert()" id="signup-form">
									<h2>Sign Up</h2>
									<hr />


									<div class="form-group">

										<form:input type="text" path="firstname" id="AsID"
											class="form-control input-lg" placeholder="First Name"
											tabindex="1" pattern="[A-Za-z].{1,}" required="required" />
										<br />
										<form:input type="text" path="lastname" id="AsID1"
											class="form-control input-lg" placeholder="Last Name"
											tabindex="1" required="required" />
										<br />
										<%-- <form:input type="text" path="age" id="AsID" class="form-control input-lg" placeholder="Age" tabindex="1" pattern="(?=.*\d).{2}" required="required"/><br/> --%>
										<form:input type="number" path="age" id="AsID2"
											class="form-control input-lg" placeholder="Age" tabindex="1"
											pattern="(?=.*\d).{2}" required="required" value="Age" />
										<br /> <font size="4">Gender</font>&nbsp;&nbsp;
										<form:input type="radio" path="gender" value="male" />
										Male &nbsp;&nbsp;
										<form:input type="radio" path="gender" value="female" />
										Female &nbsp;&nbsp;
										<form:input type="radio" path="gender" value="other" />
										Others</br>
										</br>
										<form:input type="number" path="contact" id="AsID3"
											class="form-control input-lg" placeholder="Contact Number"
											tabindex="1" pattern="(?=.*\d).{10}" required="required"
											value="contact" />
										<br />
										<form:input type="email" path="emailid" id="AsID4"
											class="form-control input-lg" placeholder="email id"
											tabindex="1" onkeyup="avail()" required="required" />
										<br />
										<form:input type="password" path="password" id="AsID5"
											class="form-control input-lg" placeholder="Password"
											tabindex="1" required="required" />
										<br />
										<form:input type="text" path="adminid" id="AsID6"
											class="form-control input-lg" placeholder="Associate ID"
											tabindex="1" onblur="avail1()" required="required" />
										<br /> <input type="submit" value="Register"
											class="btn btn-primary btn-block btn-lg color-b" tabindex="7">
									</div>
									<hr />
									<script type="text/javascript">
										function showAlert() {
											alert("Admin added Successfully");
										}
									</script>
								</form:form>
							</div>
						</div>

					</div>
					<!--Content area-->
				</div>
			</div>


		</div>

	</div>
	<!-- Footer -->
	<footer class="page-footer font-small blue"> <!-- Copyright -->
	<div class="footer-copyright text-center py-3">© 2019
		Copyright:@Academy</div>
	<!-- Copyright --> </footer>
	<!-- Footer -->

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script> -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>
