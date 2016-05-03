package neustadt.mco243.scheduler;

import java.util.ArrayList;
import java.util.Collections;

public class SelfishRoundRobbinScheduler extends RoundRobbinScheduler {
	private ArrayList<Job> holdingQueue;

	public SelfishRoundRobbinScheduler(ArrayList<Job> jobs) {
		super(new ArrayList<Job>());
		holdingQueue = jobs;
		moveToActiveQueue();
	}

	@Override
	public void run() {
		Job lastJob = null;

		while (!jobs.isEmpty() || !holdingQueue.isEmpty()) {
			moveToActiveQueue();
			incrementWaitingQueue();

			if (!jobs.isEmpty()) {
				Collections.sort(jobs, comparator);
				Job job = jobs.get(0);

				int actualTimeSlice = executeJob(job);

				totalTime += actualTimeSlice;

				if (job != lastJob) {
					totalTime += OVERHEAD;
					lastJob = job;
				}
			}
		}
	}

	private void incrementWaitingQueue() {
		for (Job j : holdingQueue) {
			int nextOrdinal = j.getPriority().ordinal() + 1;
			if (nextOrdinal < Priority.values().length) {
				j.setPriority(Priority.values()[nextOrdinal]);
			}
		}
	}

	private void moveToActiveQueue() {
		for (int i = 0; i < holdingQueue.size(); i++) {
			if (holdingQueue.get(i).getPriority().equals(Priority.RealTime)) {
				Job j = holdingQueue.remove(i);
				jobs.add(j);
			}
		}
	}
}