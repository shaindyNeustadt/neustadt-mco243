package neustadt.mco243.deadlock;

public class Philospher extends Thread {

	Fork f1;
	Fork f2;
	private String name;

	public Philospher(String name, Fork f1, Fork f2) {
		this.name = name;
		this.f1 = f1;
		this.f2 = f2;
	}

	public void run() {
		while (true) {
			think();
			eat();
		}
	}

	private void eat() {
		System.out.println(this + " trying to pick up " + f1);
		synchronized (f1) {
			System.out.println(this + " trying to pick up " + f2);
			synchronized (f2) {
				System.out.println(this + " EAT SPAGHETTI");
				waitForAFewSeconds();
			}
			System.out.println(this + " putting down fork " + f1);
		}
		System.out.println(this + " putting down fork " + f2);
	}

	private void waitForAFewSeconds() {
		try {
			Thread.sleep((long) (Math.random() * 10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void think() {
		waitForAFewSeconds();
	}
	
	public String toString(){
		return "PHILOSOPHER " + name;
	}

}