<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
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
<script>
	$(document).ready(function() {
		// Check if the page has been loaded before
		var isFirstVisit = sessionStorage.getItem('isFirstVisit');

		if (!isFirstVisit) {
			// Set the flag in session storage
			sessionStorage.setItem('isFirstVisit', 'true');

			// Perform the AJAX call only on the first visit or refresh
			performAjaxCall();
		} else {
			// Reset the flag to false on page refresh
			sessionStorage.removeItem('isFirstVisit');
		}

		// Function to perform AJAX call
		function performAjaxCall() {
			var UID = $('#hiddenUID').val();

			$.ajax({
				type : 'POST',
				url : 'profile',
				data : {
					uid : UID
				},
				success : function(response) {
					console.log(response);
					$('#mainContainer').html(response);

				},
				error : function(error) {
					console.error('Error:', error);
				}
			});
		}

	});
</script>
</head>
<body>
	<!-- Hidden input field to store the session attribute value -->
	<input type="hidden" id="hiddenUID" value="${sessionScope.UID}" />

	<!-- Main container for both navbar and profile details -->
	<div id="mainContainer">
		<!-- Navbar -->
		<nav class="navbar navbar-expand-lg navbar-light bg-body-tertiary"
			style="background-color: #3498db;">
			<!-- Container wrapper -->
			<div class="container-fluid">
				<!-- Toggle button -->
				<button data-mdb-collapse-init class="navbar-toggler" type="button"
					data-mdb-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fas fa-bars"></i>
				</button>

				<!-- Collapsible wrapper -->
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<!-- Navbar brand -->
					<a class="navbar-brand mt-2 mt-lg-0" href="home.jsp"> <img
						src="${pageContext.request.contextPath}/assets/black.png"
						height="45" alt="Logo" loading="lazy" />
					</a>

					<!-- Left links -->
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" href="products">Products</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="addNewProduct.jsp">Add new Product</a></li>
						<li class="nav-item"><a class="nav-link" href="profile.jsp">My
								Profile</a></li>
					</ul>
				</div>
				<!-- Collapsible wrapper -->

				<!-- Right elements -->
				<div class="d-flex align-items-center">
					<!-- Icon -->
					<a class="text-reset me-3" href="login.jsp"> Login </a> <a
						class="text-reset me-3" href="register.jsp"> Register </a>
				</div>
				<!-- Right elements -->
			</div>
			<!-- Container wrapper -->
		</nav>
		<!-- Navbar -->

		<!-- Profile details container -->
		<div id="profileDetailsContainer">


		<div class="profile-card" style="width: 40%; margin: 50px auto; padding: 20px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); background-color: #fff; border-radius: 8px; text-align: justify;">
		    <h2>User Profile</h2>
		    <div class="profile-details">
		        <c:forEach var="profile" items="${profileDetails}">
		            <p>
		                <strong>Profile Id:</strong> ${profile.id}
		            </p>
		            <p>
		                <strong>Name:</strong> ${profile.salutation}.
		                ${profile.firstname} ${profile.lastname}
		            </p>
		            <p>
		                <strong>Telephone Number:</strong> ${profile.tell}
		            </p>
		            <p>
		                <strong>Address:</strong> ${profile.address}
		            </p>
		            <p>
		                <strong>Email:</strong> ${profile.email}
		            </p>
		            <p>
		                <strong>Username:</strong> ${profile.username}
		            </p>
		            <p>
		                <strong>Points:</strong> ${profile.points}
		            </p>
		        </c:forEach>
		    </div>
		</div>

		</div>


		<!-- Footer -->

		<footer class="text-center text-lg-start bg-dark text-white">
			<!-- Section: Social media -->
			<section
				class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
				<!-- Left -->
				<div class="me-5 d-none d-lg-block">
					<span>Get connected with us on social networks:</span>
				</div>
				<!-- Left -->

				<!-- Right -->
				<div>
					<a href="" class="me-4 text-reset"> <i
						class="fab fa-facebook-f"></i>
					</a> <a href="" class="me-4 text-reset"> <i class="fab fa-twitter"></i>
					</a> <a href="" class="me-4 text-reset"> <i class="fab fa-google"></i>
					</a> <a href="" class="me-4 text-reset"> <i
						class="fab fa-instagram"></i>
					</a> <a href="" class="me-4 text-reset"> <i class="fab fa-linkedin"></i>
					</a> <a href="" class="me-4 text-reset"> <i class="fab fa-github"></i>
					</a>
				</div>
				<!-- Right -->
			</section>
			<!-- Section: Social media -->

			<!-- Section: Links  -->
			<section class="">
				<div class="container text-center text-md-start mt-5">
					<!-- Grid row -->
					<div class="row mt-3">
						<!-- Grid column -->
						<div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
							<!-- Content -->
							<h6 class="text-uppercase fw-bold mb-4">
								<i class="fas fa-gem me-3"></i>Company name
							</h6>
							<p>Here you can use rows and columns to organize your footer
								content. Lorem ipsum dolor sit amet, consectetur adipisicing
								elit.</p>
						</div>
						<!-- Grid column -->

						<!-- Grid column -->
						<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
							<!-- Links -->
							<h6 class="text-uppercase fw-bold mb-4">Products</h6>
							<p>
								<a href="#!" class="text-reset">Angular</a>
							</p>
							<p>
								<a href="#!" class="text-reset">React</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Vue</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Laravel</a>
							</p>
						</div>
						<!-- Grid column -->

						<!-- Grid column -->
						<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
							<!-- Links -->
							<h6 class="text-uppercase fw-bold mb-4">Useful links</h6>
							<p>
								<a href="#!" class="text-reset">Pricing</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Settings</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Orders</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Help</a>
							</p>
						</div>
						<!-- Grid column -->

						<!-- Grid column -->
						<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
							<!-- Links -->
							<h6 class="text-uppercase fw-bold mb-4">Contact</h6>
							<p>
								<i class="fas fa-home me-3"></i> New York, NY 10012, US
							</p>
							<p>
								<i class="fas fa-envelope me-3"></i> info@example.com
							</p>
							<p>
								<i class="fas fa-phone me-3"></i> + 01 234 567 88
							</p>
							<p>
								<i class="fas fa-print me-3"></i> + 01 234 567 89
							</p>
						</div>
						<!-- Grid column -->
					</div>
					<!-- Grid row -->
				</div>
			</section>
			<!-- Section: Links  -->

			<!-- Copyright -->
			<div class="text-center p-4"
				style="background-color: rgba(0, 0, 0, 0.05);">
				� 2021 Copyright: <a class="text-reset fw-bold"
					href="https://mdbootstrap.com/">MDBootstrap.com</a>
			</div>
			<!-- Copyright -->
		</footer>
		<!-- Footer -->



















	</div>

	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.1.0/mdb.umd.min.js"></script>





</body>
</html>
