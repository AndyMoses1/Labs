package lab7;

public class Program {

	public static void main(String[] args) {
		multiplicationTable();
	}

	public static void multiplicationTable() {
		for (int row = 1; row <= 10; row++) {

			for (int col = 1; col <= 10; col++) {
				System.out.printf("%5d", row * col);
			}

			System.out.println();
		}
	}

}
