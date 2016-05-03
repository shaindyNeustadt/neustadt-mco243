package neustadt.mco243.scheduler;

import java.util.ArrayList;

public class DeadlineScheduler extends JobScheduler{

	public DeadlineScheduler(ArrayList<Job> jobs) {
		super(jobs, new DeadlineComparator());
	}

}
