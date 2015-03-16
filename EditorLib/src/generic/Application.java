package generic;

import java.util.LinkedList;

public class Application {
	
	private Thread mainThread; 
	private Thread renderThread;
	private Thread drawerThread;
	private Thread audioSystemThread;
	private Thread networkThread;
	
	private LinkedList<Thread> existingThreads;
	
	public Application() {
		existingThreads = new LinkedList<Thread>();
	}
	
	public void setMain(TickingLoop PROGRAM_MAIN) {
		mainThread = new Thread(PROGRAM_MAIN);
		mainThread.setName("MAIN");
		mainThread.setPriority(Thread.MAX_PRIORITY);
		existingThreads.add(mainThread);
	}
	
	public void setRenderer(Runnable PROGRAM_RENDERER) {
		renderThread = new Thread(PROGRAM_RENDERER);
		renderThread.setName("RENDERER");
	
		existingThreads.add(renderThread);
	}
	
	public void setDrawer(Runnable DRAWER) {
		drawerThread = new Thread(DRAWER);
		drawerThread.setName("DRAWER");
		
		existingThreads.add(drawerThread);
	}
	
	public void setAudioSystem(Runnable PROGRAM_AUDIO_SYSTEM) {
		audioSystemThread = new Thread(PROGRAM_AUDIO_SYSTEM);
		audioSystemThread.setName("AUDIO_SYS");
		
		existingThreads.add(audioSystemThread);
	}
	
	public void setNetworkThread(Runnable NETWORK_THREAD) {
		networkThread = new Thread(NETWORK_THREAD);
		networkThread.setName("NETWORK");
		
		existingThreads.add(networkThread);
	}
	
	public void start() {
		for (Thread thread : existingThreads) {
			thread.start();
		}
	}
	
	public void startAudio() {
		startThread(audioSystemThread);
	}
	public void stopAudio() {
		stopThread(audioSystemThread);
	}
	
	public void startNetwork() {
		startThread(networkThread);
	}
	public void stopNetwork() {
		stopThread(networkThread);
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
