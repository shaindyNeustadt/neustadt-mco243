package neustadt.mco243.scheduler;

public class Job {

	private Priority priority;
	private Priority dynamicPriority;
	private String name;
	private JobState state;
	private int timeLeft;
	private JobType jobType;

	private long lastRanAtTime;

	public Job(String name, Priority priority, int timeLeft, JobType jobType) {
		super();
		this.jobType = jobType;
		this.priority = priority;
		this.name = name;
		this.timeLeft = timeLeft;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Priority getDynamicPriority() {
		return dynamicPriority;
	}

	public void setDynamicPriority(Priority dynamicPriority) {
		this.dynamicPriority = dynamicPriority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JobState getState() {
		return state;
	}

	public void setState(JobState state) {
		this.state = state;
	}

	public int getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}

	public long getLastRanAtTime() {
		return lastRanAtTime;
	}

	public void setLastRanAtTime(long lastRanAtTime) {
		this.lastRanAtTime = lastRanAtTime;
	}

}