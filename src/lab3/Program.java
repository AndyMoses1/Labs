package lab3;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		//declared here and passed into methods DRY
		Scanner input = new Scanner(System.in);
		
		int age = getInt(input, "Enter your age: ");
		String name = getString(input, "Enter your name: ");

		System.out.println("age  = " + age);
		System.out.println("name = " + name);
	}

	public static int getInt(Scanner input, String prompt) {
		System.out.print(prompt);
		int value = input.nextInt();
		input.nextLine(); //puts next prompt on new line
		return value;
	}

	public static String getString(Scanner input, String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}

}


// 1st pass
//public class Program {
//
//	public static void main(String[] args) {
//		int age = getInt("Enter your age: ");
//		String name = getString("Enter your name: ");
//
//		System.out.println("age  = " + age);
//		System.out.println("name = " + name);
//	}
//
//	public static int getInt(String prompt) {
//		System.out.print(prompt);
//		Scanner s = new Scanner(System.in);
//		return s.nextInt();
//	}
//
//	public static String getString(String prompt) {
//		System.out.print(prompt);
//		Scanner s = new Scanner(System.in);
//		return s.nextLine();
//	}
//
//}