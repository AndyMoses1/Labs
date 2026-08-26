package reading_json_12_2;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class WriteJson {

	public static void main(String[] args) throws IOException {
		Gson gson = new Gson();

		// ---------- objects to JSON Strings ----------

		int[] nos = { 1, 3, 5, 7, 9 };
		System.out.println(gson.toJson(nos));

		String[] names = { "Bob", "Fred", "Wilma" };
		System.out.println(gson.toJson(names));

		Student[] students = {
				new Student("Bob", 21),
				new Student("Fred", 32),
				new Student("Wilma", 26)
		};
		System.out.println(gson.toJson(students));

		// ---------- a SINGLE object to a file ----------

		// toJson's second argument can be a Writer, so gson streams straight to
		// the file - no intermediate String needed.
		try (FileWriter writer = new FileWriter("src/student.json")) {
			gson.toJson(new Student("Bob", 21), writer);
		}

		// ---------- a LIST of objects to a file ----------

		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Bob", 21));
		studentList.add(new Student("Fred", 32));
		studentList.add(new Student("Wilma", 26));

		// A pretty-printing Gson makes the file readable. Same JSON otherwise.
		Gson pretty = new GsonBuilder().setPrettyPrinting().create();

		try (FileWriter writer = new FileWriter("src/students.json")) {
			pretty.toJson(studentList, writer);
		}

		// ---------- read them back to prove it worked ----------

		String singleJson = Files.readString(Paths.get("src/student.json"));
		Student one = gson.fromJson(singleJson, Student.class);
		System.out.println("Read back one: " + one.name + ", " + one.age);

		String listJson = Files.readString(Paths.get("src/students.json"));

		// A List needs a TypeToken: generics are erased at runtime, so
		// List<Student>.class does not exist. An array does not need this.
		Type listType = new TypeToken<List<Student>>() {}.getType();
		List<Student> readBack = gson.fromJson(listJson, listType);
		System.out.println("Read back list: " + readBack.size() + " students");
	}

}
