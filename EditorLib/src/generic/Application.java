package generic;

import generic.datastructures.Table;

import java.util.LinkedList;

public class Application {
	
	private Table<Thread> threads;
	private LinkedList<Thread> threadsList;
	
	public Application() {
		threads = new Table<Thread>();
		threadsList = new LinkedList<Thread>();
	}
	
	public void setMain(TickingLoop PROGRAM_MAIN) {
		addComponent("MAIN", PROGRAM_MAIN);
		threads.get("MAIN").setPriority(Thread.MAX_PRIORITY);
	}
	
	public void addComponent(String name, Runnable runnableComponent) {
		Thread newThread = new Thread(runnableComponent);
		newThread.setName(name);
		threads.insert(name, newThread);
		threadsList.add(newThread);
	}
	
	public void start() {
		for (Thread thread : threadsList) {
			thread.start();
		}
	}
	
	public void startComponent(String name) {
		startThread(threads.get(name));
	}
	
	public void stopComponent(String name) {
		stopThread(threads.get(name));
	}
	
	private void startThread(Thread thread) {
		thread.notify();
	}
	
	private void stopThread(Thread thread) {
		try {
			thread.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
