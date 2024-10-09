package exam1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		
		System.out.print("Enter : " );
		String s = scanner.nextLine();
		System.out.println(s);
		
		for(int i = 0; i < s.length(); i++) {
			int digit = s.charAt(i);
			
			if(i == s.length() -1 ) 
			System.out.print(digit - '0' +" = ");
			else System.out.print(digit - '0' +" + ");
			
			sum = sum + digit - '0';
		}
		System.out.println(sum);
		

	}
}
