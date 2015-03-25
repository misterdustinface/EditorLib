package UI.input;

import generic.datastructures.Queue;

public abstract class KeyboardUserDevice {

	final private Queue<String> keyqueue;
	
	public KeyboardUserDevice() {
		keyqueue = new Queue<String>();
	}
	
	public String consumeEvent() {
		return keyqueue.dequeue();
	}
	
	protected synchronized void createEvent(String keydata) {
		keyqueue.enqueue(keydata);
	}
	
}
