package generic.timers;

final public class DebounceTimer {

	private double START_TIME_SEC;
	private double TIMER_LENGTH_SEC;
	private double COUNTDOWN_SEC;
	
	public DebounceTimer() {
		setDebounceTime__sec(0.25);
		reset();
	}
	
	public void setDebounceTime__sec(double seconds) { 
		TIMER_LENGTH_SEC = seconds;
	}
	
	public void reset() { 
		COUNTDOWN_SEC  = TIMER_LENGTH_SEC; 
		START_TIME_SEC = currentTime__sec();
	}
	
	public boolean isDebounceComplete() {
		updateCountdown();
		return COUNTDOWN_SEC >= TIMER_LENGTH_SEC;
	}
	
	private void updateCountdown() {
		COUNTDOWN_SEC = passedTimeSinceReset();
	}
	
	private double passedTimeSinceReset() {
		return currentTime__sec() - START_TIME_SEC;
	}
	
	private static double currentTime__sec() {
		return (System.currentTimeMillis() / 1000.0);
	}
	
}