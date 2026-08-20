package exceptions;

public class Program {

	public static void main(String[] args) {
		Account account = new Account(123, 100.00, "Andrew Moses");

		try {
			account.withdraw(50.00);
			System.out.println(account.getDetails());

			//account.deposit(0);
			account.withdraw(60.00);

			System.out.println(account.getDetails());

		} catch (IllegalArgumentException e) {
			System.out.println("Sorry, that withdrawal was refused: " + e.getMessage());
			System.out.println(account.getDetails());

		} finally {

			account.close();
		}
	}

}
