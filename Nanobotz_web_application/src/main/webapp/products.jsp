<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products list</title>
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
					<li class="nav-item"><a class="nav-link" href="#">Products</a>
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
	<div class= 'hero_section2'>
			<h3>Product List</h3>
		</div>

					<h2 style="margin-top: 40px "><center>Lorem ipsum dolor</center></h2>
					<p  style="text-Align: center; width: 600px ; margin-left: auto; margin-right: auto; margin-top: 40px ">
						Lorem ipsum dolor, sit amet consectetur adipisicing elit.
						Temporibus, expedita iusto veniam atque, magni tempora mollitia
						dolorum consequatur nulla, neque debitis eos reprehenderit quasi
						ab ipsum nisi dolorem modi. Quos?
					</p>
		

	<div class="container" id='product-container'>
		<div class="row">
			<c:forEach items="${productList}" var="item" varStatus="loop">
				<div class="col-md-3 mb-4">
					<!-- Reduce the mb value here -->
					<div class="card">
						<img src="https://images.unsplash.com/photo-1621371205896-3082fa811d54?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fGhhbmRjcmFmdHxlbnwwfDB8MHx8fDA%3D" class="card-img-top"
							alt="Product Image">
						<div class="card-body">
							<h5 class="card-title">${item.name}</h5>
							<p class="card-text">${item.brand}</p>
							<p class="card-text">Rs. ${item.price}0</p>
							<button class="btn btn-primary"
								onclick="redirectToBuyNow('${item.id}', '${item.name}', '${item.price}')">Buy
								Now</button>
						</div>
					</div>
				</div>

			</c:forEach>
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
				<a href="" class="me-4 text-reset"> <i class="fab fa-facebook-f"></i>
				</a> <a href="" class="me-4 text-reset"> <i class="fab fa-twitter"></i>
				</a> <a href="" class="me-4 text-reset"> <i class="fab fa-google"></i>
				</a> <a href="" class="me-4 text-reset"> <i class="fab fa-instagram"></i>
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






	<script>
		function redirectToBuyNow(itemId, itemName, itemPrice) {
			// Construct the URL with parameters
			var url = 'buynow.jsp?id=' + encodeURIComponent(itemId) + '&name='
					+ encodeURIComponent(itemName) + '&price='
					+ encodeURIComponent(itemPrice);

			// Redirect to the Buy Now page
			window.location.href = url;
		}
	</script>


</body>
</html>