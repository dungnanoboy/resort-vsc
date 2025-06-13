package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.impl.BookingsServiceImpl;

import java.io.IOException;
import java.util.List;

import beans.BookingsBean;

/**
 * Servlet implementation class TrackBookingsSrv
 */
@WebServlet("/TrackBookingsSrv")
public class TrackBookingsSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackBookingsSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");

        BookingsServiceImpl bookingService = new BookingsServiceImpl();
        List<BookingsBean> bookings = bookingService.getAllBookingWithEmail(email);

        request.setAttribute("bookings", bookings);

        request.getRequestDispatcher("trackbookings.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
