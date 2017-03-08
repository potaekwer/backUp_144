package member.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.domain.Member;
import member.store.factory.ConnectionFactory;
import member.store.utils.jdbcUtils;

public class MemberStoreLogic {
	
	private ConnectionFactory factory;
	
	public MemberStoreLogic(){
		factory = ConnectionFactory.getInstance();
	}
	public boolean insert(Member member){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int checkCount = 0;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"insert into member_tb(no, email, password,name,regDate)"
					+ "values(member_seq.nextval,?,?,?, sysdate)");
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			checkCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkCount >0;
	}
	
	
	public List<Member> selectAll(){
		List<Member> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = factory.createConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select no, email,password,name,regDate from member_tb");
			while(rs.next()){
				Member member = new Member();
				member.setNo(rs.getInt("no"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setRegDate(rs.getDate("regDate"));
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.close(conn,stmt,rs);
		}
		return list;
	}
	public List<Member> selectByName(String name){
		List<Member> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select no, email, password, name, regDate"
					+ " from member_tb where name = ?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Member member = new Member();
				member.setNo(rs.getInt("no"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setRegDate(rs.getDate("regDate"));
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.close(conn,pstmt,rs);
		}
		return list;
	}
	public Member searchByNo(int no){		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select no, email, password, name, regDate"
					+ " from member_tb where no = ?");
			pstmt.setInt(1, no);			
			rs = pstmt.executeQuery();			
			if(rs.next()){
				member.setNo(rs.getInt("no"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setRegDate(rs.getDate("regDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.close(conn,pstmt,rs);
		}
		return member;
	}
	public boolean deleteByNo(int no){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int checkCount = 0;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("delete from member_tb where no = ?");
			pstmt.setInt(1, no);		
			checkCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.close(pstmt,conn);
		}
		return checkCount >0;
		
	}
	
	

}
