import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.*;

public class StudentManage_v2 {

	private ArrayList<Student> stds;
	private Scanner scan;

	public StudentManage_v2() {

		scan = new Scanner(System.in);
		stds = new ArrayList<>();
		load();
	}

	public void registerStudent() {

		String yesOrNo;

		while (true) {
			Student std = new Student();

			System.out.print("이름:");
			std.setName(scan.next());
			System.out.print("학번:");
			std.setShoolNumber(scan.next());
			System.out.print("국어:");
			std.setKor(scan.nextInt());
			System.out.print("영어:");
			std.setEng(scan.nextInt());
			System.out.print("수학:");
			std.setMath(scan.nextInt());

			stds.add(std);

			System.out.print("계속?  Y/N:");
			yesOrNo = scan.next();

			if (yesOrNo.toLowerCase().equals("n")) {
				save();
				return;
			}

		}

	}

	public void searchStudent() {
		// 재사용 불가 코드
		// String findString;
		// boolean flag = false;
		//
		// System.out.print("학번:");
		// findString = scan.next();
		//
		// for (Student s : stds) {
		// if (s.getShoolNumber().equals(findString)) {
		// System.out.println("=============검색==============");
		// System.out.println(s.toString());
		// flag = true;
		// }
		// }
		//
		// if (!flag) {
		// System.out.println("찾는 학생이 존재하지 않습니다.");
		// }

		// ======================================================
		// 재사용 가능 코드

		Student s = search();

		if (s != null) {
			System.out.println("=============검색==============");
			System.out.println(s.toString());

		} else {
			System.out.println("찾는 학번의 학생이 존재하지 않습니다.");
		}

	}

	public void deleteStudent() {

		Student s = search();

		if (s != null) {

			stds.remove(s);
			save();

		} else {
			System.out.println("찾는 학번의 학생이 존재하지 않습니다.");
		}

	}

	public void modifyFile() {

		String findString;

		System.out.print("학번 :");
		findString = scan.next();
		int check = 0;

		for (Student s : stds) {
			if (s.getShoolNumber().equals(findString)) {
				check++;
				System.out.print("이름:");
				s.setName(scan.next());
				System.out.print("학번:");
				s.setShoolNumber(scan.next());
				System.out.print("국어:");
				s.setKor(scan.nextInt());
				System.out.print("영어:");
				s.setEng(scan.nextInt());
				System.out.print("수학:");
				s.setMath(scan.nextInt());
			}

		}

		if (check == 0) {
			System.out.println("찾는 학번의 학생이 없습니다.");
		}
		save();

	}

	private void save() {

		ObjectOutputStream fout = null;

		try {
			fout = new ObjectOutputStream(new FileOutputStream("student_data.txt"));
			fout.writeObject(stds);
			fout.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fout != null)
					fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void load() {

		ObjectInputStream fin = null;
		String readData;

		String[] ary;

		try {
			fin = new ObjectInputStream(new FileInputStream("student_data.txt"));
			stds = (ArrayList<Student>) fin.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fin != null)
					fin.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Student search() {
		String findString;
		Student findStd = null;

		System.out.print("학번 :");
		findString = scan.next();

		for (Student s : stds) {
			if (s.getShoolNumber().equals(findString)) {
				findStd = s;
			}
		}
		return findStd;

	}

	public void printStudent() {

		int select;

		System.out.println("1.성적순 출력");
		System.out.println("2.학번순 출력");
		System.out.print("3.메뉴:");
		select = scan.nextInt();

		if (select == 1) {
			Collections.sort(stds);//compareTo student클래스에 성적순으로 정렬을 미리 해놓음
			for (Student s : stds) {
				System.out.println("===========성적순 출력=============");
				System.out.println(s.toString());
			}
		} else if (select == 2) {
			System.out.println("===========학번순 출력=============");
			Collections.sort(stds, new Comparator<Student>() {//compareTo 비교대상 

				public int compare(Student o1, Student o2) {

					return o1.getShoolNumber().compareTo(o2.getShoolNumber());
				}
			});
			for (Student s : stds) {
				System.out.println(s.toString());
			}

		}

	}

}
