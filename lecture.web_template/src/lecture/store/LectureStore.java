package lecture.store;

import java.util.List;

import lecture.domain.Lecture;

public interface LectureStore {
	
	void create(Lecture lecture);
	Lecture read(String lectureId);
	void update(Lecture lecture);
	void delete(String lectureId);
	List<Lecture> readAll();
}
