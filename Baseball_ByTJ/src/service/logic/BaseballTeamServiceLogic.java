package service.logic;

import java.util.ArrayList;
import java.util.List;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;
import store.logic.BaseballTeamStoreLogic;
import store.logic.PlayerStoreLogic;

public class BaseballTeamServiceLogic implements BaseballTeamService{
	
	
	private BaseballTeamStoreLogic team;
	private PlayerStoreLogic player;
	
	
	
	public BaseballTeamServiceLogic(){
		team = new BaseballTeamStoreLogic();
		player = new PlayerStoreLogic();
		
	}
	@Override
	public BaseballTeam findTeam(String teamId) {
		BaseballTeam bt = new BaseballTeam();
		
		bt = team.retrieve(teamId);
		bt.setPlayers(player.retrieveByTeam(teamId));
		return bt;
	}

	@Override
	public List<BaseballTeam> findAllTeams() {
		
		
		return team.retrieveAll();
	}

	@Override
	public List<BaseballTeam> findAllTeamsWithPlayers() {
		
		List<BaseballTeam> list = new ArrayList<>();
		
		for(BaseballTeam bt : team.retrieveAll()){
			
			bt.setPlayers(player.retrieveByTeam(bt.getTeamId()));
			list.add(bt);
			
		}
		
		return list;
	}

	@Override
	public List<BaseballTeam> findTradeTargetPalyers(String teamId) {
		
		List<BaseballTeam> list = new ArrayList<>();
		for(BaseballTeam bt : team.retrieveAll()){
			if(bt.getTeamId().equals(teamId)){
				continue;
			}
			bt.setPlayers(player.retrieveByTeam(bt.getTeamId()));
			list.add(bt);
			
			}	
		return list;
		
		
	}

	@Override
	public Player findPlayer(String playerId) {
		
		
		return player.retrieve(playerId);
	}

	@Override
	public void tradePlayer(String sourcePlayerId, String targetPlayerId) {
		
		Player source = new Player();
		Player target = new Player();
		String temp;
		
		source = player.retrieve(sourcePlayerId);
		target = player.retrieve(targetPlayerId);
		
		temp = source.getTeamId();
		source.setTeamId(target.getTeamId());
		target.setTeamId(temp);
		
		player.update(source);
		player.update(target);
		
		
		
		
		
	}

}
