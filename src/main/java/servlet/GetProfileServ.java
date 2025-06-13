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
 * Servlet implementation class GetProfileServ
 */
@WebServlet("/GetProfileServ")
public class GetProfileServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProfileServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");

        if (email != null && !email.isEmpty()) {
            UsersServiceImpl userService = new UsersServiceImpl();
            UsersBean user = userService.getUserById(email);

            if (user != null) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("account.jsp").forward(request, response);
                return;
            }
        }

        response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
