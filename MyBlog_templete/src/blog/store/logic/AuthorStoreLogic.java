package blog.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import blog.domain.Author;
import blog.store.facade.AuthorStore;
import blog.store.mapper.AuthorMapper;

public class AuthorStoreLogic implements AuthorStore {

	private SqlSessionFactory factory;

	public AuthorStoreLogic() {

		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public Author findAuthor(String id) {
		SqlSession session = factory.openSession();
		Author author = null;
		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			author = mapper.findAuthor(id);
		} finally {
			session.close();
		}
		return author;
	}

	@Override
	public List<Author> findAllAuthors() {
		SqlSession session = factory.openSession();
		List<Author> list = null;
		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			list = mapper.findAllAuthors();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Author> findAuthorsByName(String name) {
		SqlSession session = factory.openSession();
		List<Author> list = null;
		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			list = mapper.findAuthorsByName(name);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void registAuthor(Author author) {
		
		SqlSession session = factory.openSession();
		
		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			mapper.registAuthor(author);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public int updateAuthor(Author author) {
		SqlSession session = factory.openSession();
		int check =0;
		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			check = mapper.updateAuthor(author);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int deleteAuthor(String id) {
		SqlSession session = factory.openSession();
		int check =0;
		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			check = mapper.deleteAuthor(id);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public List<Author> findAuthorsByIds(List<String> ids) {
		SqlSession session = factory.openSession();
		List<Author> list = null;

		try {

			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			list = mapper.findAuthorsByIds(ids);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<Author> findAuthorByCondition(Map<String, String> conditionMap) {
		SqlSession session = factory.openSession();
		List<Author> list = null;

		try {

			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			list = mapper.findAuthorByCondition(conditionMap);
		} finally {
			session.close();
		}

		return list;
	}

}
