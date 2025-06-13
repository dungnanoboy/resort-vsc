<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="beans.*"%>
<%@ page import="service.*"%>
<%@ page import="service.impl.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Multi Step Form | CodingNepal</title>
      <link rel="stylesheet" href="check-form.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
   </head>
   <body>
      <div class="container">
         <header>Booking Form</header>
         <div class="progress-bar">
            <div class="step">
               <p>
                  Room
               </p>
               <div class="bullet">
                  <span>1</span>
               </div>
               <div class="check fas fa-check"></div>
            </div>
            <div class="step">
               <p>
                  Account
               </p>
               <div class="bullet">
                  <span>2</span>
               </div>
               <div class="check fas fa-check"></div>
            </div>
            <div class="step">
               <p>
                  Info
               </p>
               <div class="bullet">
                  <span>3</span>
               </div>
               <div class="check fas fa-check"></div>
            </div>
            <div class="step">
               <p>
                  Submit
               </p>
               <div class="bullet">
                  <span>4</span>
               </div>
               <div class="check fas fa-check"></div>
            </div>
         </div>
         <div class="form-outer">
            <form action="BookRoomServ" method="post" >
               <div class="page slide-page">
                  <div class="title">
                     Room available:
                  </div>
                  <div class="field">
                     <div class="label">
                        Room type
                     </div>
                     <input id="roomtype" type="text" name="roomTypeName" value="${availableRooms[0].roomType.typeName}" readonly>
                  </div>
                  <div class="field">
                     <div class="label">
                        Price per night
                     </div>
                     <input id="pricePerNight" type="text" name="pricePerNight" value="${availableRooms[0].roomType.pricePerNight} " readonly>
                  </div>
                  <div class="field">
    				<div class="label">
        				Check in date
    				</div>
    					<input id="checkinDate" type="text" name="checkinDate" value="${checkinDate}" readonly>
					</div>
				<div class="field">
    				<div class="label">
        				Check out date
    				</div>
    				<input id="checkoutDate" type="text" name="checkoutDate" value="${checkoutDate}" readonly>
				</div>
                  <div class="field">
                     <div class="label">
                        Select Room
                     </div>
                     <select id="roomSelect" name="roomSelect" class="form-select wide">
                        <option value="">Select a room</option>
        				<% 
            				List<RoomsBean> availableRooms = (List<RoomsBean>) request.getAttribute("availableRooms");
            				for (RoomsBean room : availableRooms) {
        				%>
        				<option value="<%= room.getRoomId() %>"><%= room.getRoomName() %></option>
        				<% } %>
                     </select>
                  </div>
                  
                  <div class="field">
                     <button class="firstNext next">Next</button>
                  </div>
               </div>
               <div class="page">
                  <div class="title">
                     Register account:
                  </div>
                  <div class="field">
                     <div class="label">
                        Email Address
                     </div>
                     <input type="text" name="email">
                  </div>
                  <div class="field">
                     <div class="label">
                        Password
                     </div>
                     <input type="text" name="password">
                  </div>
                  <div class="field">
                     <div class="label">
                        Phone Number
                     </div>
                     <input type="Number" name="phone">
                  </div>
                  <div class="field btns">
                     <button class="prev-1 prev">Previous</button>
                     <button class="next-1 next">Next</button>
                  </div>
               </div>
               <div class="page">
                  <div class="title">
                     Contact Info:
                  </div>
                  <div class="field">
                     <div class="label">
                        Full name
                     </div>
                     <input type="text" name="fullName">
                  </div>
                  <div class="field">
                     <div class="label">
                        Address
                     </div>
                     <input type="text" name="address">
                  </div>
                  <div class="field">
                     <div class="label">
                        Gender
                     </div>
                     <select name="gender">
                        <option>Male</option>
                        <option>Female</option>
                        <option>Other</option>
                     </select>
                  </div>
                  <div class="field btns">
                     <button class="prev-2 prev">Previous</button>
                     <button class="next-2 next">Next</button>
                  </div>
               </div>
               <div class="page">
                  <div class="title">
                     Room type details:
                  </div>
                  <div class="field">
                     <div class="label">
                        Abstract
                     </div>
                     <input id="abst" type="text" value="${availableRooms[0].roomType.abst}" readonly>
                  </div>
                  <div class="field">
                     <div class="label">
                        Occupancy
                     </div>
                     <input id="occupancy" name="occupancy" type="text" value="${availableRooms[0].roomType.occupancy}" readonly>
                     <input id="image" name="image" type="hidden" value="${availableRooms[0].roomType.roomImage}" readonly>
                  </div>
                  
                  <div class="field btns">
                     <button class="prev-3 prev">Previous</button>
                     <button class="submit" type="submit">Submit</button>
                  </div>
               </div>
            </form>
         </div>
      </div>
      <script src="js/check-form.js"></script>
   </body>
</html>