package lab5;

import lab2.Lab2;

public class GradesForStudents {

	public static void main(String[] args) {
		String[] students = { "Alice", "Bob", "Charlie", "Priya", "Sam" };
		int[] marks = { 45, 55, 65, 75, 100 };

		for (int i = 0; i < students.length; i++) {
			String grade = Lab2.getGrade(marks[i]);

			System.out.printf("%-8s %3d  %s%n", students[i], marks[i], grade);
		}
	}

}
