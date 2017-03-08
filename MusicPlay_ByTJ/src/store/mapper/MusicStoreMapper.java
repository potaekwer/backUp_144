package store.mapper;

import java.util.List;

import domain.Music;

public interface MusicStoreMapper {
	Music read(int id);
	List<Music> readByName(String name);
	List<Music> readAll();
}
