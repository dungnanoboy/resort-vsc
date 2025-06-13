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
 * Servlet implementation class AddBookingsServ
 */
@WebServlet("/AddBookingsServ")
public class AddBookingsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookingsServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
        int roomId = Integer.parseInt(request.getParameter("roomid"));
        String checkInDateStr = request.getParameter("checkindate");
        String checkOutDateStr = request.getParameter("checkoutdate");
        double totalPrice = Double.parseDouble(request.getParameter("totalprice"));
        boolean isPaid = Boolean.parseBoolean(request.getParameter("ispaid"));
        int stateId = Integer.parseInt(request.getParameter("stateid"));

        LocalDate checkInDate = LocalDate.parse(checkInDateStr);
        LocalDate checkOutDate = LocalDate.parse(checkOutDateStr);
        
        
        BookingsBean booking = new BookingsBean(email, roomId, checkInDate, checkOutDate, totalPrice, isPaid, stateId);
        BookingsServiceImpl bookingService = new BookingsServiceImpl();

        bookingService.addBooking(booking);

        response.sendRedirect("bookingsTB.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
