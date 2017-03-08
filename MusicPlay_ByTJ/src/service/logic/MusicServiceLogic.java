package service.logic;

import java.util.List;

import domain.Music;
import service.MusicService;
import store.logic.MusicStoreLogic;

public class MusicServiceLogic  implements MusicService{

	private MusicStoreLogic store;
	
	public MusicServiceLogic () {
		
		store = new MusicStoreLogic();
	}
	
	
	@Override
	public Music find(int id) {
		return store.read(id);
	}

	@Override
	public List<Music> findByName(String name) {
		return store.readByName(name);
	}

	@Override
	public List<Music> findAll() {
		return store.readAll();
	}

}
