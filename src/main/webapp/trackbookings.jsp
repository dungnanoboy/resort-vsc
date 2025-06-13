<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.Month" %>
<%@ page import="java.util.Set, java.util.HashSet" %>

<%
    String email = request.getParameter("email");
    List<BookingsBean> bookings = (List<BookingsBean>) request.getAttribute("bookings");
%>

<!-- bradcam_area_start -->
    <div class="bradcam_area breadcam_bg">
        <h3>blog</h3>
    </div>
    <!-- bradcam_area_end -->


    <!--================Blog Area =================-->
    <section class="blog_area section-padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 mb-5 mb-lg-0">
                    <div class="blog_left_sidebar">
                        <%
        					if (email != null && !email.isEmpty() && (bookings == null || bookings.isEmpty())) {
    					%>
    					<p>No bookings found for the email: <%= email %></p>
    					<% } else if (bookings != null && !bookings.isEmpty()) { 
    					 for (BookingsBean booking : bookings) { %>
                        <article class="blog_item">
                            <div class="blog_item_img">
                                <img class="card-img rounded-0" src=".\img\blog\single_blog_1.png" alt="">
                                
                            </div>

                            <div class="blog_details">
                                <a class="d-inline-block" href="RoomInfoSrv?typeId=<%=booking.getRoomId()%>">
                                    <h2>Your booking ID: <%= booking.getBookingId() %></h2>
                                </a>
                                <p>Check in date : <%=booking.getCheckInDate()%> - Check out date: <%=booking.getCheckOutDate()%></p>
                                
                                <p>Total price: <%=booking.getTotalPrice()%></p>
                                <p>Payment status: <%=booking.isPaid()%></p>
                                <p>Reservation status: <%=booking.getStateId()%></p>
                                <ul class="blog-info-link">
                                    <li><a href="#"><i class="fa fa-user"></i> zzz</a></li>
                                    <li><a href="#"><i class="fa fa-thumbs-up"></i> zzz</a></li>
                                </ul>
                                <div class="card-body">
                                <button type="button" href="#" class="btn btn-danger rounded-pill">Cancel booking</button>
                                <button type="button" href="#" class="btn btn-success rounded-pill">Go to Checkout</button>
                                
                                </div>
                            </div>
                        </article>
                        <% } } %>
                        
                        
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget search_widget">
                            <form action="TrackBookingsSrv" method="get">
                                <div class="form-group">
                                    <div class="input-group mb-3">
                                        <input type="text" class="form-control" name="email" placeholder='Search Keyword'
                                            onfocus="this.placeholder = ''"
                                            onblur="this.placeholder = 'Search Keyword'">
                                        <div class="input-group-append">
                                            <button class="btn" type="submit"><i class="ti-search"></i></button>
                                        </div>
                                    </div>
                                </div>
                                <button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                                    type="submit">Search</button>
                            </form>
                        </aside>

                        

                        <aside class="single_sidebar_widget instagram_feeds">
                            <h4 class="widget_title">Instagram Feeds</h4>
                            <ul class="instagram_row flex-wrap">
                                <li>
                                    <a href="#">
                                        <img class="img-fluid" src="img/post/post_5.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <img class="img-fluid" src="img/post/post_6.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <img class="img-fluid" src="img/post/post_7.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <img class="img-fluid" src="img/post/post_8.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <img class="img-fluid" src="img/post/post_9.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <img class="img-fluid" src="img/post/post_10.png" alt="">
                                    </a>
                                </li>
                            </ul>
                        </aside>


                        
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->

<%@ include file="footer.jsp" %>