package lab2;

public class Lab2 {

	public static void main(String[] args) {
		// Change this value to test the different grade boundaries.
		int mark = 65;

		System.out.println(getGrade(mark));

	}

	public static String getGrade(int mark) {
		if (mark < 1 || mark > 100) {
			return "Error: marks must be between 1..100";
		} else if (mark >= 1 && mark < 50) {
			return "Fail";
		} else if (mark >= 50 && mark <= 60) {
			return "Pass";
		} else if (mark >= 61 && mark <= 70) {
			return "Merit";
		} else {
			// Everything else has been ruled out, so this is 71..100.
			return "Distinction";
		}
	}

}
