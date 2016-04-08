package neustadt.mco243.deadlock;

public class Fork {
	private int number;
	private boolean inUse;
	
	public Fork(int number){
		this.number = number;				
	}
	
	public String toString(){
		return String.valueOf(number);
	}

	public boolean isInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
}