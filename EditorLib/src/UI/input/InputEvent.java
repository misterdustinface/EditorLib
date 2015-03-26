package UI.input;

import java.util.HashSet;

import generic.Reusable;

public class InputEvent implements Reusable {
	
	private HashSet<String> event;
	
	public InputEvent() {
		event = new HashSet<String>();
	}
	
	public boolean is(String element) {
		if (event == null) {
			return false;
		} else {
			return event.contains(element);
		}
	}

	public void reconstruct() {
		event.clear();
	}
	
	public String toString() {
		return event.toString();
	}
	
	protected void add(String element) {
		event.add(element);
	}
	
}