package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.impl.RoomTypesServiceImpl;

import java.io.IOException;

import beans.RoomTypesBean;

/**
 * Servlet implementation class RoomInfoSrv
 */
@WebServlet("/RoomInfoSrv")
public class RoomInfoSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomInfoSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String roomtypeIdStr = request.getParameter("typeId");
		int roomtypeId = 0;
	    if (roomtypeIdStr != null && !roomtypeIdStr.isEmpty()) {
	        try {
	        	roomtypeId = Integer.parseInt(roomtypeIdStr);
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    RoomTypesServiceImpl rDao = new RoomTypesServiceImpl();
	    RoomTypesBean roomtype = rDao.getRoomTypeDetails(roomtypeId);
	    
	    request.setAttribute("roomtype", roomtype);
	    request.getRequestDispatcher("single-room.jsp").forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
