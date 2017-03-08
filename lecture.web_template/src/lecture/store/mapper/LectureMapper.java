package lecture.store.mapper;

import java.util.List;

import lecture.domain.Lecture;

public interface LectureMapper {

	void create(Lecture lecture);
	Lecture read(String lectureId);
	void update(Lecture lecture);
	void delete(String lectureId);
	List<Lecture> readAll();
}
