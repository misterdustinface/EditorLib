package UI.input;

import generic.datastructures.Queue;

public abstract class UserDevice {
	
	final private Queue<InputEvent> inputEventQueue;
	final private InputEvent EMPTY_EVENT;
	
	public UserDevice() {
		inputEventQueue = new Queue<InputEvent>();
		EMPTY_EVENT = new InputEvent();
	}
	
	public synchronized InputEvent consumeEvent() {
		if (inputEventQueue.isEmpty()) {
			return EMPTY_EVENT;
		} else {
			return inputEventQueue.dequeue();
		}
	}
	
	protected void addEvent(InputEvent keydata) {
		inputEventQueue.enqueue(keydata);
	}
	
}