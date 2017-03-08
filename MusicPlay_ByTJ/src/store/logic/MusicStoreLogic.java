package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.Music;
import store.MusicStore;
import store.logic.utils.ConnectionFactory;
import store.logic.utils.JdbcUtils;
import store.mapper.MusicStoreMapper;
public class MusicStoreLogic implements MusicStore {
	
	private SqlSessionFactory factory;
	
	
	
	public MusicStoreLogic(){		
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	@Override
	public Music read(int id) {		

		SqlSession session = factory.openSession();
		Music music = new Music();
		try {
			
			MusicStoreMapper mapper = session.getMapper(MusicStoreMapper.class);
			music = mapper.read(id);
			
		}finally{
			session.close();
		}
		return music;
	}
	@Override
	public List<Music> readByName(String name) {
		SqlSession session = factory.openSession();
		List<Music> list = new ArrayList<>();
		try {
			MusicStoreMapper mapper = session.getMapper(MusicStoreMapper.class);
			list = mapper.readByName(name);
		}finally{
			session.close();
		}
		return list;
	}
	@Override
	public List<Music> readAll() {
		SqlSession session = factory.openSession();
		List<Music> list = new ArrayList<>();
		try {
			
			MusicStoreMapper mapper = session.getMapper(MusicStoreMapper.class);
			list = mapper.readAll();
		}finally{
			session.close();
		}
		return list;
	}
}
