package notifier;

public class MessageService {

	public static void main(String[] args) {
		demo1();
		demo2();
	}

	private static void demo1() {
		Notifier ns = new EmailNotifier();
		sendMessage("Hello", ns);

		ns = new SmsNotifier();
		sendMessage("Hello", ns);
	}

	private static void sendMessage(String msg, Notifier service) {
		service.send(msg);
	}

	private static void demo2() {
		NotificationHub hub = new NotificationHub();
		hub.register(new EmailNotifier());
		hub.register(new SmsNotifier());

		hub.notifyAll("Hello World!");
	}

}
