package lecture.store;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lecture.domain.Lecture;
import lecture.store.mapper.LectureMapper;
import lecture.store.utils.ConnectionFactory;
import lecture.store.utils.JdbcUtils;

/**
 * LectureStoreLogic
 * 
 * @since 2017. 2. 20.
 * @author 정택진
 */
public class LectureStoreLogic implements LectureStore {

	private static final String resource = "lecture/store/config.xml";
	private SqlSessionFactory getSessionFactory(){
		Reader reader = null;
		
		try {
			reader = Resources.getResourceAsReader(resource);// 초기화 session

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(reader);
	
	}

	@Override
	public void create(Lecture lecture) {
		SqlSession session = getSessionFactory().openSession();
		try {
			
			LectureMapper mapper =  session.getMapper(LectureMapper.class);
			mapper.create(lecture);
			session.commit();
			
		}finally {
			session.close();
		}

	}

	@Override
	public Lecture read(String lectureId) {
		SqlSession session = getSessionFactory().openSession();
		try{
			LectureMapper mapper = session.getMapper(LectureMapper.class);
			return mapper.read(lectureId);
		}finally{
			session.close();
		}
	}

	@Override
	public void update(Lecture lecture) {

		SqlSession session = getSessionFactory().openSession();
		try{
			LectureMapper mapper = session.getMapper(LectureMapper.class);
			mapper.update(lecture);
			session.commit();
		}finally{
			session.close();
		}

	}

	@Override
	public void delete(String lectureId) {

		SqlSession session = getSessionFactory().openSession();
		try{
			LectureMapper mapper = session.getMapper(LectureMapper.class);
			mapper.delete(lectureId);
			session.commit();
		}finally{
			session.close();
		}

	}

	@Override
	public List<Lecture> readAll() {
		SqlSession session = getSessionFactory().openSession();
		List<Lecture> list = null;
		try {
			LectureMapper mapper =  session.getMapper(LectureMapper.class);
			list = mapper.readAll();
			return list;
			
			
		}finally {
			session.close();
		}
	}
}
