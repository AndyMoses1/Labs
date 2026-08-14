package lab2;

public class Program {

	public static void main(String[] args) {
		// Change this value to test the different grade boundaries.
		int mark = 65;

		if (mark < 1 || mark > 100) {
			System.out.println("Error: marks must be between 1..100");
		} else if (mark >= 1 && mark < 50) {
			System.out.println("Fail");
		} else if (mark >= 50 && mark <= 60) {
			System.out.println("Pass");
		} else if (mark >= 61 && mark <= 70) {
			System.out.println("Merit");
		} else if (mark >= 71 && mark <= 100) {
			System.out.println("Distinction");
		}

	}

}
