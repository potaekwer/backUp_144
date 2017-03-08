package algorithm;

import java.util.Scanner;

public class UniquenessString {

	public static void main(String[] args) {
//문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라. 다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?
		

		Scanner scan = new Scanner(System.in);
		
		
		String test;
		int num=0;
		
		System.out.println("입력하세요");
		test = scan.next();
		String ts [] = new String [test.length()];
		
		for(int i =0; i <test.length(); i++){
			ts[i] = test.substring(i,i+1);
		}
		
		
		
		for(int i=0; i<test.length()-1; i++){
			
			for(int j = i+1; j<test.length(); j++){
				
				if(ts[i].equals(ts[j])){
					System.out.println(ts[i]+"가 겹칩니다.");
					num++;
				}
				
			}
			
		}
		if(num==0){
			System.out.println("유일한 문자 열입니다.");
		}
		
		
		
		
		
		
	}
		
		
		

}
