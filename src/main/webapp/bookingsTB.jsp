<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="adminheader.jsp" %>


<script>
	// Hàm xử lý khi người dùng nhấn vào biểu tượng "Xóa"
	function deleteBooking(bookingId) {
		// Hiển thị hộp thoại xác nhận
		var confirmDelete = confirm("Are you sure to delete booking with id "
				+ bookingId);
		console.log("Booking ID to delete:", bookingId);

		// Nếu người dùng nhấn OK, thực hiện xóa
		if (confirmDelete) {
			$.get("DeleteBookingsServ?IdBookingId=" + bookingId,
					function() {
				console.log("Delete request sent for Booking ID:", bookingId);
						location.reload();
					});
		}
	}
</script>

<%

	BookingsServiceImpl bookDao = new BookingsServiceImpl();
	List<BookingsBean> bookings = bookDao.getAllBookings();
		
%>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Booking list</h1>
      <nav>
        <a type="button" class="btn btn-success" href="+bookingsTB.jsp">
                <i class="bi bi-file-earmark-text me-1"></i>Add a menu
            </a>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Datatables</h5>
              <p>Add lightweight datatables to your project with using the <a href="https://github.com/fiduswriter/Simple-DataTables" target="_blank">Simple DataTables</a> library. Just add <code>.datatable</code> class name to any table you wish to conver to a datatable. Check for <a href="https://fiduswriter.github.io/simple-datatables/demos/" target="_blank">more examples</a>.</p>

              <!-- Table with stripped rows -->
              <table class="table datatable">
                <thead>
                  <tr>
                    <th>
                      <b>Booking ID</b>
                    </th>
                    <th>Email</th>
                    <th>Room ID</th>
                    <th data-type="date" data-format="YYYY/DD/MM">Check in date</th>
                    <th data-type="date" data-format="YYYY/DD/MM">Check out date</th>
                    <th>Total price</th>
                    <th>Is paid</th>
                    <th>State ID</th>
                    <th>Functions</th>
                  </tr>
                </thead>
                <tbody>
                <%
					for (BookingsBean book : bookings) {
				%>
                  <tr>
                    <td><%=book.getBookingId()%></td>
                    <td><%=book.getEmail()%></td>
                    <td><%=book.getRoomId()%></td>
                    <td><%=book.getCheckInDate()%></td>
                    <td><%=book.getCheckOutDate()%></td>
                    <td><%=book.getTotalPrice()%></td>
                    <td><%=book.isPaid()%></td>
                    <td><%=book.getStateId()%></td>
                    <td class="text-center" scope="row">
                       <a href="UpdateBookingsServ?id=<%=book.getBookingId()%>" class="btn btn-primary btn-sm" title="Edit "><i class="bi bi-pencil"></i></a>

                       <a href="#" onclick="deleteBooking(<%=book.getBookingId()%>)" class="btn btn-danger btn-sm" title="Delete"><i class="bi bi-trash"></i></a>
                    </td>
                  </tr>
                 <% } %>
                </tbody>
              </table>
              <!-- End Table with stripped rows -->

            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->

<%@ include file="adminfooter.jsp" %>