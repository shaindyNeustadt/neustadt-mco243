package neustadt.mco243.threads;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DownloadLotsOfImages {

	static int total = 0;

	public static void main(String[] args) throws IOException, InterruptedException {

		ExecutorService service = Executors.newFixedThreadPool(6);

		for (int i = 0; i < 10000; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					add();
				}
			};
			service.execute(runnable);
		}
		service.shutdown();
		service.awaitTermination(10, TimeUnit.SECONDS);
		System.out.print(total);
	}

	// a synchronized method ensures that only one thread can run this method a
	// time
	public synchronized static void add() {
		total++;
	}

}