package generic;

import generic.datastructures.Table;

import java.util.LinkedList;

public class Application {
	
	final private Table<Thread> threads;
	final private LinkedList<String> names;
	
	public Application() {
		threads = new Table<Thread>();
		names = new LinkedList<String>();
	}
	
	public void setMain(TickingLoop PROGRAM_MAIN) {
		addComponent("MAIN", PROGRAM_MAIN);
		threads.get("MAIN").setPriority(Thread.MAX_PRIORITY);
	}
	
	public void addComponent(String name, Runnable runnableComponent) {
		names.add(name);
		Thread newThread = new Thread(runnableComponent);
		newThread.setName(name);
		threads.insert(name, newThread);
	}
	
	public void start() {
		for (String name : names) {
			startThread(threads.get(name));
		}
	}
	
	public void quit() {
		System.exit(0);
	}
	
	public void startComponent(String name) {
		startThread(threads.get(name));
	}
	
	public void stopComponent(String name) {
		stopThread(threads.get(name));
	}
	
	private void startThread(Thread thread) {
		if (!thread.isAlive()) {
			thread.start();
		} else {
			thread.notify();
		}
	}
	
	private void stopThread(Thread thread) {
		try {
			thread.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}