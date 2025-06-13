package service;

import java.util.List;

import beans.BlogCategoriesBean;

public interface BlogCategoriesService {

	public List<BlogCategoriesBean> getAllCategories();

	public List<BlogCategoriesBean> getAllBlogCategories();

	public void addCategory(BlogCategoriesBean category);

	public void removeCategory(String catblogId);

	public void updateCategory(BlogCategoriesBean updateCategory);

	public BlogCategoriesBean getBlogCategoryById(int catblogId);

}
