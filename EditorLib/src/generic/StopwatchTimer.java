package generic;

public class StopwatchTimer {
	private double START_TIME_SEC;
	
	public StopwatchTimer() { reset(); }
	
	public void reset()  { START_TIME_SEC = currentTimeSeconds(); }
	public double time() { return passedTimeSinceReset__sec(); }
	public long time__ms() {return (long) (passedTimeSinceReset__sec() * 1000); }
	
	private double passedTimeSinceReset__sec() {
		return currentTimeSeconds() - START_TIME_SEC;
	}
	
	private static double currentTimeSeconds() {
		return (System.currentTimeMillis() / 1000.0);
	}
}
