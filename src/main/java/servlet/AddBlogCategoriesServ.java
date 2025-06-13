package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.impl.BlogCategoriesServiceImpl;

import java.io.IOException;

import beans.BlogCategoriesBean;

/**
 * Servlet implementation class AddBlogCategoriesServ
 */
@WebServlet("/AddBlogCategoriesServ")
public class AddBlogCategoriesServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBlogCategoriesServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String blogcate = request.getParameter("blogcategory");
		
		BlogCategoriesBean blogcategory = new BlogCategoriesBean(blogcate, 0);
		BlogCategoriesServiceImpl blogcateDao = new BlogCategoriesServiceImpl();
		
		blogcateDao.addCategory(blogcategory);
		
		response.sendRedirect("blogcategoriesTB.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
