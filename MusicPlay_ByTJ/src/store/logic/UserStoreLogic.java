package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Music;
import domain.User;
import store.UserStore;
import store.logic.utils.ConnectionFactory;
import store.logic.utils.JdbcUtils;

public class UserStoreLogic implements UserStore{

	private ConnectionFactory factory;
	
	public UserStoreLogic(){
		factory = ConnectionFactory.getInstance();
	}
	
	@Override
	public boolean create(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count=0;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("INSERT INTO USER_TB VALUES (?,?,?)");
			pstmt.setString(1, user.getLoginId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			JdbcUtils.closeResource(conn,pstmt);
			
		}
		return count>0;
	}

	@Override
	public User read(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select loginid, password, name from USER_TB where loginid = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();	
			if(rs.next()){
				user.setLoginId(rs.getString("loginId"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt);
		}
		
		return user;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}









