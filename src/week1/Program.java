package week1;

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		ArrayList<Course> courses = new ArrayList<>();
		Course publicSpeaking = new Course("publicSpeaking");
		Course laravel101 = new Course("laravel101");
		
		courses.add(publicSpeaking);
		courses.add(laravel101);
		
		Student student1 = new Student("Abraham Lincoln", "4scoreandseven@gettysburg.com", "SU0001");
		Student student2 = new Student("Neil Armstrong", "eagle@tranquility-base.moon", "SU0002");
		Student student3 = new Student("Marrie Currie", "polonium@radioactivity.com", "SU0003");
		
		publicSpeaking.addStudent(student1, 100);
		publicSpeaking.addStudent(student2, 60);
		
		laravel101.addStudent(student3, 85);
		laravel101.addStudent(student2, 65);
		laravel101.addStudent(student1, 40);
		
		for (Course course : courses ) {
			course.printStudentList();
		}
		
	}

}
