package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.impl.BlogsServiceImpl;
import service.impl.ReviewsServiceImpl;

import java.io.IOException;
import java.util.List;

import beans.BlogsBean;
import beans.ReviewsBean;

/**
 * Servlet implementation class BlogInfoSrv
 */
@WebServlet("/BlogInfoSrv")
public class BlogInfoSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogInfoSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lấy tham số blogId từ request và chuyển đổi sang kiểu int
	    String blogIdParam = request.getParameter("blogId");
	    int blogId = 0; // Khởi tạo giá trị mặc định cho blogId
	    if (blogIdParam != null && !blogIdParam.isEmpty()) {
	        try {
	            blogId = Integer.parseInt(blogIdParam);
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	            // Bạn có thể xử lý thêm nếu blogId không hợp lệ, ví dụ: chuyển hướng đến trang lỗi
	        }
	    }

	    // Sử dụng blogId để lấy thông tin chi tiết blog và các đánh giá
	    BlogsServiceImpl bDao = new BlogsServiceImpl();
	    BlogsBean blog = bDao.getBlogDetails(blogId);

	    ReviewsServiceImpl revDao = new ReviewsServiceImpl();
	    List<ReviewsBean> reviews = revDao.getReviewByBlogId(blogId);

	    // Set blog và reviews vào request để sử dụng trong JSP
	    request.setAttribute("blog", blog);
	    request.setAttribute("reviews", reviews);

	    // Chuyển hướng sang trang JSP hiển thị thông tin blog
	    request.getRequestDispatcher("single-blog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
