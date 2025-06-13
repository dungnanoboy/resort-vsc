<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.BookingsBean" %>
<%@ page import="service.impl.BookingsServiceImpl" %>
<%@ include file="adminheader.jsp" %>

<%
    String bookingId = request.getParameter("id");
    BookingsServiceImpl bookDao = new BookingsServiceImpl();
    BookingsBean booking = bookDao.getBookingById(Integer.parseInt(bookingId));
%>

<main id="main" class="main">
    <div class="pagetitle">
        <h2>Edit Booking</h2>
    </div>
    <div class="container shadow p-5">
        <form method="post" action="UpdateBookingsServ">
            <input type="hidden" name="bookingId" value="<%= booking.getBookingId() %>">
            <div class="form-row">
                <div class="form-group col-md-6 mb-3">
                    <label>Email</label>
                    <input type="text" class="form-control" placeholder="Email..." name="email" value="<%= booking.getEmail() %>">
                </div>
                
                <div class="form-group col-md-6 mb-3">
                    <label>Room ID</label>
                    <input type="text" class="form-control" name="roomId" value="<%= booking.getRoomId() %>">
                </div>
                
                <div class="form-group col-md-6 mb-3">
                    <label for="inputDate">Check-in date</label>
                    <input type="date" class="form-control" name="checkInDate" value="<%= booking.getCheckInDate() %>">
                </div>
                
                <div class="form-group col-md-6 mb-3">
                    <label for="inputDate">Check-out date</label>
                    <input type="date" class="form-control" name="checkOutDate" value="<%= booking.getCheckOutDate() %>">
                </div>
                
                <div class="form-group col-md-6 mb-3">
                    <label>Total price</label>
                    <input type="text" class="form-control" name="totalPrice" value="<%= booking.getTotalPrice() %>">
                </div>

                <div class="form-group col-md-6 mb-3">
                    <label>Is paid</label>
                    <select class="form-select" name="isPaid">
                        <option value="true" <%= booking.isPaid() ? "selected" : "" %>>True</option>
                        <option value="false" <%= !booking.isPaid() ? "selected" : "" %>>False</option>
                    </select>
                </div>
                
                <div class="form-group col-md-6 mb-3">
                    <label>State ID</label>
                    <select class="form-select" name="stateId">
                        <option value="1" <%= booking.getStateId() == 1 ? "selected" : "" %>>1</option>
                        <option value="2" <%= booking.getStateId() == 2 ? "selected" : "" %>>2</option>
                        <option value="3" <%= booking.getStateId() == 3 ? "selected" : "" %>>3</option>
                        <option value="4" <%= booking.getStateId() == 4 ? "selected" : "" %>>4</option>
                    </select>
                </div>
            </div>

            <a class="btn btn-lg btn-warning p-2" href="bookingsTB.jsp">
                <i class="bi bi-arrow-left-circle"></i> Go back
            </a>

            <button type="submit" class="btn btn-lg btn-primary p-2">
                <i class="bi bi-file-plus-fill"></i> Save information
            </button>
        </form>
    </div>
</main>

<%@ include file="adminfooter.jsp" %>
