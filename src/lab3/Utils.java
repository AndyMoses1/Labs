package lab3;

import java.util.Scanner;

public class Utils {
	public int getInt(String prompt) {
		Scanner input = new Scanner(System.in);
		System.out.print(prompt);
		int value = input.nextInt();
		input.nextLine();
		return value;
	}

	public String getString(String prompt) {
		Scanner input = new Scanner(System.in);
		System.out.print(prompt);
		String value = input.nextLine();
		return value;
	}
}
