package UI.input;

import java.util.HashSet;

import base.Reusable;

public class InputEvent implements Reusable {
	
	private HashSet<String> event;
	
	protected InputEvent() {
		event = new HashSet<String>();
	}
	
	public boolean is(String element) {
		return event.contains(element);
	}
	
	public boolean isRelatedTo(String subElement) {
		for (String element : event) {
			if (element.contains(subElement)) {
				return true;
			}
		}
		return false;
	}
	
	public String getRelation(String subElement) {
		for (String element : event) {
			if (element.contains(subElement)) {
				return element;
			}
		}
		return null;
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
	
	protected void add(String ... elements) {
		for (String element : elements)
			add(element);
	}
	
}