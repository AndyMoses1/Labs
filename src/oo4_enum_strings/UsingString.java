package oo4_enum_strings;

public class UsingString {

	public static void main(String[] args) {
		part2();
		part3();
	}

	private static void part2() {
		// 1. A first name longer than three characters.
		String name = "Andrew";

		// 2. 3rd char = index of 2
		System.out.println("Third character:   " + name.charAt(2));

		// 3. Both return NEW Strings - "name" itself is never changed.
		System.out.println("Lowercase:         " + name.toLowerCase());
		System.out.println("Uppercase:         " + name.toUpperCase());

		// 4. Tab separated, then a single line feed once the loop has finished.
		for (char letter : name.toCharArray()) {
			System.out.print(letter + "\t");
		}

		System.out.println();

		// 5 and 6.
		System.out.println("Starts with \"And\": " + name.startsWith("And"));
		System.out.println("Ends with \"rew\":   " + name.endsWith("rew"));

		// 7. indexOf returns -1 if not found
		System.out.println("Index of 'd':      " + name.indexOf('d'));
		System.out.println("Index of 'z':      " + name.indexOf('z'));

		// 8.
		String surname = "Moses";
		String fullname = name + " " + surname;

		System.out.println("Full name:         " + fullname);
	}

	private static void part3() {
		System.out.println();
		// 1
		StringBuilder sb = new StringBuilder("The Darkness ");

		// 2
		sb.append("is the band ever");

		// 3. The strange sentence.
		System.out.println(sb.toString());

		// 4.
		int bandPos = sb.indexOf("band");
		sb.insert(bandPos, "greatest ");

		System.out.println(sb.toString());

		// 5.
		bandPos = sb.indexOf("band");
		sb.replace(bandPos, bandPos + "band".length(), "rock band");

		System.out.println(sb.toString());
	}

}
