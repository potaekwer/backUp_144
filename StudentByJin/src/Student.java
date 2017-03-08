import java.io.Serializable;

public class Student implements Comparable<Student> , Serializable {

	private String name;
	private String shoolNumber;
	private int kor, eng, math;

	private double AVG;
	private int total;

	public Student() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShoolNumber() {
		return shoolNumber;
	}

	public void setShoolNumber(String shoolNumber) {
		this.shoolNumber = shoolNumber;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		calculateScore();
	}

	public int getEng() {
		return eng;

	}

	public void setEng(int eng) {
		this.eng = eng;
		calculateScore();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		calculateScore();
	}

	public int getTotal() {
		return total;
	}

	public double getAVG() {
		return AVG;
	}

	private void calculateScore() {

		total = kor + eng + math;
		AVG = (double) total / 3;

	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", shoolNumber=" + shoolNumber + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + ", AVG=" + AVG + ", total=" + total + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub

		if (total < o.getTotal()) {
			return 1;

		} else if (total > o.getTotal()) {
			return -1;
		} else {
			return 0;
		}

	}

}
