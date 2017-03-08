package yorizori.store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import yorizori.common.util.JdbcUtils;
import yorizori.domain.User;
import yorizori.store.UserStore;

public class UserStoreLogic  implements UserStore{
	
	private DataSource dataSource;
	
	public UserStoreLogic(DataSource dataSource){
		this.dataSource = dataSource;
	}

	@Override
	public void create(User user) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("insert into user_tb(user_id, passwd, user_name) values(?,?,?)");
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			
			pstmt.executeQuery();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeQuietly(pstmt,conn);
		}
	}

	@Override
	public User retrieve(String userId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		User user = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select user_id, passwd, user_name from user_tb where user_id = ?");
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				
				
				user = converttoDomain(rs);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return user;
	}
	
	
	private User converttoDomain(ResultSet rs) throws SQLException{
		
		User user = new User();
		
		user.setUserId(rs.getString("user_id"));
		user.setPassword(rs.getString("passwd"));
		user.setName(rs.getString("user_name"));
		
		
		return user;
	}

}
