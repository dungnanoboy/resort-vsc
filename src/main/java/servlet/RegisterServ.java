package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.impl.UsersServiceImpl;

import java.io.IOException;

import beans.UsersBean;

/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServ() {
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
		// TODO Auto-generated method stub
		String fullNameUser = request.getParameter("userfullname");
        String emailId = request.getParameter("useremail");
        String passwordUser = request.getParameter("userpass");
        String mobileNo = request.getParameter("usermobile");
        String status = "";
        
        // Kiểm tra xem các thông tin cần thiết có tồn tại không
        if (fullNameUser != null && !fullNameUser.isEmpty() &&
                emailId != null && !emailId.isEmpty() &&
                passwordUser != null && !passwordUser.isEmpty() &&
                		mobileNo  != null && !mobileNo .isEmpty()) {
        	
        	
        	UsersBean user = new UsersBean(emailId, passwordUser, fullNameUser, mobileNo, null, null, null, 1);
        	
            UsersServiceImpl dao = new UsersServiceImpl();

            // Thực hiện đăng ký người dùng
            status = dao.registerUser(user);

            // Chuyển hướng đến trang kết quả đăng ký
            response.sendRedirect("login.jsp?message=" + status);
        } else {
            // Nếu thông tin không đầy đủ, chuyển hướng đến trang lỗi
            response.sendRedirect("register.jsp");
        }
	}

}
