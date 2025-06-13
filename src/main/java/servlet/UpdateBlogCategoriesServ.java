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
 * Servlet implementation class UpdateBlogCategoriesServ
 */
@WebServlet("/UpdateBlogCategoriesServ")
public class UpdateBlogCategoriesServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBlogCategoriesServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String catblogIdStr = request.getParameter("id");
		if (catblogIdStr != null) {
			int catblogId = Integer.parseInt(catblogIdStr);

			BlogCategoriesServiceImpl blogCategoriesService = new BlogCategoriesServiceImpl();
			BlogCategoriesBean blogCategory = blogCategoriesService.getBlogCategoryById(catblogId);

			request.setAttribute("blogCategory", blogCategory);

			request.getRequestDispatcher("-blogcategoriesTB.jsp").forward(request, response);
		} else {
			response.sendRedirect("error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int catblogIdStr = Integer.parseInt(request.getParameter("catblogId"));
		String catblogName = request.getParameter("catblogName");

		
		BlogCategoriesServiceImpl blogCategoriesService = new BlogCategoriesServiceImpl();
		BlogCategoriesBean updateCategory = new BlogCategoriesBean(catblogIdStr, catblogName, 0);

		blogCategoriesService.updateCategory(updateCategory);

		response.sendRedirect("blogcategoriesTB.jsp");

	}

}
