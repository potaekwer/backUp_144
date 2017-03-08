package hr.store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hr.domain.Employee;
import hr.store.EmployeeStore;
import hr.store.factory.ConnectionFactory;
import hr.store.factory.JdbcUtils;

public class EmployeeStoreLogic implements EmployeeStore {

	private ConnectionFactory factory;

	public EmployeeStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public List<Employee> retrieveAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Employee> list = new ArrayList<>();

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select empno, name, deptno from employee_tb");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();

				emp.setDeptNo(rs.getString("deptno"));
				emp.setName(rs.getString("name"));
				emp.setNo(rs.getString("empno"));

				list.add(emp);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public void create(Employee employee) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn =factory.createConnection();
			pstmt = conn.prepareStatement("insert into employee_tb values(?,?,?) where empno = ?");
			pstmt.setString(1, employee.getNo());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getDeptNo());
			pstmt.setString(4, employee.getNo());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeResource(conn,pstmt);
		}
		
		
		

	}

	@Override
	public List<Employee> retrieveByDeptNo(String deptNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Employee> list = new ArrayList<>();
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select empNo, name, deptNo from employee_tb where deptNo = ?");
			pstmt.setString(1, deptNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setDeptNo(rs.getString("deptNo"));
				emp.setName(rs.getString("name"));
				emp.setNo(rs.getString("empNo"));

				list.add(emp);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public void update(Employee employee) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn =factory.createConnection();
			pstmt = conn.prepareStatement("update employee_tb set empno = ?, name = ?, deptno = ? where empno = ?");
			pstmt.setString(1, employee.getNo()); 
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getDeptNo());
			pstmt.setString(4, employee.getNo());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeResource(conn,pstmt);
		}
		

	}

	@Override
	public Employee retrieve(String empNo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee emp = new Employee();
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select empno, name, deptno from employee_tb where empno = ? ");
			pstmt.setString(1, empNo);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				
				emp.setDeptNo(rs.getString("deptno"));
				emp.setName(rs.getString("name"));
				emp.setNo(rs.getString("empno"));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

}
