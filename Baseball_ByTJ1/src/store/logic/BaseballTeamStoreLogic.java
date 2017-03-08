package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.BaseballTeam;
import store.BaseballTeamStore;
import store.logic.utils.ConnectionFactory;

public class BaseballTeamStoreLogic implements BaseballTeamStore {

	private ConnectionFactory factory;

	public BaseballTeamStoreLogic() {

		factory = ConnectionFactory.getInstance();

	}

	@Override
	public BaseballTeam retrieve(String teamId) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BaseballTeam team = new BaseballTeam();
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, name, region, manager, stadium, logo from team_tb where id =? ");
			pstmt.setString(1, teamId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				team.setTeamId(rs.getString("id"));
				team.setName(rs.getString("name"));
				team.setRegion(rs.getString("region"));
				team.setManager(rs.getString("manager"));
				team.setStadium(rs.getString("stadium"));
				team.setLogo(rs.getString("logo"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return team;
	}
	@Override
	public List<BaseballTeam> retrieveAll() {
		
		List<BaseballTeam> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, name, region, manager, stadium, logo from team_tb ");
			rs = pstmt.executeQuery();
			
			
			
			while(rs.next()){
				BaseballTeam team = new BaseballTeam();
				
				team.setTeamId(rs.getString("id"));
				team.setName(rs.getString("name"));
				team.setRegion(rs.getString("region"));
				team.setManager(rs.getString("manager"));
				team.setStadium(rs.getString("stadium"));
				team.setLogo(rs.getString("logo"));
				
				list.add(team);				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		
		return list;
	}

}
