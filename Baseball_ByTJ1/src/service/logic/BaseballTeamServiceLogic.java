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
		
		String id = teamId;

		List<BaseballTeam> list = new ArrayList<>();
		
		for(BaseballTeam bt : team.retrieveAll()){
			
			if(bt.getName().equals(id)){
				System.out.println(bt.getName());
				System.out.println(id);
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
		
		System.out.println(source.getTeamId());
		System.out.println(target.getTeamId());
		temp = source.getTeamId();
		
		source.setTeamId(target.getTeamId());
		target.setTeamId(temp);
		
		System.out.println("=========================");
		
		System.out.println(source.getTeamId());
		System.out.println(target.getTeamId());
		player.update(source);
		player.update(target);
		
		
	}

}
