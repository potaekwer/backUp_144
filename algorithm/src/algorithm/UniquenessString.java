package algorithm;

import java.util.Scanner;

public class UniquenessString {

	public static void main(String[] args) {
//���ڿ��� ���Ե� ���ڵ��� ���� ���������� �˻��ϴ� �˰����� �����϶�. �ٸ� �ڷᱸ���� ����� �� ���� ��Ȳ�̶�� ��� �ϰڴ°�?
		

		Scanner scan = new Scanner(System.in);
		
		
		String test;
		int num=0;
		
		System.out.println("�Է��ϼ���");
		test = scan.next();
		String ts [] = new String [test.length()];
		
		for(int i =0; i <test.length(); i++){
			ts[i] = test.substring(i,i+1);
		}
		
		
		
		for(int i=0; i<test.length()-1; i++){
			
			for(int j = i+1; j<test.length(); j++){
				
				if(ts[i].equals(ts[j])){
					System.out.println(ts[i]+"�� ��Ĩ�ϴ�.");
					num++;
				}
				
			}
			
		}
		if(num==0){
			System.out.println("������ ���� ���Դϴ�.");
		}
		
		
		
		
		
		
	}
		
		
		

}
