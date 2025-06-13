<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!doctype html>
<%
Cookie[] cookies = request.getCookies();
boolean isLoggedIn = false;
String userEmail = null;
Integer userRole = null;

if (cookies != null) {
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("cuser")) {
            isLoggedIn = true; // Đã đăng nhập
            userEmail = cookie.getValue(); // Lấy giá trị email của người dùng từ cookie
        } else if (cookie.getName().equals("crole")) {
            userRole = Integer.parseInt(cookie.getValue()); // Lấy giá trị role của người dùng từ cookie
        }
    }
}

// Kiểm tra nếu người dùng đã đăng nhập nhưng không phải là quản trị viên (role != 1)
// và đang cố gắng truy cập trang adminindex.jsp, chuyển hướng về trang chính
if (isLoggedIn && userRole != null && userRole != 1 && request.getRequestURI().endsWith("adminindex.jsp")) {
    response.sendRedirect("index.jsp"); // Chuyển hướng về trang chính hoặc trang khác tùy bạn
}
%>

<html class="no-js" lang="zxx">
<%@ page import="beans.*"%>
<%@ page import="service.*"%>
<%@ page import="service.impl.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Dunhuth</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/themify-icons.css">
<link rel="stylesheet" href="css/nice-select.css">
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/gijgo.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/slicknav.css">
<link rel="stylesheet" href="css/style.css">
<link href="assets/css/style.css" rel="stylesheet">


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Magnific Popup CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css">

<!-- Magnific Popup JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>


<!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>

<body>


	<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

	<!-- header-start -->
	<header>
		<div class="header-area ">
			<div id="sticky-header" class="main-header-area">
				<div class="container-fluid p-0">
					<div class="row align-items-center no-gutters">
						<div class="col-xl-5 col-lg-6">
							<div class="main-menu d-none d-lg-block">
								<nav>
									<ul id="navigation">
										<li><a class="active" href="index.jsp">home</a></li>
                                        <li><a href="room.jsp">rooms</a></li>
                                        <li><a href="#">Pages<i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                        		<li><a href="blog.jsp">Blog</a></li>
                                                <li><a href="about.jsp">About</a></li>
                                                <li><a href="contact.jsp">Contact</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="trackbookings.jsp">My Booking</a></li>
                                        <li>
    										<% if (isLoggedIn) { %>
        										<a href="GetProfileServ?email=<%= userEmail %>">My Account</a>
    										<% } else { %>
        										<a href="login.jsp">Login</a>
    										<% } %>
										</li>
									</ul>
								</nav>
							</div>
						</div>

						<div class="col-xl-2 col-lg-2">
							<div class="logo-img">
								<a href="index.html"> <img src="img/logo.png" alt="">
								</a>
							</div>
						</div>
						<div class="col-xl-5 col-lg-4 d-none d-lg-block">
							<div class="book_room">
								<div class="socail_links">
									<ul>
										<li><a href="#"> <i class="fa fa-facebook-square"></i>
										</a></li>
										<li><a href="#"> <i class="fa fa-twitter"></i>
										</a></li>
										<li><a href="#"> <i class="fa fa-instagram"></i>
										</a></li>
									</ul>
								</div>
								<div class="book_btn d-none d-lg-block">
									<a class="popup-with-form" href="#test-form">Book A Room</a>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="mobile_menu d-block d-lg-none"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- header-end -->