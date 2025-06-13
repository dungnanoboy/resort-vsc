package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BlogCategoriesBean;
import service.BlogCategoriesService;
import utility.DBUtil;

public class BlogCategoriesServiceImpl implements BlogCategoriesService{
	
	@Override
	public List<BlogCategoriesBean> getAllCategories() {
		List<BlogCategoriesBean> blogcategories = new ArrayList<BlogCategoriesBean>();

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT c.catblog_id, c.catblog_name, COUNT(p.post_id) AS blog_count\r\n"
					+ "FROM BlogCategories c\r\n"
					+ "LEFT JOIN Blogs p ON c.catblog_id = p.catblog_id\r\n"
					+ "GROUP BY c.catblog_id, c.catblog_name;");

			rs = ps.executeQuery();

			while (rs.next()) {

				BlogCategoriesBean blogcategory = new BlogCategoriesBean();

				blogcategory.setCatblogId(rs.getInt(1));
				blogcategory.setCatblogName(rs.getString(2));
				blogcategory.setBlogCount(rs.getInt(3));

				blogcategories.add(blogcategory);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return blogcategories;
	}
	
	@Override
	public List<BlogCategoriesBean> getAllBlogCategories() {
		List<BlogCategoriesBean> categories = new ArrayList<BlogCategoriesBean>();

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * from BlogCategories");

			rs = ps.executeQuery();

			while (rs.next()) {

				BlogCategoriesBean category = new BlogCategoriesBean();

				category.setCatblogId(rs.getInt(1));
				category.setCatblogName(rs.getString(2));

				categories.add(category);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return categories;
	}
	
	@Override
	public void addCategory(BlogCategoriesBean category) {
		
		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("insert into BlogCategories values(?,?);");
			ps.setInt(1, category.getCatblogId());
			ps.setString(2, category.getCatblogName());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);

	}
	
	@Override
	public void removeCategory(String catblogId) {

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("delete from BlogCategories where catblog_id=?");
			ps.setString(1, catblogId);

			ps.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);

	}

	@Override
	public void updateCategory(BlogCategoriesBean updateCategory) {
		Connection con = DBUtil.provideConnection();
	    PreparedStatement ps = null;

	    try {
	        ps = con.prepareStatement("update BlogCategories set catblog_name=? where catblog_id=?");

	        ps.setString(1, updateCategory.getCatblogName());
	        ps.setInt(2, updateCategory.getCatblogId());

	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.closeConnection(con);
	        DBUtil.closeConnection(ps);
	    }
	}
	
	@Override
	public BlogCategoriesBean getBlogCategoryById(int catblogId) {
		BlogCategoriesBean blogcate = null;

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from BlogCategories where catblog_id=?");

			ps.setInt(1, catblogId);
			rs = ps.executeQuery();

			if (rs.next()) {
				blogcate = new BlogCategoriesBean();
				blogcate.setCatblogId(rs.getInt("catblog_id"));
				blogcate.setCatblogName(rs.getString("catblog_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);

		return blogcate;
	}

}
