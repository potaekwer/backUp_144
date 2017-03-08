package blog.store.facade;

import java.util.List;
import java.util.Map;

import blog.domain.Author;

public interface AuthorStore {

	Author findAuthor(String id);
	
	List<Author> findAllAuthors();	
	
	List<Author> findAuthorsByName(String name);

	void registAuthor(Author author);

	int updateAuthor(Author author);

	int deleteAuthor(String id);
	
	List<Author> findAuthorsByIds(List<String> ids);
	
	List<Author> findAuthorByCondition(Map<String,String> conditionMap);

}
