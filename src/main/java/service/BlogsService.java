package service;

import java.util.List;

import beans.BlogsBean;

public interface BlogsService {
	
	public List<BlogsBean> getAllBlogs(int catid, String aut);

	public BlogsBean getBlogDetails(int blogId);

	public List<BlogsBean> getAllBlogs1();
}
