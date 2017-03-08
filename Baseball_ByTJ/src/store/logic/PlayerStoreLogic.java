package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Player;
import store.PlayerStore;
import store.logic.utils.ConnectionFactory;

public class PlayerStoreLogic implements PlayerStore{
	
	private ConnectionFactory factory;
	
	
	public PlayerStoreLogic(){
		factory = ConnectionFactory.getInstance();
	}
	@Override
	public void update(Player player) {
			Connection conn = null;
			PreparedStatement pstmt = null;	
			try {
				conn = factory.createConnection();
				pstmt = conn.prepareStatement("update player_tb set teamid = ? where id = ?");
				pstmt.setString(1, player.getTeamId());
				pstmt.setString(2, player.getPlayerId());
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public Player retrieve(String playerId) {
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		Player player = new Player();
		
		
		try {
			
			conn =factory.createConnection();
			pstmt = conn.prepareStatement("select teamid, name, backnumber, position, hitting, throw from player_tb where id = ?");
			pstmt.setString(1, playerId);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				player.setPlayerId(playerId);
				player.setTeamId(rs.getString("teamId"));
				player.setName(rs.getString("name"));
				player.setBackNumber(rs.getInt("backNumber"));
				player.setPosition(rs.getString("position"));
				player.setHittingHand(rs.getString("hitting"));
				player.setThrowHand(rs.getString("throw"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return player;
	}
	@Override
	public List<Player> retrieveByTeam(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Player> list = new ArrayList<>();
		
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, teamid, name, backnumber, position, hitting, throw from player_tb where teamid = ?");
			pstmt.setString(1, teamId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Player player = new Player();
				
				player.setPlayerId(rs.getString("id"));
				player.setTeamId(rs.getString("teamId"));
				player.setName(rs.getString("name"));
				player.setBackNumber(rs.getInt("backNumber"));
				player.setPosition(rs.getString("position"));
				player.setHittingHand(rs.getString("hitting"));
				player.setThrowHand(rs.getString("throw"));
				list.add(player);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
