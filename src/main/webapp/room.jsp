<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp" %>

<%

RoomTypesServiceImpl broomDAO = new RoomTypesServiceImpl();
List<RoomTypesBean> basicRoom = broomDAO.getAllBasicRoom();

RoomTypesServiceImpl lroomDAO = new RoomTypesServiceImpl();
List<RoomTypesBean> luxuryRoom = lroomDAO.getAllLuxuryRoom();

RoomTypesServiceImpl sroomDAO = new RoomTypesServiceImpl();
List<RoomTypesBean> specialRoom = sroomDAO.getAllSpecialRoom();

%>

<!-- bradcam_area_start -->
    <div class="bradcam_area breadcam_bg_1">
        <h3>Laxaries Rooms</h3>
    </div>
    <!-- bradcam_area_end -->

    <!-- offers_area_start -->
    <div class="offers_area padding_top">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="section_title text-center mb-100">
                        <span>Basic Rooms</span>
                        <h3>Ongoing Offers</h3>
                    </div>
                </div>
            </div>
            <div class="row">
    			<% 
        			for (RoomTypesBean br : basicRoom) { 
        				List<RoomConditionsBean> rcList = br.getRoomconditions();
    			%>
    			<div class="col-xl-4 col-md-4">
        			<div class="single_offers">
            			<div class="about_thumb">
                			<img src="<%=br.getRoomImage()%>" alt="">
            			</div>
            				<a href="RoomInfoSrv?typeId=<%=br.getTypeId()%>"><h3><%=br.getTypeName()%></h3></a>
            				<ul>
                				
                				<li><%=br.getAvailableRooms()%> rooms are available</li>
                				
                				<li><%=br.getOccupancy()%> persons</li>
                				<li><%=br.getAbst()%></li>
            				</ul>
            			<a href="#" class="book_now">book now</a>
        			</div>
    			</div>
    			<% } %>
			</div>
        </div>
    </div>
    <!-- offers_area_end -->

    <!-- features_room_startt -->
    <div class="features_room">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="section_title text-center mb-100">
                        <span>Luxury Rooms</span>
                        <h3>Choose a Better Room</h3>
                    </div>
                </div>
            </div>
        </div>
        <div class="rooms_here">
            <% 
        		for (RoomTypesBean lr : luxuryRoom) { 
        			List<RoomConditionsBean> rcList = lr.getRoomconditions();
    		%>
            <div class="single_rooms">
                <div class="room_thumb">
                    <img src="<%=lr.getRoomImage()%>" alt="">
                    <div class="room_heading d-flex justify-content-between align-items-center">
                        <div class="room_heading_inner">
                            <span>From $<%=lr.getPricePerNight()%>/night</span>
                            <h3><%=lr.getTypeName()%></h3>
                            <span><%=lr.getAvailableRooms()%> rooms are available</span>
                        </div>
                        <a href="RoomInfoSrv?typeId=<%=lr.getTypeId()%>" class="line-button">More info</a>
                        <a class="popup-with-form line-button" href="#test-form" 
                    data-occupancy="<%=lr.getOccupancy()%>" data-type-name="<%=lr.getTypeName()%>">book now</a>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </div>
    <!-- features_room_end -->
    
    <!-- features_room_startt -->
    <div class="features_room">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="section_title text-center mb-100">
                        <span>Special Rooms</span>
                        <h3>Choose a more special room</h3>
                    </div>
                </div>
            </div>
        </div>
        <div class="rooms_here">
            <% 
        		for (RoomTypesBean sr : specialRoom) { 
        			List<RoomConditionsBean> rcList = sr.getRoomconditions();
    		%>
            <div class="single_rooms">
                <div class="room_thumb">
                    <img src="<%=sr.getRoomImage()%>" alt="">
                    <div class="room_heading d-flex justify-content-between align-items-center">
                        <div class="room_heading_inner">
                            <span>From $<%=sr.getPricePerNight()%>/night</span>
                            <h3><%=sr.getTypeName()%></h3>
                            <span><%=sr.getAvailableRooms()%> rooms are available</span>
                        </div>
                        <a href="RoomInfoSrv?typeId=<%=sr.getTypeId()%>" class="line-button">More info</a>
                        <a class="popup-with-form line-button" href="#test-form" 
                    data-occupancy="<%=sr.getOccupancy()%>" data-type-name="<%=sr.getTypeName()%>">book now</a>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </div>
    <!-- features_room_end -->

    <!-- forQuery_start -->
    <div class="forQuery">
        <div class="container">
            <div class="row">
                <div class="col-xl-10 offset-xl-1 col-md-12">
                    <div class="Query_border">
                        <div class="row align-items-center justify-content-center">
                            <div class="col-xl-6 col-md-6">
                                <div class="Query_text">
                                        <p>For Reservation 0r Query?</p>
                                </div>
                            </div>
                            <div class="col-xl-6 col-md-6">
                                <div class="phone_num">
                                        <a href="#" class="mobile_no">+10 576 377 4789</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- forQuery_end-->
    
    <!-- instragram_area_start -->
    <div class="instragram_area">
        <div class="single_instagram">
            <img src="img/instragram/1.png" alt="">
            <div class="ovrelay">
                <a href="#">
                    <i class="fa fa-instagram"></i>
                </a>
            </div>
        </div>
        <div class="single_instagram">
            <img src="img/instragram/2.png" alt="">
            <div class="ovrelay">
                <a href="#">
                    <i class="fa fa-instagram"></i>
                </a>
            </div>
        </div>
        <div class="single_instagram">
            <img src="img/instragram/3.png" alt="">
            <div class="ovrelay">
                <a href="#">
                    <i class="fa fa-instagram"></i>
                </a>
            </div>
        </div>
        <div class="single_instagram">
            <img src="img/instragram/4.png" alt="">
            <div class="ovrelay">
                <a href="#">
                    <i class="fa fa-instagram"></i>
                </a>
            </div>
        </div>
        <div class="single_instagram">
            <img src="img/instragram/5.png" alt="">
            <div class="ovrelay">
                <a href="#">
                    <i class="fa fa-instagram"></i>
                </a>
            </div>
        </div>
    </div>
    <!-- instragram_area_end -->

<%@ include file="footer.jsp" %>
