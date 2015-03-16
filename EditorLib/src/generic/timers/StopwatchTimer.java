package generic.timers;

public class StopwatchTimer {
	
	private long START_TIME_MS;
	
	public StopwatchTimer() { 
		reset(); 
	}
	
	public void reset() { 
		START_TIME_MS = System.currentTimeMillis();
	}
	
	public double time() { 
		return passedTimeSinceReset__sec(); 
	}
	
	public long time__ms() { 
		return passedTimeSinceReset__ms(); 
	}

	private double passedTimeSinceReset__sec() {
		return passedTimeSinceReset__ms() / 1000d;
	}
	
	private long passedTimeSinceReset__ms() {
		return System.currentTimeMillis() - START_TIME_MS;
	}

}