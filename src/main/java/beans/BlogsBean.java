package beans;

import java.time.LocalDateTime;

public class BlogsBean {
	
	private int postId;
	private String title;
	private String content;
	private String summary;
	private String author;
	private LocalDateTime publishDate;
	private int catblogId;
	private String picture;
	private int emotion;
	
	public BlogsBean() {
	}

	public BlogsBean(int postId, String title, String content, String summary, String author, LocalDateTime publishDate, int catblogId,
			String picture, int emotion) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.summary = summary;
		this.author = author;
		this.publishDate = publishDate;
		this.catblogId = catblogId;
		this.picture = picture;
		this.emotion = emotion;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDateTime publishDate) {
		this.publishDate = publishDate;
	}

	public int getCatblogId() {
		return catblogId;
	}

	public void setCatblogId(int catblogId) {
		this.catblogId = catblogId;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getEmotion() {
		return emotion;
	}

	public void setEmotion(int emotion) {
		this.emotion = emotion;
	}

	
	
	

}
