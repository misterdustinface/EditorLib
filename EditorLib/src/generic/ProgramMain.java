package generic;

import java.util.LinkedList;

import generic.StopwatchTimer;

public class ProgramMain implements Runnable {

	private LinkedList<VoidFunctionPointer> functions;
	private long millisAllowedPerUpdate = 1000 / 60;
	private StopwatchTimer iterationStopwatch;
	
	public ProgramMain() {
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
		for(;;) {
			iterationStopwatch.reset();
			
			executeAllSpecifiedFunctions();
			
			try {
				Thread.sleep(millisAllowedPerUpdate - iterationStopwatch.time__ms());
			} catch (Exception e) {}
		}
	}
	
	private void executeAllSpecifiedFunctions() {
		for(VoidFunctionPointer function : functions) {
			function.call();
		}
	}
}

