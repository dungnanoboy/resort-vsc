<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="header.jsp"%>

<!-- bradcam_area_start -->
<div class="bradcam_area breadcam_bg">
    <h3>Elements</h3>
</div>
<!-- bradcam_area_end -->

<!-- Start Align Area -->
<section class="blog_area section-padding">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mb-5 mb-lg-0">
                <div class="blog_left_sidebar">
                    <% 
                        List<RoomsBean> availableRooms = (List<RoomsBean>) request.getAttribute("availableRooms");
                        for (RoomsBean room : availableRooms) {
                    %>
                    <article class="blog_item">
                        <div class="blog_item_img">
                            <img class="card-img rounded-0" src="<%= room.getRoomType().getRoomImage() %>" alt="">
                        </div>

                        <div class="blog_details">
                            <a class="d-inline-block" href="#">
                                <h2><%= room.getRoomName() %></h2>
                            </a>
                            <p><%= room.getRoomType().getAbst() %></p>
                            <ul class="blog-info-link">
                                <li><a href="#"><i class="fa fa-user"></i><%= room.getRoomType().getOccupancy() %> persons</a></li>
                                <li><a href="#"><i class="fa fa-comments"></i><%= room.getRoomType().getPricePerNight() %>  $ / night</a></li>
                            </ul>
                            <div class="button-group-area mt-40">
                                <a href="#" class="genric-btn primary circle choose-room" 
                                    data-roomid="<%= room.getRoomId() %>"
                                    data-roomname="<%= room.getRoomName() %>"
                                    data-pricepernight="<%= room.getRoomType().getPricePerNight() %>"
                                    data-image="<%= room.getRoomType().getRoomImage() %>"
                                    data-occupancy="<%= room.getRoomType().getOccupancy() %>">Choose</a>
                            </div>
                        </div>
                    </article>
                    <% } %>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="blog_right_sidebar">
                    <aside class="single_sidebar_widget post_category_widget"
                        style="border: 1px solid #e2e2e2; padding: 20px; border-radius: 5px;">
                        <form action="BookRoomServ" method="post">
                            <h4 class="widget_title"
                                style="border-bottom: 1px solid #e2e2e2; padding-bottom: 10px;">Booking information</h4>
                            <div style="padding: 10px 0;">
                                <p style="font-weight: bold;">${availableRooms[0].roomType.typeName}</p>
                                <p>${checkinDate} - ${checkoutDate}</p>
                            </div>
                            <input type="hidden" name="checkinDate" value="${checkinDate}">
                            <input type="hidden" name="checkoutDate" value="${checkoutDate}">
                            <input type="hidden" id="room-select" name="roomSelect" value="">
                            <input type="hidden" name="roomTypeName" id="room-type-name" value="">
                            <input type="hidden" name="pricePerNight" id="price-per-night" value="">
                            <input type="hidden" name="image" id="image" value="">
                            <input type="hidden" name="occupancy" id="occupancy" value="">
                            <div
                                style="border-top: 1px solid #e2e2e2; border-bottom: 1px solid #e2e2e2; padding: 10px 0;">
                                <a href="#"
                                    style="display: flex; justify-content: space-between; align-items: center; text-decoration: none;">
                                    <span>Room information</span>
                                </a>
                            </div>
                            <div id="selected-room-details" style="padding: 10px 0;">
                                <p>
                                    <strong>Room:</strong> <span id="room-id" name="roomselect">(RoomID)</span> <span id="room-name">(RoomName)</span>
                                </p>
                            </div>
                            <div
                                style="display: flex; justify-content: space-between; align-items: center; padding: 10px 0;">
                                <p>
                                    <strong id="price-per-night-text">$ / night</strong>
                                </p>
                            </div>
                            <div style="border-top: 1px solid #e2e2e2; padding: 10px 0;">
                                <p style="display: flex; justify-content: space-between;">
                                    <span>Total</span> <strong id="total-price">0 VND</strong>
                                </p>
                            </div>
                            <div style="padding: 10px 0;">
                                <p style="font-weight: bold;">Booker information</p>
                            </div>
                            <div class="mt-10">
                                <input type="text" name="email" placeholder="Email" required class="single-input">
                            </div>
                            <div class="mt-10">
                                <input type="text" name="phone" placeholder="Mobile" required class="single-input">
                            </div>
                            <div style="text-align: center;">
                                <button
                                    style="background-color: #FFA500; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer;">Book Now</button>
                            </div>
                        </form>
                    </aside>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End Align Area -->

<%@ include file="footer.jsp"%>

<script>
    document.querySelectorAll('.choose-room').forEach(button => {
        button.addEventListener('click', function(event) {
            event.preventDefault();
            const roomID = this.getAttribute('data-roomid');
            const roomName = this.getAttribute('data-roomname');
            const pricePerNight = this.getAttribute('data-pricepernight');
            const image = this.getAttribute('data-image');
            const occupancy = this.getAttribute('data-occupancy');

            document.getElementById('room-id').innerText = roomID;
            document.getElementById('room-name').innerText = roomName;
            document.getElementById('room-select').value = roomID;
            document.getElementById('room-type-name').value = roomName;
            document.getElementById('price-per-night').value = pricePerNight;
            document.getElementById('price-per-night-text').innerText = pricePerNight + " $ / night";
            document.getElementById('image').value = image;
            document.getElementById('occupancy').value = occupancy;

            // Tính tổng giá tiền
            const checkinDate = document.getElementsByName('checkinDate')[0].value;
            const checkoutDate = document.getElementsByName('checkoutDate')[0].value;
            const daysBetween = Math.ceil((new Date(checkoutDate) - new Date(checkinDate)) / (1000 * 60 * 60 * 24));
            const totalPrice = daysBetween * pricePerNight;
            document.getElementById('total-price').innerText = totalPrice + " VND";
        });
    });
</script>
