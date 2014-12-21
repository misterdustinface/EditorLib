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
	
	public void setRenderer() {
		renderThread = new Thread();
		renderThread.setName("RENDERER");
	
		existingThreads.add(renderThread);
	}
	
	public void setAudioSystem() {
		audioSystemThread = new Thread();
		audioSystemThread.setName("AUDIO_SYS");
		
		existingThreads.add(audioSystemThread);
	}
	
	public void start() {
		for(Thread activeThread : existingThreads) {
			activeThread.start();
		}
	}
	
}
