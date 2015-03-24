package generic;

import generic.fp.VoidFunctionPointer;
import generic.timers.StopwatchTimer;

import java.util.LinkedList;

public class TickingLoop implements Runnable {

	private LinkedList<VoidFunctionPointer> functions;
	private long millisAllowedPerUpdate = 1000 / 60;
	private StopwatchTimer iterationStopwatch;
	
	public TickingLoop() {
		iterationStopwatch = new StopwatchTimer();
		functions = new LinkedList<VoidFunctionPointer>();
	}
	
	public void setUpdatesPerSecond(int UPS) {
		millisAllowedPerUpdate = 1000 / UPS;
	}

	public void addFunction(VoidFunctionPointer function) {
		functions.add(function);
	}
	
	@Override
	public void run() {
		for (;;) {
			iterationStopwatch.reset();
			executeAllSpecifiedFunctions();
			sleep();
		}
	}
	
	private void executeAllSpecifiedFunctions() {
		for (VoidFunctionPointer function : functions) {
			function.call();
		}
	}
	
	private void sleep() {
		try {
			Thread.sleep(millisAllowedPerUpdate - iterationStopwatch.time__ms());
		} catch (InterruptedException e) {
			
		} catch (IllegalArgumentException e) {
			
		}
	}
}

