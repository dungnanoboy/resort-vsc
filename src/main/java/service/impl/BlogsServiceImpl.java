package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BlogsBean;
import service.BlogsService;
import utility.DBUtil;

public class BlogsServiceImpl implements BlogsService{
	
	@Override
	public List<BlogsBean> getAllBlogs(int catid, String aut) {
	    List<BlogsBean> blogs = new ArrayList<>();

	    Connection con = DBUtil.provideConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    String query = "SELECT * FROM blogs";

	    boolean hasCondition = false;
	    
	    if (catid != 0 || aut != null) {
	        query = query + " WHERE";
	        if (catid != 0) {
	            query = query + " catblog_id = ?";
	            hasCondition = true;
	        }

	        if (aut != null) {
	            if (hasCondition) {
	                query = query + " AND";
	            }
	            query = query + " author = ?";
	            hasCondition = true;
	        }
	    }
	    
	    try {
	        ps = con.prepareStatement(query);
	        
	        int parameterIndex = 1;

	        if (catid != 0) {
	            ps.setInt(parameterIndex++, catid);
	        }

	        if (aut != null) {
	            ps.setString(parameterIndex, aut);
	        }
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            BlogsBean blog = new BlogsBean();

	            blog.setPostId(rs.getInt("post_id"));
	            blog.setTitle(rs.getString("title"));
	            blog.setContent(rs.getString("content"));
	            blog.setSummary(rs.getString("summary"));
	            blog.setAuthor(rs.getString("author"));
	            blog.setPublishDate(rs.getTimestamp("publish_date").toLocalDateTime());
	            blog.setCatblogId(rs.getInt("catblog_id"));
	            blog.setPicture(rs.getString("picture"));
	            blog.setEmotion(rs.getInt("emotion"));

	            blogs.add(blog);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.closeConnection(con);
	        DBUtil.closeConnection(ps);
	        DBUtil.closeConnection(rs);
	    }

	    return blogs;
	}
	
	@Override
	public BlogsBean getBlogDetails(int blogId) {
		BlogsBean blog = null;

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from blogs where post_id=?");

			ps.setInt(1, blogId);
			rs = ps.executeQuery();

			if (rs.next()) {
				blog = new BlogsBean();
	            blog.setPostId(rs.getInt("post_id"));
	            blog.setTitle(rs.getString("title"));
	            blog.setContent(rs.getString("content"));
	            blog.setSummary(rs.getString("summary"));
	            blog.setAuthor(rs.getString("author"));
	            blog.setPublishDate(rs.getTimestamp("publish_date").toLocalDateTime());
	            blog.setCatblogId(rs.getInt("catblog_id"));
	            blog.setPicture(rs.getString("picture"));
	            blog.setEmotion(rs.getInt("emotion"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);

		return blog;
	}
	
	@Override
	public List<BlogsBean> getAllBlogs1() {
		List<BlogsBean> blogs = new ArrayList<BlogsBean>();

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * from Blogs");

			rs = ps.executeQuery();

			while (rs.next()) {

				BlogsBean blog = new BlogsBean();

				blog.setPostId(rs.getInt(1));
				blog.setTitle(rs.getString(2));
				blog.setContent(rs.getString(3));
				blog.setSummary(rs.getString(4));
				blog.setAuthor(rs.getString(5));	
				blog.setPublishDate(rs.getTimestamp(6).toLocalDateTime());
				blog.setCatblogId(rs.getInt(7));
				blog.setPicture(rs.getString(8));
				blog.setEmotion(rs.getInt(9));

				blogs.add(blog);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return blogs;
	}

}
