package blog.store.facade;

import java.util.List;

import blog.domain.Post;

public interface PostStore {

	Post findPost(int id);

	List<Post> findAllPost();

	List<Post> findPostsByBlogId(int id);

	List<Post> findPostsByAuthorName(String authorName);

	List<Post> findPostsByBlogTitle(String blogTitle);

	List<Post> findPostsBySubject(String subject);

	List<Post> findPostsByContents(String contents);

	int registPost(Post post);

	int updatePost(Post post);

	int deletePost(int id);

}
