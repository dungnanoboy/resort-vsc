package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.impl.BlogsServiceImpl;

import java.io.IOException;
import java.util.List;

import beans.BlogsBean;

/**
 * Servlet implementation class BlogsSrv
 */
@WebServlet("/BlogsSrv")
public class BlogsSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogsSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String catid_s = request.getParameter("catid");
	    String aut = request.getParameter("aut");

	    int catid = 0; // Khởi tạo giá trị mặc định cho catid
	    if (catid_s != null && !catid_s.isEmpty()) {
	        try {
	            catid = Integer.parseInt(catid_s);
	        } catch (NumberFormatException e) {
	            // Log lỗi và xử lý nếu cần
	            e.printStackTrace();
	        }
	    }
        
        BlogsServiceImpl blogDao = new BlogsServiceImpl();
        List<BlogsBean> blogs = blogDao.getAllBlogs(catid, aut);

        request.setAttribute("blogs", blogs);

        request.getRequestDispatcher("blog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
