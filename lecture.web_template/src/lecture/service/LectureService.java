package lecture.service;

import java.util.List;

import lecture.domain.Lecture;

/**
 * LectureService
 * 
 * @since 2016. 3. 14.
 * @author 김은영 (eykim@nextree.co.kr)
 */
public interface LectureService {
	//
	void register(Lecture lecture);
	Lecture find(String lectureId);
	void modify(Lecture lecture);
	void remove(String lectureId);
	List<Lecture> findAll();
}
