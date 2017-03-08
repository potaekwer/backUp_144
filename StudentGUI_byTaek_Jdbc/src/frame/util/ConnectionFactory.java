package frame.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static ConnectionFactory instance;
	
	private ConnectionFactory(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("드라이버 로딩 오류");
		}
	}
	
	public static ConnectionFactory getInstance(){
		if(instance == null){
			instance = new ConnectionFactory();
		}
		
		return instance;
	}
	
	public Connection createConnection() throws SQLException{
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
	}
}







