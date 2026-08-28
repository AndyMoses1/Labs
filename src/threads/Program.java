package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Program {

	private static final int THREAD_COUNT = 5;
	private static final int INCREMENTS_PER_THREAD = 10000;

	public static void main(String[] args) {
		Counter counter = new Counter();

		ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

		for (int i = 0; i < THREAD_COUNT; i++) {
			executor.submit(new Worker(counter));
		}

		executor.shutdown();

		try {
			executor.awaitTermination(30, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Tasks submitted: " + THREAD_COUNT);
		System.out.println("Expected total:  " + (THREAD_COUNT * INCREMENTS_PER_THREAD));
		System.out.println("Counter value:   " + counter.getValue());

		// ---------- previous version: threads created by hand ----------
		//
		// List<Thread> threads = new ArrayList<>();
		//
		// for (int i = 0; i < THREAD_COUNT; i++) {
		//     Thread thread = new Thread(new Worker(counter));
		//
		//     thread.start();
		//
		//     threads.add(thread);
		// }
		//
		// try {
		//     for (Thread thread : threads) {
		//         thread.join();
		//     }
		// } catch (InterruptedException e) {
		//     e.printStackTrace();
		// }
		//
		// System.out.println("Threads started: " + threads.size());
	}

}
