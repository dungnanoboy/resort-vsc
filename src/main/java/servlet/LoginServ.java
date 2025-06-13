package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.impl.UsersServiceImpl;

import java.io.IOException;

import beans.UsersBean;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lấy thông tin từ form đăng nhập
	    String userName = request.getParameter("useremail");
	    String password = request.getParameter("userpassword");
	    String rememberuser = request.getParameter("rememberMe");

	    // Khởi tạo cookie
	    Cookie cu = new Cookie("cuser", userName);
	    Cookie cp = new Cookie("cpass", password);
	    Cookie cr = new Cookie("crem", rememberuser);
	    
	    // Lấy thông tin người dùng từ CSDL
	    UsersServiceImpl userDAO = new UsersServiceImpl();
	    boolean isValidUser = userDAO.isValidCredential(userName, password);

	    if (isValidUser) {
	        UsersBean user = userDAO.getUsersDetails(userName, password);

	        // Lưu role vào cookie
	        Cookie roleCookie = new Cookie("crole", String.valueOf(user.getRole()));
	        if(rememberuser!=null) {
	            cu.setMaxAge(7*60*60*24);
	            cp.setMaxAge(7*60*60*24);
	            cr.setMaxAge(7*60*60*24);
	            roleCookie.setMaxAge(7*60*60*24); // Thời gian sống của cookie
	        } else {
	            cu.setMaxAge(0);
	            cp.setMaxAge(0);
	            cr.setMaxAge(0);
	            roleCookie.setMaxAge(0); // Xóa cookie nếu người dùng không chọn "Remember me"
	        }
	        response.addCookie(cu);
	        response.addCookie(cp);
	        response.addCookie(cr);
	        response.addCookie(roleCookie);

	        // Chuyển hướng đến trang tương ứng dựa trên role
	        if (user.getRole() == 0) {
	            response.sendRedirect("adminindex.jsp");
	        } else {
	            response.sendRedirect("index.jsp");
	        }
	    } else {
	        // Xử lý khi thông tin đăng nhập không hợp lệ
	        RequestDispatcher rd = request.getRequestDispatcher("login.jsp?message=Invalid credentials");
	        rd.forward(request, response);
	    }
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
