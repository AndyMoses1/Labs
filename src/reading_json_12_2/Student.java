package reading_json_12_2;

import java.util.ArrayList;

public class Student {
	String name;
	int age;
	ArrayList<String> subjects = new ArrayList<>();

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		subjects.add("Java");
		subjects.add("C#");
		subjects.add("Network");
	}
}
