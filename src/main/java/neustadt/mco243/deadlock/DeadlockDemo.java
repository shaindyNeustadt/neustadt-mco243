package neustadt.mco243.deadlock;

public class DeadlockDemo {

	public synchronized static void neverReturn() {
		// it is always sleeping
		try {
			Thread.sleep(10000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized static void notGoingToHappen() {
		System.out.println("Never prints");
	}

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				DeadlockDemo.neverReturn();
			}
		}.start();
	}
}