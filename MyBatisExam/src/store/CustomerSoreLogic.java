package store;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Customer;

public class CustomerSoreLogic {

	private static final String resource = "config.xml";

	private SqlSessionFactory getSessionFactory() {
		Reader reader = null;

		try {
			reader = Resources.getResourceAsReader(resource);// 초기화 session

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(reader);
	}

	public int registerCustomer(Customer customer) {
		SqlSession sqlSession = getSessionFactory().openSession();
		try {
			int result = sqlSession.insert("insertCustomer", customer);// (아이디,값)
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	public List<Customer> searchAll(){
		SqlSession sqlSession = getSessionFactory().openSession();
		try{
		return sqlSession.selectList("selectAll");
		}finally{
			sqlSession.close();
		}
	}
	public List<Customer> searchByAge(int age){
		SqlSession sqlSession = getSessionFactory().openSession();
		try{
		return sqlSession.selectList("selectByAge",age);
		}finally{
			sqlSession.close();
		}
	}
	
	
	public Customer searchById(String cusId){
		SqlSession sqlSession = getSessionFactory().openSession();
		Customer cus = new Customer();
		cus.setId(cusId);
		
		try{
		return sqlSession.selectOne("selectById",cus);
		}finally{
			sqlSession.close();
		}
		
	}

}
