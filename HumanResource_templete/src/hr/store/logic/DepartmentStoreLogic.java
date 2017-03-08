package hr.store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hr.domain.Department;
import hr.store.DepartmentStore;
import hr.store.factory.ConnectionFactory;
import hr.store.factory.JdbcUtils;

public class DepartmentStoreLogic implements DepartmentStore {

	private ConnectionFactory factory;
	
	public DepartmentStoreLogic(){
		factory = ConnectionFactory.getInstance();
	}
	
	
	@Override
	public List<Department> retrieveAll() {
		Connection conn =null;
		Statement stmt =null;
		ResultSet rs = null;
		List<Department> list = new ArrayList<>();
		
		try {
			conn = factory.createConnection();
			
			StringBuffer sqlBuilder = new StringBuffer();
			sqlBuilder.append("select deptNo, deptName ");
			sqlBuilder.append("from dept_tb ");
			sqlBuilder.append("order by deptNo asc");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sqlBuilder.toString());
			
			while(rs.next()){
				Department dept = new Department(rs.getString("deptNo"), rs.getString("deptName"));
				list.add(dept);
				
				}
						
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeResource(conn,stmt,rs);
		}
		
	
		return list;
	}

	@Override
	public void create(Department department) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("insert into dept_tb (deptNo,deptName ) values(?,?)");
			pstmt.setString(1, department.getNo());
			pstmt.setString(2, department.getName());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeResource(conn,pstmt);
		}
	}

	@Override
	public Department retrieve(String deptNo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Department dept = null;
		
		try {
			conn = factory.createConnection();
			
			pstmt = conn.prepareStatement("select deptNo, deptName from dept_tb where deptNo = ?");
			pstmt.setString(1, deptNo);
			
			rs =pstmt.executeQuery();
			
			if(rs.next()){
				dept = new Department(rs.getString("deptNo"), rs.getString("deptName"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeResource(conn,pstmt,rs);
		}
		
		
		return dept;
	}
	@Override
	public void delete(String deptNo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("delete dept_tb where deptno = ?");
			pstmt.setString(1, deptNo);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
