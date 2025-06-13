package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ReviewsBean;
import service.ReviewsService;
import utility.DBUtil;

public class ReviewsServiceImpl implements ReviewsService{
	
	@Override
	public List<ReviewsBean> getReviewByBlogId(int blogId) {
	    List<ReviewsBean> reviews = new ArrayList<>();

	    Connection con = DBUtil.provideConnection();

	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        ps = con.prepareStatement("SELECT * FROM Reviews WHERE post_id = ?");
	        ps.setInt(1, blogId);

	        rs = ps.executeQuery();

	        while (rs.next()) {
	        	ReviewsBean review = new ReviewsBean();

	        	review.setReviewId(rs.getInt("review_id"));
	        	review.setEmail(rs.getString("email"));
	        	review.setPostId(rs.getInt("post_id"));
	        	review.setRating(rs.getInt("rating"));
	        	review.setComment(rs.getString("comment"));
	        	review.setReleasedate(rs.getTimestamp("releasedate").toLocalDateTime());

	            reviews.add(review);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.closeConnection(con);
	        DBUtil.closeConnection(ps);
	        DBUtil.closeConnection(rs);
	    }

	    return reviews;
	}
	
	@Override
	public List<ReviewsBean> getAllReviews() {
		List<ReviewsBean> reviews = new ArrayList<ReviewsBean>();

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * from Reviews");

			rs = ps.executeQuery();

			while (rs.next()) {

				ReviewsBean review = new ReviewsBean();

				review.setReviewId(rs.getInt(1));
				review.setEmail(rs.getString(2));
				review.setPostId(rs.getInt(3));
				review.setRating(rs.getInt(4));
				review.setComment(rs.getString(5));	
				review.setReleasedate(rs.getTimestamp(6).toLocalDateTime());

				reviews.add(review);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return reviews;
	}

}
