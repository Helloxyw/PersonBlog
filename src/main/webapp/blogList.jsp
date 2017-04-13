<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="assets/ico/favicon.png">

<title>博客列表</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/assets/css/main.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css">

<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/Chart.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/modernizr.custom.js"></script>



<link
	href='http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700'
	rel='stylesheet' type='text/css'>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
      <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body data-spy="scroll" data-offset="0" data-target="#theMenu">

	<!-- Menu -->
	<nav class="menu" id="theMenu">
		<div class="menu-wrap">
			<h1 class="logo">
				<a href="${pageContext.request.contextPath}/AdminLogin.jsp">RicardoXu</a>
			</h1>
			<i class="icon-remove menu-close"></i> <a href="${pageContext.request.contextPath}/index.jsp"
				class="smoothScroll">Home</a> <a href="#services"
				class="smoothScroll">Services</a> <a href="#portfolio"
				class="smoothScroll">Portfolio</a> <a href="#about"
				class="smoothScroll">About</a> <a href="#contact"
				class="smoothScroll">Contact</a> <a href="#"><i
				class="icon-facebook"></i></a> <a href="#"><i class="icon-twitter"></i></a>
			<a href="#"><i class="icon-dribbble"></i></a> <a href="#"><i
				class="icon-envelope"></i></a>
		</div>

		<!-- Menu button -->
		<div id="menuToggle">
			<i class="icon-reorder"></i>
		</div>
	</nav>



	<!-- ========== HEADER SECTION ========== -->
	<section id="home" name="home"></section>
	<div id="itemwrap">
		<div class="container">
			<br>
			<h1>Ricardo Xu</h1>
			<h2>菜鸟后端</h2>
			<div class="row">
				<br> <br> <br>
				<div class="col-lg-6 col-lg-offset-3"></div>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /headerwrap -->


	<!-- ========== WHITE SECTION ========== -->
	<div id="w">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<h3>
						WELCOME TO
						<bold>MY BLOG</bold>
						.
						<bold>BASED ON BOOTSTRAP 3</bold>
						THEME. CRAFTED WITH LOVE BY
						<bold>BLACKTIE.CO</bold>
						. <br />
						<bold>IDEAL FOR</bold>
						AGENCIES & FREELANCERS.
					</h3>
				</div>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /w -->

	<!-- ========== SERVICES - GREY SECTION ========== -->
	<div id="g">
		<div class="container">
			<c:forEach items="${blogList}" var="blog">
				<div class="row">
					<h3>${blog.title}</h3>
					<br> <br>
					<div class="col-lg-8 desc">
						<h4>${blog.summary }</h4>
						<p>${blog.content}</p>
					</div>
					<div class="col-lg-4 desc desc-b">
						<h4>Blog Data</h4>
						<p>
							<i class="icon-user"></i> Ricardo Xu<br /> <i class="icon-tag"></i>
							${blog.keyWord }<br /> <i class="icon-time"></i>
							<fmt:formatDate value="${blog.releaseDate }" type="date"
								pattern="yyyy-MM-dd" />
							<br /> <i class="icon-globe"></i> ${blog.blogType.typeName }<br />
						</p>
					</div>

				</div>
				<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=2)"
					width="80%" color=#987cb9 SIZE=10>
			</c:forEach>
		</div>
		<!-- /container -->
	</div>
	<!-- /g -->

	<!-- ========== CAROUSEL / DESCRIPTION - DARK GREY SECTION ========== -->
	<div id="dg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div id="carousel-example-generic" class="carousel slide">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="assets/img/item-01.png" alt="">
							</div>
							<div class="item">
								<img src="assets/img/item-02.png" alt="">
							</div>
						</div>
					</div>
				</div>
			</div>
			<br> <br> <br>
		</div>
		<!-- /container -->

		<div class="container">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-4 desc desc-a">
					<h4>
						<i class="icon-bullseye"></i> THE GOAL
					</h4>
					<p>Etiam dictum gravida nibh at accum san. Quisque aliquam
						risus bibendum diam elementum, et tempus enim suscipit. Duis sit
						amet euismod.</p>
					<br> <br>
					<h4>
						<i class="icon-desktop"></i> THE RESULT
					</h4>
					<p>Etiam dictum gravida nibh at accum san. Quisque aliquam
						risus bibendum diam elementum, et tempus enim suscipit. Duis sit
						amet euismod.</p>
				</div>

				<div class="col-lg-4 desc">
					<h4>
						<i class="icon-bolt"></i> THE IDEA
					</h4>
					<p>Etiam dictum gravida nibh at accum san. Quisque aliquam
						risus bibendum diam elementum, et tempus enim suscipit. Duis sit
						amet euismod.</p>
					<br> <br>
					<h4>
						<i class="icon-bar-chart"></i> THE STATICS
					</h4>
					<p>Etiam dictum gravida nibh at accum san. Quisque aliquam
						risus bibendum diam elementum, et tempus enim suscipit. Duis sit
						amet euismod.</p>
				</div>
				<div class="col-lg-2"></div>

			</div>
			<div class="row">
				<br> <br>
				<div class="col-lg-4 col-lg-offset-4">
					<a href="index.jsp#portfolio" style="font-size:20px;">< <i
						class="icon-th-large"></i> >
					</a>
				</div>
			</div>
		</div>
	</div>
	<!-- /dg -->



	<!-- ========== ABOUT - GREY SECTION ========== -->
	<section id="about" name="about"></section>
	<div id="g">
		<div class="container">
			<div class="row">
				<!-- <h3>ABOUT US</h3> -->
				<br> <br>

				<div class="col-lg-8">
					<h3>ABOUT US</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Fusce lectus elit, tincidunt nec turpis sed, accumsan iaculis
						ipsum. Nulla at augue auctor, tristique erat in, ultricies nunc.
						Mauris eget metus leo. Ut in mi lacinia, mattis nisl non, ultrices
						risus. Vestibulum aliquet aliquam ipsum ut ullamcorper.
						Pellentesque fringilla, massa vel rutrum consequat, nulla velit
						fermentum dolor, sed scelerisque.</p>
					<br> <br>
				</div>
				<div class="col-lg-2"></div>
				<div class="col-lg-2 ">

					<img class="img-circle" src="assets/img/1.jpg" height="90"
						width="90">

					<h4>Ricardo Xu</h4>
					<h5>
						<i>菜鸟后端</i>
					</h5>
					<p>Just Do it!</p>
					<p>
						<a href="index.jsp#"><i class="icon-facebook"></i></a> <a
							href="index.jsp#"><i class="icon-twitter"></i></a> <a
							href="index.jsp#"><i class="icon-envelope"></i></a>

					</p>
				</div>






			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /g -->


	<div id="c">
		<div class="container">
			<center>
				<p>Copyright &copy; 2017.Company name All rights reserved.</p>
			</center>

		</div>
	</div>



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${pageContext.request.contextPath}/assets/js/classie.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/retina.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
	<script>
		$('.carousel').carousel({
			interval : 3500
		})
	</script>
</body>
</html>
