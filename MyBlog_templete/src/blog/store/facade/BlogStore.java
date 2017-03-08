package blog.store.facade;

import java.util.List;

import blog.domain.Blog;


public interface BlogStore {
	Blog findBlog(int id);

	Blog findBlogByAuthorId(String authorId);
	
	List<Blog> findAllBlogs();

	List<Blog> findBlogsByTitle(String title);
	
	void registBlog(Blog blog);
	
	int updateBlog(Blog blog);

	int deleteBlog(int id);
}
