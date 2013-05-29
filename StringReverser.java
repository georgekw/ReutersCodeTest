package codeTest;

import java.util.Scanner;

public class StringReverser {
  
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		System.out.println("Enter a string you would like to reverse: ");
		while (input.hasNext()) {
			String s = input.nextLine();
			if (s.equals("q"))
				break;
			System.out.println(reverse(s));
			System.out.println("Press 'q' to exit, or enter a new string: ");
		}
		input.close();
	}
}
