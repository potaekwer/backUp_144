package algorithm;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String test1,test2;
		int num1=0, num2 =0;
		System.out.println("�Է��ϼ���");
		test1 = scan.next();
		System.out.println("�ι�° �Է��ϼ���");
		test2 = scan.next();
		
		
		for(int i =0; i <test1.length(); i++){
			num1 += test1.substring(i,i+1).charAt(0);
		}
		for(int i =0; i <test2.length(); i++){
			num2 += test2.substring(i,i+1).charAt(0);
		}
		
		if(num1 == num2){
			System.out.println("�����Դϴ�.");
		}else
			System.out.println("������ �ƴմϴ�.");
		
		
	}

}
