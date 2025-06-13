package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.impl.BookingsServiceImpl;
import service.impl.UsersServiceImpl;
import utility.DateUtil;

import java.io.IOException;
import java.time.LocalDate;

import beans.BookingsBean;
import beans.UsersBean;


/**
 * Servlet implementation class BookRoomServ
 */
@WebServlet("/BookRoomServ")
public class BookRoomServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRoomServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Lấy dữ liệu từ form
		String emailId = request.getParameter("email");
		String phone = request.getParameter("phone");
	    
	    String fullNameUser = "Unknown";
	    String addressUser = "Unknown";
	    String genderUser = "Unknown";


	    String roomIdInt = request.getParameter("roomSelect");
	    String checkInDate = request.getParameter("checkinDate");
	    String checkOutDate = request.getParameter("checkoutDate");
	    String image = request.getParameter("image");
	    String roomTypeName = request.getParameter("roomTypeName"); // thêm loại phòng
	    String occupancy = request.getParameter("occupancy"); // thêm số người
	    String pricePerNightStr = request.getParameter("pricePerNight"); // thêm giá phòng

	    try {
	        // Chuyển đổi ngày tháng thành định dạng SQL
	        LocalDate formattedCheckinDate = DateUtil.convertToDate(checkInDate);
	        LocalDate formattedCheckoutDate = DateUtil.convertToDate(checkOutDate);
	        int roomId = Integer.parseInt(roomIdInt);
	        double pricePerNight = 0.0;
	        if (pricePerNightStr != null && !pricePerNightStr.trim().isEmpty()) {
	            pricePerNight = Double.parseDouble(pricePerNightStr.replace(" $", ""));
	        }
	        
	        String mobileNo = phone;
	        String passwordUser = phone;

	        // In ra các giá trị kiểm tra
	        System.out.println("Email: " + emailId);
	        System.out.println("Password: " + passwordUser);
	        System.out.println("Mobile: " + mobileNo);
	        System.out.println("Full Name: " + fullNameUser);
	        System.out.println("Address: " + addressUser);
	        System.out.println("Gender: " + genderUser);
	        System.out.println("Room ID: " + roomId);
	        System.out.println("Check-in Date: " + formattedCheckinDate);
	        System.out.println("Check-out Date: " + formattedCheckoutDate);
	        System.out.println("Image: " + image);
	        System.out.println("Occupany: " + occupancy);

	        UsersServiceImpl userService = new UsersServiceImpl();
	        BookingsServiceImpl bookingService = new BookingsServiceImpl();

	        // Kiểm tra xem email đã đăng ký chưa
	        boolean isRegistered = userService.isRegistered(emailId);

	        if (!isRegistered) {
	            // Tạo đối tượng UsersBean
	            UsersBean user = new UsersBean(emailId, passwordUser, fullNameUser, mobileNo, addressUser, genderUser, null, 1);
	            
	            // Đăng ký người dùng
	            String registrationStatus = userService.registerUser(user);

	            if (!"User Registered Successfully!".equals(registrationStatus)) {
	                response.sendRedirect("register.jsp?error=" + registrationStatus);
	                return;
	            }
	        }
	        
	        long daysBetween = DateUtil.dateDiff(formattedCheckinDate, formattedCheckoutDate);
	        double totalPrice = pricePerNight * daysBetween;

	        // Tạo đối tượng BookingsBean mà không thiết lập bookingId
	        BookingsBean booking = new BookingsBean(emailId, roomId, formattedCheckinDate, formattedCheckoutDate, totalPrice, false, 1);
	        
	        // Thêm thông tin đặt phòng
	        bookingService.addBooking(booking);

	        

	        // Đặt thuộc tính vào request
	        request.setAttribute("checkinDate", checkInDate);
	        request.setAttribute("checkoutDate", checkOutDate);
	        request.setAttribute("email", emailId);
	        request.setAttribute("image", image);
	        request.setAttribute("roomTypeName", roomTypeName);
	        request.setAttribute("occupancy", occupancy);
	        request.setAttribute("pricePerNight", pricePerNight);
	        request.setAttribute("totalPrice", totalPrice);

	        // Chuyển tiếp request đến bookingreceipt.jsp
	        request.getRequestDispatcher("bookingreceipt.jsp").forward(request, response);

	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendRedirect("error.jsp");
	    }
	}

}
