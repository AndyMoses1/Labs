package accessing_files_12;

import java.io.*;

public class Program {

	public static void main(String[] args) throws IOException {
		String[] courses = readCSV("src/course.txt");
		String[] trainers = readCSV("src/trainer.txt");
		String outputFile = "src/trainersAndCourses.txt";

		System.out.println("Courses read:  " + courses.length);
		System.out.println("Trainers read: " + trainers.length);
		
		//System.out.println(courses);
		//System.out.println(trainers);
		
		//appendFile("src/trainersAndCourses.txt", );
		appendFile(outputFile, String.join(",", courses));
		appendFile(outputFile, String.join(",", trainers));

		//System.out.println("Written to src/trainersAndCourses.txt");
	}
	
	private static void appendFile(String file, String line) throws IOException {
        // true = append. Without it, every call overwrites the whole file.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(line);
                writer.newLine();
        }
	}

	private static String[] readCSV(String inFile) throws IOException {
		
		File file = new File(inFile);
		
		if (!file.exists()) {
			throw new FileNotFoundException("Cannot find " + file.getAbsolutePath());
		}
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
				
		String line = reader.readLine();

		// An empty file gives null, which would blow up on split().
		if (line == null) {
			return new String[0];
		}
		
		reader.close();

		return line.split(",");
	}

}
