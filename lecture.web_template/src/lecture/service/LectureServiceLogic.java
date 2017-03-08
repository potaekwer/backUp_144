package lecture.service;

import java.util.List;

import lecture.domain.Lecture;
import lecture.store.LectureStore;
import lecture.store.LectureStoreLogic;

/**
 * LectureServiceLogic
 * 
 * @since 2016. 3. 14.
 * @author 김은영 (eykim@nextree.co.kr)
 */
public class LectureServiceLogic implements LectureService {

	private LectureStore Store;

	public LectureServiceLogic() {
		
		Store = new LectureStoreLogic();
	}

	@Override
	public void register(Lecture lecture) {
		String lectureId = this.nextId();
		lecture.setId(lectureId);
		Store.create(lecture);
	}

	private String nextId() {
		List<Lecture> allLectures = Store.readAll();
		if (allLectures.isEmpty()) {
			return "0";
		}

		int maxId = Integer.MIN_VALUE;
		for (Lecture lecture : allLectures) {
			int lectureId = Integer.parseInt(lecture.getId());
			if (maxId < lectureId) {
				maxId = lectureId;
			}
		}

		return String.valueOf(maxId + 1);
	}

	@Override
	public Lecture find(String lectureId) {
		//
		Lecture lecture = Store.read(lectureId);
		if (lecture != null) {
			return lecture;
		}
		throw new RuntimeException("저장된 강좌가 없습니다.");
	}

	@Override
	public void modify(Lecture lecture) {
		//
		Store.update(lecture);
		
	}

	@Override
	public void remove(String lectureId) {
		//
		Store.delete(lectureId);
	}

	@Override
	public List<Lecture> findAll() {
		//
		return Store.readAll();
	}

}
