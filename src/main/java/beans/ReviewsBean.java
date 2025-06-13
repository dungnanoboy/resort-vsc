package beans;

import java.time.LocalDateTime;

public class ReviewsBean {
	
	private int reviewId;
	private String email;
	private int postId;
	private int rating;
	private String comment;
	private LocalDateTime releasedate;
	
	public ReviewsBean() {
	}

	public ReviewsBean(int reviewId, String email, int postId, int rating, String comment, LocalDateTime releasedate) {
		super();
		this.reviewId = reviewId;
		this.email = email;
		this.postId = postId;
		this.rating = rating;
		this.comment = comment;
		this.releasedate = releasedate;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(LocalDateTime releasedate) {
		this.releasedate = releasedate;
	}
	
	

}
