package generic;

import java.util.LinkedList;

public class EditorProgram {
	
	private Thread mainThread; 
	private Thread renderThread;
	private Thread audioSystemThread;
	
	private LinkedList<Thread> existingThreads;
	
	public EditorProgram() {
		existingThreads = new LinkedList<Thread>();
	}
	
	public void setMain(ProgramMain PROGRAM_MAIN) {
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
	
	public void setAudioSystem(Runnable PROGRAM_AUDIO_SYSTEM) {
		audioSystemThread = new Thread(PROGRAM_AUDIO_SYSTEM);
		audioSystemThread.setName("AUDIO_SYS");
		
		existingThreads.add(audioSystemThread);
	}
	
	public void start() {
		for(Thread thread : existingThreads) {
			thread.start();
		}
	}
	
	public void stopAudio() {
		try {
			audioSystemThread.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void startAudio() {
		audioSystemThread.notify();
	}
}
