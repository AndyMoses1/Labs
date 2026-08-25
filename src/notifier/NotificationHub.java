package notifier;

import java.util.ArrayList;

public class NotificationHub {
	private ArrayList<Notifier> notifiers = new ArrayList<>();

	public void register(Notifier n) {
		notifiers.add(n);
	}

	public void notifyAll(String message) {
		for (Notifier n : notifiers) {
			System.out.println("Sending via: " + n.getClass().getName());
			n.send(message);
		}
	}

}
