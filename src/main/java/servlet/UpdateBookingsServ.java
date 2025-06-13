package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.impl.BookingsServiceImpl;

import java.io.IOException;
import java.time.LocalDate;

import beans.BookingsBean;

/**
 * Servlet implementation class UpdateBookingsServ
 */
@WebServlet("/UpdateBookingsServ")
public class UpdateBookingsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookingsServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            int bookingId = Integer.parseInt(id);

            // Get booking by ID
            BookingsServiceImpl bookingService = new BookingsServiceImpl();
            BookingsBean booking = bookingService.getBookingById(bookingId);

            // Check if booking exists
            if (booking != null) {
                // Set booking as a request attribute and forward to update form
                request.setAttribute("booking", booking);
                request.getRequestDispatcher("-bookingsTB.jsp").forward(request, response);
            } else {
                response.sendRedirect("-bookingsTB.jsp?error=Booking not found");
            }
        } else {
            response.sendRedirect("-bookingsTB.jsp?error=Invalid booking ID");
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        String email = request.getParameter("email");
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        LocalDate checkInDate = LocalDate.parse(request.getParameter("checkInDate"));
        LocalDate checkOutDate = LocalDate.parse(request.getParameter("checkOutDate"));
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        boolean isPaid = Boolean.parseBoolean(request.getParameter("isPaid"));
        int stateId = Integer.parseInt(request.getParameter("stateId"));

        // Log data for debugging
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Email: " + email);
        System.out.println("Room ID: " + roomId);
        System.out.println("Check in date: " + checkInDate);
        System.out.println("Check out date: " + checkOutDate);
        System.out.println("Total price: " + totalPrice);
        System.out.println("Is paid: " + isPaid);
        System.out.println("State ID: " + stateId);

        // Update booking
        BookingsServiceImpl bookingService = new BookingsServiceImpl();
        BookingsBean booking = new BookingsBean(bookingId, email, roomId, checkInDate, checkOutDate, totalPrice, isPaid, stateId);
        bookingService.updateBooking(booking);

        // Redirect to bookings table page
        response.sendRedirect("bookingsTB.jsp");
    }

}
