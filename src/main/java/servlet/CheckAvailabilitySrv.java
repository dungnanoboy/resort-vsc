package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.impl.RoomsServiceImpl;
import utility.DateUtil;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import beans.RoomsBean;

/**
 * Servlet implementation class CheckAvailabilitySrv
 */
@WebServlet("/CheckAvailabilitySrv")
public class CheckAvailabilitySrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAvailabilitySrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("error.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkinDate = request.getParameter("checkinDate");
        String checkoutDate = request.getParameter("checkoutDate");
        String occupancyStr = request.getParameter("occupancy");
        String roomType = request.getParameter("roomType");
        
        request.setAttribute("checkinDate", checkinDate);
        request.setAttribute("checkoutDate", checkoutDate);
        

        try {
        	int occupancy = Integer.parseInt(occupancyStr);
            String formattedCheckinDate = DateUtil.convertToSQLDate(checkinDate);
            String formattedCheckoutDate = DateUtil.convertToSQLDate(checkoutDate);

            RoomsServiceImpl roomDao = new RoomsServiceImpl();
            List<RoomsBean> availableRooms = roomDao.findAvailableRooms(formattedCheckinDate, formattedCheckoutDate, occupancy, roomType);

            request.setAttribute("availableRooms", availableRooms);
            request.getRequestDispatcher("check-available.jsp").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); 
        }
    }
}
