package oop_lab_2;

public class ReferenceTypes {

	public static void main(String[] args) {
		Account account = new Account(1001, "Andy Moses", 500.00);

		System.out.println(account.getDetails());

		account.deposit(250.00);
		account.withdraw(100.00);

		System.out.println(account.getDetails());

		account.deposit(-50.00);
		account.withdraw(10000.00);

		System.out.println(account.getDetails());
	}

}
