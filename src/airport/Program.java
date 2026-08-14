package airport;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Challenge: rates are held in float variables rather than being
		// hard-coded into the switch, so they can be changed in one place.
		float usdRate = 1.25f;
		float eurRate = 1.15f;
		float jpyRate = 180.50f;
		float chfRate = 1.12f;
		float audRate = 1.92f;

		String again;

		do {
			System.out.print("Amount in GBP: ");
			double amount = input.nextDouble();

			System.out.print("Currency (1=USD, 2=EUR, 3=JPY, 4=CHF, 5=AUD): ");
			int currencyChoice = input.nextInt();

			System.out.print("Customer type (R=Regular, V=VIP, S=Staff): ");
			char customerType = Character.toUpperCase(input.next().charAt(0));

			// Select the exchange rate for the chosen currency.
			float rate;
			String currencyCode;

			switch (currencyChoice) {
			case 1:
				rate = usdRate;
				currencyCode = "USD";
				break;
			case 2:
				rate = eurRate;
				currencyCode = "EUR";
				break;
			case 3:
				rate = jpyRate;
				currencyCode = "JPY";
				break;
			case 4:
				rate = chfRate;
				currencyCode = "CHF";
				break;
			case 5:
				rate = audRate;
				currencyCode = "AUD";
				break;
			default:
				rate = -1.0f;
				currencyCode = "?";
				break;
			}

			// Select the tax rate for the customer type.
			double taxRate;

			switch (customerType) {
			case 'R':
				taxRate = 0.10;
				break;
			case 'V':
				taxRate = 0.05;
				break;
			case 'S':
				taxRate = 0.0;
				break;
			default:
				taxRate = -1.0;
				break;
			}

			// A chained ternary picks the first problem found, or null if the
			// input is valid.
			String error = rate < 0 ? "Error: currency must be 1..5"
					: taxRate < 0 ? "Error: customer type must be R, V or S"
					: null;

			if (error != null) {
				System.out.println(error);
			} else {
				// The service fee depends on how much is being exchanged.
				double feeRate = amount < 100.0 ? 0.05 : 0.025;

				double serviceFee = amount * feeRate;
				double amountAfterFee = amount - serviceFee;

				double tax = amountAfterFee * taxRate;
				double amountAfterTax = amountAfterFee - tax;

				// float -> double, so the conversion runs in double precision.
				double converted = amountAfterTax * (double) rate;

				// double -> int drops the pennies, leaving whole units only.
				int wholeUnits = (int) converted;

				System.out.printf("Service fee (%.1f%%):       GBP %.2f%n", feeRate * 100, serviceFee);
				System.out.printf("Amount after service fee: GBP %.2f%n", amountAfterFee);
				System.out.printf("Airport tax (%.1f%%):       GBP %.2f%n", taxRate * 100, tax);
				System.out.printf("Amount after tax:         GBP %.2f%n", amountAfterTax);
				System.out.printf("Final amount:             %s %d%n", currencyCode, wholeUnits);
			}

			System.out.print("Another exchange? (Y/N): ");
			again = input.next();

		} while (again.equalsIgnoreCase("Y"));

		System.out.println("Thank you for using the kiosk.");
		input.close();
	}

}
