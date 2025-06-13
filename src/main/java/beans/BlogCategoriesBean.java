package beans;

public class BlogCategoriesBean {
	
	private int catblogId;
	private String catblogName;
	private int blogCount;
	
	public BlogCategoriesBean() {
	}

	public BlogCategoriesBean(int catblogId, String catblogName, int blogCount) {
		super();
		this.catblogId = catblogId;
		this.catblogName = catblogName;
		this.blogCount = blogCount;
	}

	public BlogCategoriesBean(String catblogName, int blogCount) {
		super();
		this.catblogName = catblogName;
		this.blogCount = blogCount;
	}

	public int getCatblogId() {
		return catblogId;
	}

	public void setCatblogId(int catblogId) {
		this.catblogId = catblogId;
	}

	public String getCatblogName() {
		return catblogName;
	}

	public void setCatblogName(String catblogName) {
		this.catblogName = catblogName;
	}

	public int getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(int blogCount) {
		this.blogCount = blogCount;
	}
	
	

}
