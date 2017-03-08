package yorizori.store.jdbc;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceManager {
	private static DataSourceManager instance = new DataSourceManager();
	private DataSource dataSource;
	
	private DataSourceManager (){
		BasicDataSource ds =  new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		ds.setMaxTotal(50);//최대 커넥션 갯수
		ds.setMaxIdle(5);//idle 상태에 풀이 소유한 최대 커넥션 갯수
		ds.setInitialSize(5);//풀의 초기 커넥션 갯수
		ds.setMaxWaitMillis(1000);//커넥션이 존재하지 않을 떄 커넥션 획득에 대기할 시간
		dataSource = ds;
	
		
	
	}
	
	public static DataSource getDataSource(){
		return instance.dataSource;
	}
	

}
