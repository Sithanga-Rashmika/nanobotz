<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="main.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.1.0/mdb.min.css"
	rel="stylesheet" />
</head>
<body>

	<!-- Section: Design Block -->
	<section class="background-radial-gradient overflow-hidden"
		style="height: 100vh; width: 100%;">
		<style>
.background-radial-gradient {
	background-color: hsl(218, 41%, 15%);
	background-image: radial-gradient(650px circle at 0% 0%, hsl(218, 41%, 35%)
		15%, hsl(218, 41%, 30%) 35%, hsl(218, 41%, 20%) 75%,
		hsl(218, 41%, 19%) 80%, transparent 100%),
		radial-gradient(1250px circle at 100% 100%, hsl(218, 41%, 45%) 15%,
		hsl(218, 41%, 30%) 35%, hsl(218, 41%, 20%) 75%, hsl(218, 41%, 19%) 80%,
		transparent 100%);
}

#radius-shape-1 {
	height: 220px;
	width: 220px;
	top: -60px;
	left: -130px;
	background: radial-gradient(#44006b, #ad1fff);
	overflow: hidden;
}

#radius-shape-2 {
	border-radius: 38% 62% 63% 37%/70% 33% 67% 30%;
	bottom: -60px;
	right: -110px;
	width: 300px;
	height: 300px;
	background: radial-gradient(#44006b, #ad1fff);
	overflow: hidden;
}

.bg-glass {
	background-color: hsla(0, 0%, 100%, 0.9) !important;
	backdrop-filter: saturate(200%) blur(25px);
}
</style>

		<div
			class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
			<div class="row gx-lg-5 align-items-center mb-5">
				<div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
					<h1 class="my-5 display-5 fw-bold ls-tight"
						style="color: hsl(218, 81%, 95%)">
						The best offer <br /> <span style="color: hsl(218, 81%, 75%)">for
							your business</span>
					</h1>
					<p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
						Lorem ipsum dolor, sit amet consectetur adipisicing elit.
						Temporibus, expedita iusto veniam atque, magni tempora mollitia
						dolorum consequatur nulla, neque debitis eos reprehenderit quasi
						ab ipsum nisi dolorem modi. Quos?</p>
				</div>

				<div class="col-lg-6 mb-5 mb-lg-0 position-relative">
					<div id="radius-shape-1"
						class="position-absolute rounded-circle shadow-5-strong"></div>
					<div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

					<div class="card bg-glass">
						<div class="card-body px-4 py-5 px-md-5">
							<form action='login' method='post' style=" margin-bottom: 100px;" onsubmit="return validateForm()" >
						    <!-- Email input -->
						    <h4 style="margin-bottom: 20px;">
						        <center>Login Here</center>
						    </h4>
						    <a href ='home.jsp'>
						        <img src="${pageContext.request.contextPath}/assets/black.png" height="45" alt="Logo" loading="lazy" class='logo_img'/>
						    </a>
						    <p style="text-align: center; margin-bottom: 20px;">
						        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's
						        standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to
						        make a type specimen book.
						    </p>
						    <div class="form-outline mb-4">
						        <label class="form-label" for="form3Example3">User Name</label>
						        <input type="email" id="username" class="form-control" name="username" />
						    </div>
						
						    <!-- Password input -->
						    <div class="form-outline mb-4">
						        <label class="form-label" for="form3Example4">Password</label>
						        <input type="password" id="password" class="form-control" name="password" />
						    </div>
						
						    <!-- Submit button -->
						    <button type="submit" class="btn btn-primary btn-block mb-4">Login</button>
						    <p>Do you not have an account? <a href="register.jsp">Register</a></p>
						</form>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Section: Design Block -->


<script>
function validateForm() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    if (username.trim() === "" || password.trim() === "") {
        alert("Please fill in username and password");
        return false;
    }


    return true;
}
</script>



</body>
</html>