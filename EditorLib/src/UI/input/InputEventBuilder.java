package UI.input;

import generic.tags.Library;

final public class InputEventBuilder implements Library {
	
	private InputEventBuilder() {
		
	}
	
	public static InputEvent create() {
		return new InputEvent();
	}
	
	public static InputEvent createWithDescription(String ... description) {
		InputEvent event = new InputEvent();
		event.add(description);
		return event;
	}
	
	public static void press(InputEvent event) {
		event.add("PRESSED");
	}
	
	public static void release(InputEvent event) {
		event.add("RELEASED");
	}
	
	public static void hold(InputEvent event) {
		event.add("HELD");
	}
	
	final private static String NUMERIC_EXPRESSION_PREFIX = "#";
	final private static String CHANGE_OF = "d";
	final private static String[] COORDINATE = {"X:", "Y:", "Z:"};
	final private static String PINCHSPACE = "P:";
	final private static String EXPANDSPACE = "E:";
	
	public static void touch(InputEvent event, float ... location) {
		event.add("TOUCHED");
		addLocation(event, location);
	}
	
	public static void drag(InputEvent event, float ... deltaLocation) {
		event.add("DRAGGED");
		addDeltaLocation(event, deltaLocation);
	}
	
	public static void move(InputEvent event, float ... location) {
		event.add("MOVED");
		addLocation(event, location);
	}
	
	public static void swipe(InputEvent event, float ... deltaLocation) {
		event.add("SWIPED");
		addDeltaLocation(event, deltaLocation);
	}
	
	public static void pinch(InputEvent event, float deltaAmount, float ... location) {
		event.add("PINCHED");
		event.add(NUMERIC_EXPRESSION_PREFIX + CHANGE_OF + PINCHSPACE + deltaAmount);
		addLocation(event, location);
	}
	
	public static void expand(InputEvent event, float deltaAmount, float ... location) {
		event.add("EXPANDED");
		event.add(NUMERIC_EXPRESSION_PREFIX + CHANGE_OF + EXPANDSPACE + deltaAmount);
		addLocation(event, location);
	}
	
	private static void addLocation(InputEvent event, float ... location) {
		for (int i = 0; i < location.length; ++i) {
			event.add(NUMERIC_EXPRESSION_PREFIX + COORDINATE[i] + location[i]);
		}
	}
	
	private static void addDeltaLocation(InputEvent event, float ... deltaLocation) {
		for (int i = 0; i < deltaLocation.length; ++i) {
			event.add(NUMERIC_EXPRESSION_PREFIX + CHANGE_OF + COORDINATE[i] + deltaLocation[i]);
		}
	}
	
}