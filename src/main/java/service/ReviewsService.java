package service;

import java.util.List;

import beans.ReviewsBean;

public interface ReviewsService {

	public List<ReviewsBean> getReviewByBlogId(int blogId);

	public List<ReviewsBean> getAllReviews();

}
