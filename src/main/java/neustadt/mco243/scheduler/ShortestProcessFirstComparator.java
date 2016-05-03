package neustadt.mco243.scheduler;

import java.util.Comparator;

public class ShortestProcessFirstComparator implements Comparator<Job>{

	@Override
	public int compare(Job a, Job b) {
		return a.getTimeLeft().compareTo(b.getTimeLeft());
	}
}