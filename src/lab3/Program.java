package lab3;

public class Program {

	public static void main(String[] args) {
		//declared here and passed into methods DRY
		
		
		//part 3 lbs
		//int totalPounds = getInt("What is the total weight in pounds (lbs)? ");
		
		//convertInputToStonesPouunds(totalPounds);
		
		//kgs
		//int totalKgs = getInt("What is the total weight in kilograms (kgs)? ");
		
		//convertKgsToStonesPounds(totalKgs);
		
		//part 2
		theLunchQueue();

		// Part 1 test - uncomment to check getInt/getString on their own
		//int age = getInt("Enter your age: ");
		//String name = getString("Enter your name: ");

		//System.out.println("age  = " + age);
		//System.out.println("name = " + name);
	}

	

	//part 2
	public static void theLunchQueue() {
		Utils utils = new Utils();
		
		String mainCourse = utils.getString("What main dish would you like(Fish, Burgers or veg) ? ");
		int roastPotatoes = utils.getInt("How many roast potatoes would you like? ");
		int brusselSprouts = utils.getInt("How many Brussel Sprouts would you like? ");

//		System.out.println("Hello, your lunch is " + mainCourse + " with " + roastPotatoes
//				+ " roast potatoes and " + brusselSprouts + " Brussel sprouts.");
		String message = String.format("Hello, your lunch is %s with %d roast potatoes and %d Brussel sprouts.", mainCourse, roastPotatoes, brusselSprouts);
		System.out.println(message);
		
	}
	
	//part 3
	static void convertInputToStonesPouunds(int totalPounds) {
		int stones = totalPounds / 14;
		int pounds = totalPounds % 14;
		
		String output = String.format("The weight is: %d stone and %d pounds.", stones, pounds);
		System.out.println(output);
		
	}
	
	static void convertKgsToStonesPounds(int totalKgs) {
		int totalPounds = (int) (totalKgs * 2.20462);
		
		convertInputToStonesPouunds(totalPounds);
	}

}


// 1st pass on part 1
//public class Program {
//
//	public static void main(String[] args) {
//		int age = getInt("Enter your age: ");
//		String name = getString("Enter your name: ");
//
//		System.out.println("age  = " + age);
//		System.out.println("name = " + name);
//	}
//
//	public static int getInt(String prompt) {
//		System.out.print(prompt);
//		Scanner s = new Scanner(System.in);
//		return s.nextInt();
//	}
//
//	public static String getString(String prompt) {
//		System.out.print(prompt);
//		Scanner s = new Scanner(System.in);
//		return s.nextLine();
//	}
//
//}

//before part 4 extraction
	//public static void main(String[] args) {
	//	//declared here and passed into methods DRY
	//	
	//	
	//	//part 3 lbs
	//	//int totalPounds = getInt("What is the total weight in pounds (lbs)? ");
	//	
	//	//convertInputToStonesPouunds(totalPounds);
	//	
	//	//kgs
	//	int totalKgs = getInt("What is the total weight in kilograms (kgs)? ");
	//	
	//	convertKgsToStonesPounds(totalKgs);
	//	
	//	//part 2
	//	//theLunchQueue();
	//
	//	// Part 1 test - uncomment to check getInt/getString on their own
	//	//int age = getInt("Enter your age: ");
	//	//String name = getString("Enter your name: ");
	//
	//	//System.out.println("age  = " + age);
	//	//System.out.println("name = " + name);
	//}
	//
	//public static int getInt(String prompt) {
	//	Scanner input = new Scanner(System.in);
	//	System.out.print(prompt);
	//	int value = input.nextInt();
	//	input.nextLine();
	//	return value;
	//}
	//
	//public static String getString(String prompt) {
	//	Scanner input = new Scanner(System.in);
	//	System.out.print(prompt);
	//	String value = input.nextLine();
	//	return value;
	//}
	//
	////part 2
	//public static void theLunchQueue() {
	//	String mainCourse = getString("What main dish would you like(Fish, Burgers or veg) ? ");
	//	int roastPotatoes = getInt("How many roast potatoes would you like? ");
	//	int brusselSprouts = getInt("How many Brussel Sprouts would you like? ");
	//
	////	System.out.println("Hello, your lunch is " + mainCourse + " with " + roastPotatoes
	////			+ " roast potatoes and " + brusselSprouts + " Brussel sprouts.");
	//	String message = String.format("Hello, your lunch is %s with %d roast potatoes and %d Brussel sprouts.", mainCourse, roastPotatoes, brusselSprouts);
	//	System.out.println(message);
	//	
	//}
	//
	////part 3
	//static void convertInputToStonesPouunds(int totalPounds) {
	//	int stones = totalPounds / 14;
	//	int pounds = totalPounds % 14;
	//	
	//	String output = String.format("The weight is: %d stone and %d pounds.", stones, pounds);
	//	System.out.println(output);
	//	
	//}
	//
	//static void convertKgsToStonesPounds(int totalKgs) {
	//	int totalPounds = (int) (totalKgs * 2.20462);
	//	
	//	convertInputToStonesPouunds(totalPounds);
	//}
	//
	//}