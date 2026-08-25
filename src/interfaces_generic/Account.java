package interfaces_generic;

import java.util.ArrayList;
import java.util.Comparator;

public class Account implements Comparable<Account>, Comparator<Account>{
	int id;
	double balance;
	String owner;

	Account(int id, double balance, String owner) {
		this.id = id;
		this.balance = balance;
		this.owner = owner;
	}

	void withdraw(double amount) {
		if (balance - amount < 0) {
			throw new IllegalArgumentException(String.format("cannot withdraw %.2f - the balance is only %.2f", amount, balance));
		}

		balance -= amount;
	}

	void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException(String.format("cannot deposit 0 or less than 0 amount"));
		}
		balance += amount;
	}

	void close() {
		System.out.printf("Account %d is closed%n", id);
	}

	String getDetails() {
		return String.format("Account %d | owner %s | balance %.2f", id, owner, balance);
	}

	@Override
	public int compareTo(Account other) {
		return (int) (this.balance - other.balance);
		//return this.owner.compareToIgnoreCase(other.owner);
	}

	@Override
	public int compare(Account o1, Account o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
