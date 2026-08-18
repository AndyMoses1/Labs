package oop_lab_2;

public class Account {

	private int id;
	private String owner;
	private double balance;

	public Account(int id, String owner, double startingBalance) {
		// "this." separates the field from the parameter of the same name.
		this.id = id;
		this.owner = owner;
		this.balance = startingBalance;
	}

	public void deposit(double amount) {
		if (amount < 0) {
			System.out.println("Error: cannot deposit a negative amount.");
			return;
		}

		balance = balance + amount;
	}

	public void withdraw(double amount) {
		if (amount < 0) {
			System.out.println("Error: cannot withdraw a negative amount.");
			return;
		}

		if (amount > balance) {
			System.out.printf("Error: cannot withdraw %.2f - the balance is only %.2f.%n", amount, balance);
			return;
		}

		balance = balance - amount;
	}

	public String getDetails() {
		return String.format("Account %d | %s | balance %.2f", id, owner, balance);
	}

}
