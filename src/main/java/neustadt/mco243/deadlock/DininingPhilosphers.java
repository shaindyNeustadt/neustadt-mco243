package neustadt.mco243.deadlock;

public class DininingPhilosphers {

	public static void main(String[] args) {
		Fork f1 = new Fork(1);
		Fork f2 = new Fork(2);
		Fork f3 = new Fork(3);
		Fork f4 = new Fork(4);
		Fork f5 = new Fork(5);

		Philospher a = new Philospher("Aristotle", f1, f2);
		Philospher b = new Philospher("Plato", f2, f3);
		Philospher c = new Philospher("Socrates", f3, f4);
		Philospher d = new Philospher("Confusious", f4, f5);
		Philospher e = new Philospher("Locke", f5, f1);

		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
}