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

			System.out.print("�̸�:");
			std.setName(scan.next());
			System.out.print("�й�:");
			std.setShoolNumber(scan.next());
			System.out.print("����:");
			std.setKor(scan.nextInt());
			System.out.print("����:");
			std.setEng(scan.nextInt());
			System.out.print("����:");
			std.setMath(scan.nextInt());

			stds.add(std);

			System.out.print("���?  Y/N:");
			yesOrNo = scan.next();

			if (yesOrNo.toLowerCase().equals("n")) {
				save();
				return;
			}

		}

	}

	public void searchStudent() {
		// ���� �Ұ� �ڵ�
		// String findString;
		// boolean flag = false;
		//
		// System.out.print("�й�:");
		// findString = scan.next();
		//
		// for (Student s : stds) {
		// if (s.getShoolNumber().equals(findString)) {
		// System.out.println("=============�˻�==============");
		// System.out.println(s.toString());
		// flag = true;
		// }
		// }
		//
		// if (!flag) {
		// System.out.println("ã�� �л��� �������� �ʽ��ϴ�.");
		// }

		// ======================================================
		// ���� ���� �ڵ�

		Student s = search();

		if (s != null) {
			System.out.println("=============�˻�==============");
			System.out.println(s.toString());

		} else {
			System.out.println("ã�� �й��� �л��� �������� �ʽ��ϴ�.");
		}

	}

	public void deleteStudent() {

		Student s = search();

		if (s != null) {

			stds.remove(s);
			save();

		} else {
			System.out.println("ã�� �й��� �л��� �������� �ʽ��ϴ�.");
		}

	}

	public void modifyFile() {

		String findString;

		System.out.print("�й� :");
		findString = scan.next();
		int check = 0;

		for (Student s : stds) {
			if (s.getShoolNumber().equals(findString)) {
				check++;
				System.out.print("�̸�:");
				s.setName(scan.next());
				System.out.print("�й�:");
				s.setShoolNumber(scan.next());
				System.out.print("����:");
				s.setKor(scan.nextInt());
				System.out.print("����:");
				s.setEng(scan.nextInt());
				System.out.print("����:");
				s.setMath(scan.nextInt());
			}

		}

		if (check == 0) {
			System.out.println("ã�� �й��� �л��� �����ϴ�.");
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

		System.out.print("�й� :");
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

		System.out.println("1.������ ���");
		System.out.println("2.�й��� ���");
		System.out.print("3.�޴�:");
		select = scan.nextInt();

		if (select == 1) {
			Collections.sort(stds);//compareTo studentŬ������ ���������� ������ �̸� �س���
			for (Student s : stds) {
				System.out.println("===========������ ���=============");
				System.out.println(s.toString());
			}
		} else if (select == 2) {
			System.out.println("===========�й��� ���=============");
			Collections.sort(stds, new Comparator<Student>() {//compareTo �񱳴�� 

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
