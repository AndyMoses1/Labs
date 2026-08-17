package lab6;

public class Program {

	public static void main(String[] args) {
		account();
	}

	public static void account() {
		double initialMoney = 100.0;
		double targetMoney = 200.0;
		double interestRate = 1.05;

		int years = calculateYears(initialMoney, targetMoney, interestRate);

		displayResult(years, initialMoney, targetMoney);
	}

	private static int calculateYears(double initialMoney, double targetMoney, double interestRate) {
		double currentMoney = initialMoney;
		int years = 0;

		while (currentMoney < targetMoney) {
			currentMoney *= interestRate;
			years++;
		}

		return years;
	}

	private static void displayResult(int years, double initialMoney, double targetMoney) {
		System.out.printf("It takes %d years for %.2f to reach %.2f%n",
				years, initialMoney, targetMoney);
	}

}
