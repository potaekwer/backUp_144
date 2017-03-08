package lecture.domain;

/**
 * Lecture
 * 
 * @since 2016. 3. 14.
 * @author 김은영 (eykim@nextree.co.kr)
 */
public class Lecture {
	//
	private String id;
	private String lectureName;
	private String instructor;
	private String introduce;

	/**
	 * 기본 생성자
	 */
	public Lecture() {
		// Nothing to do.
	}

	/**
	 * 생성자
	 * 
	 * @param lectureName
	 * @param instructorName
	 * @param lectureIntroduce
	 */
	public Lecture(String lectureName, String instructorName, String lectureIntroduce) {
		this.lectureName = lectureName;
		this.instructor = instructorName;
		this.introduce = lectureIntroduce;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
