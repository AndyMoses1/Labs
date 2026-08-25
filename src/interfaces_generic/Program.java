package interfaces_generic;

import java.util.ArrayList;
import java.util.Collections;

public class Program {

	public static void main(String[] args) {
		ArrayList<Account> accounts = new ArrayList<>();

		accounts.add(new Account(100, 1000, "Bob"));
		accounts.add(new Account(500, 3000, "Linda"));
		accounts.add(new Account(300, 2000, "David"));
		accounts.add(new Account(800, 10000, "David"));

		// Sort by owner. The lambda's own parameters are acc1 and acc2.
		Collections.sort(accounts, (acc1, acc2) -> acc1.owner.compareToIgnoreCase(acc2.owner));

		System.out.println("Sorted by owner:");
		printAccounts(accounts);

		Collections.sort(accounts, (acc1, acc2) -> Double.compare(acc1.balance, acc2.balance));

		System.out.println();
		System.out.println("Sorted by balance:");
		printAccounts(accounts);
	}

	private static void printAccounts(ArrayList<Account> accounts) {
		for (Account account : accounts) {
			System.out.println(account.getDetails());
		}
	}

}
