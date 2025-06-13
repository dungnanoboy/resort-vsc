<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp" %>

<%
    String roomTypeName = (String) request.getAttribute("roomTypeName");
    String checkinDate = (String) request.getAttribute("checkinDate");
    String checkoutDate = (String) request.getAttribute("checkoutDate");
    String email = (String) request.getAttribute("email");
    String image = (String) request.getAttribute("image");
    String occupancy = (String) request.getAttribute("occupancy");
    Double pricePerNight = (Double) request.getAttribute("pricePerNight");
    Double totalPrice = (Double) request.getAttribute("totalPrice");
%>

<!-- bradcam_area_start -->
<div class="bradcam_area breadcam_bg">
    <h3>Booking receipt</h3>
</div>
<!-- bradcam_area_end -->

<!--================ Blog Area =================-->
<section class="blog_area single-post-area section-padding">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 posts-list">
                <div class="single-post">
                    <div class="feature-img" style="display: flex; justify-content: center; align-items: center;">
                        <img class="img-fluid" src="<%= image %>" alt="">
                    </div>
                    <div class="blog_details">
                        <h2 style="display: flex; justify-content: center; align-items: center; text-align: center;"><%= roomTypeName %></h2>
                        <ul class="blog-info-link mt-3 mb-4"
                            style="display: flex; justify-content: center; align-items: center; text-align: center; list-style: none; padding: 0;">
                            <li><a href="#"><i class="fa fa-user"></i> <%= occupancy %> persons</a></li>
                            <li><a href="#"><i class="fa fa-comments"></i> <%= pricePerNight %> $ per night</a></li>
                        </ul>
                        <div class="quote-wrapper">
                            <div class="quotes">
                                Description about the room goes here.
                            </div>
                        </div>
                        <p class="excert">Check-in Date: <%= checkinDate %></p>
                        <p class="excert">Check-out Date: <%= checkoutDate %></p>
                        <p class="excert">Email: <%= email %></p>
                        <p class="excert">Total Price: <%= totalPrice %> $</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================ Blog Area end =================-->

<%@ include file="footer.jsp" %>
