package neustadt.mco243.deadlock;

import java.util.logging.Logger;

public class Philospher extends Thread {

	private static final Logger LOG = Logger.getLogger(Philospher.class.getName());
	Fork f1;
	Fork f2;
	private String name;
	Waiter waiter;

	public Philospher(String name, Fork f1, Fork f2, Waiter waiter) {
		this.name = name;
		this.f1 = f1;
		this.f2 = f2;
		this.waiter = waiter;
	}

	public void run() {
		while (true) {
			think();
			eat();
		}
	}

	private void eat() {
		LOG.info(this.toString() + " attempting to eat");
		if(waiter.tryToEat(f1, f2)){
			LOG.info(this.toString() + " Eating");
			waitForAFewSeconds();
			LOG.info(this.toString() + " done eating");
		}
		
		
		
		/*System.out.println(this + " trying to pick up " + f1);
		synchronized (f1) {
			System.out.println(this + " trying to pick up " + f2);
			synchronized (f2) {
				System.out.println(this + " EAT SPAGHETTI");
				waitForAFewSeconds();
			}
			System.out.println(this + " putting down fork " + f1);
		}
		System.out.println(this + " putting down fork " + f2);*/
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