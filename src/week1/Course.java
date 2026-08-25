package week1;

import java.util.HashMap;

public class Course {
	private String courseName;
	private HashMap<Student, Integer> studentGrades = new HashMap<>();

	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public void addStudent(Student student, int grade) {
		studentGrades.put(student, grade);
	}
	
	public void printStudentList() {
		System.out.println("Course: " + courseName);
		for (Student student : studentGrades.keySet()) {
			System.out.println(" - " + student.getDetails() + " - grade " + studentGrades.get(student));
		}
	}

}
