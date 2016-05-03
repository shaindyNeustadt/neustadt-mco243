package neustadt.mco243.scheduler;

import java.util.ArrayList;

public class ShortestProcessFirstScheduler extends JobScheduler {

	public ShortestProcessFirstScheduler(ArrayList<Job> jobs) {
		super(jobs, new ShortestProcessFirstComparator());
	}

}