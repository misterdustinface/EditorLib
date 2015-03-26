package UI.input;

import generic.tags.Library;

final public class InputEventBuilder implements Library {
	
	private InputEventBuilder() {
		
	}
	
	public static void press(InputEvent event) {
		event.add("TOUCHED");
		event.add("PRESSED");
	}
	
	public static void release(InputEvent event) {
		event.add("RELEASED");
	}
	
	public static void hold(InputEvent event) {
		event.add("HELD");
	}
	
	public static void touch(InputEvent event) {
		event.add("TOUCHED");
		event.add("PRESSED");
	}
	
	public static void add(InputEvent event, String element) {
		event.add(element);
	}
	
}