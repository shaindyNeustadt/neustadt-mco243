package neustadt.mco243.scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RoundRobbinScheduler extends JobScheduler{
	private int timeSliceLeft = TIME_SLICE;

	public RoundRobbinScheduler(ArrayList<Job> jobs) {
		super(jobs, new FifoJobComparator());
	}
	
	@Override
	public int executeJob(Job job) {
		job.setState(JobState.Running);
		job.setLastRanAtTime(System.currentTimeMillis());
		int timeLeftToRun = job.getTimeLeft();
		int actualTimeSlice = computeActualTimeSlice(job, timeLeftToRun);
		timeLeftToRun -= actualTimeSlice;

		job.setTimeLeft(timeLeftToRun);
		timeSliceLeft -= actualTimeSlice;
		
		if(timeLeftToRun == 0){
			jobs.remove(0);
			numJobsCompleted++;
			timeSliceLeft = TIME_SLICE;
		}
		else if (timeSliceLeft <= 0) {
			jobs.remove(0);
			jobs.add(job);
			timeSliceLeft = TIME_SLICE;
		} else {
			job.setState(JobState.Ready);
		}
		return actualTimeSlice;
	}
	
	public static void main(String[] args) {
		List<Job> jobs = Arrays.asList(

				new Job("1", Priority.High, 50, JobType.Computation, 5L),
				new Job("2", Priority.Low, 90, JobType.IO, 45L),
				new Job("3",Priority.High, 10, JobType.Computation, 3L), 
				new Job("4", Priority.Medium, 100, JobType.Computation, 1L),
				new Job("5", Priority.Medium, 20, JobType.IO, 67L),
				new Job("6", Priority.Low, 100, JobType.Computation, 103L),
				new Job("7", Priority.Low, 10, JobType.IO, 23L), 
				new Job("8", Priority.High, 40, JobType.Computation, 44L),
				new Job("9", Priority.High, 50, JobType.Computation, 51L), 
				new Job("10", Priority.Low, 60, JobType.IO, 18L),
				new Job("11", Priority.Medium, 80, JobType.Computation, 70L), 
				new Job("12", Priority.High, 70, JobType.IO, 49L));

		SelfishRoundRobbinScheduler scheduler = new SelfishRoundRobbinScheduler(
				new ArrayList<Job>(jobs));
		scheduler.run();

		System.out.println("Selfish Round Robbin Scheduler NUM JOBS COMPLETED " + numJobsCompleted
				+ " TOTAL TIME " + totalTime);

	}
}