import java.util.Scanner;

public class Louncher_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		Scanner scan = new Scanner(System.in);
		StudentManage_v2 manage = new StudentManage_v2();
		
		int userSelect;
		
		while(true){
			System.out.println("1.�л����");
			System.out.println("2.�л��˻�");
			System.out.println("3.�л�����");
			System.out.println("4.�л����");
			System.out.println("5.�л�����");
			System.out.println("6.����");
			System.out.print("#�޴� :");
			userSelect = scan.nextInt();				
			
			switch(userSelect){
			
			case 1: 
				manage.registerStudent();
				break;
			case 2: 
				manage.searchStudent();
				break;
			case 3: 
				manage.deleteStudent();
				break;
			case 4: 
				manage.printStudent();
				break;
			case 5: 
				manage.modifyFile();
				break;
			case 6: 
				System.out.println("���α׷�����");
				return;
				
				
			
			}
		
		}
	}
	

}
