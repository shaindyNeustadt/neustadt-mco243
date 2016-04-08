package neustadt.mco243.deadlock;

//ask the Waiter before picking up a fork
public class Waiter {

	// attempt to pick up the forks
	// return true if successfully pick up forks otherwise false
	public synchronized boolean tryToEat(Fork a, Fork b) {
		if (!a.isInUse() && !b.isInUse()) {
			a.setInUse(true);
			b.setInUse(true);
			return true;
		}
		return false;
	}
}