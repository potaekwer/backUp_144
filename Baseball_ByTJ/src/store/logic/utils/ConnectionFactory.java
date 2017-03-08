package store.logic.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	private static ConnectionFactory  instance;
	
	private ConnectionFactory (){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				"jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		
	}
	
	
	
}
