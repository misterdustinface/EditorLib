package UI.input;

import shapes.Point;

//extends UserDevice
public abstract class MouseUserDevice {
	
	protected Point cursorPosition;
	private enum MOUSE_STATE { PRESSED, RELEASED, CLICKED, DRAGGED, MOVED, NONE };
	private MOUSE_STATE state = MOUSE_STATE.NONE;
	private String button;
	final public static String LEFT = "LEFT";
	final public static String MIDDLE = "MIDDLE";
	final public static String RIGHT = "RIGHT";
	final public static String NO_BUTTON = "NONE";
	
	public MouseUserDevice() {
		cursorPosition = new Point(0,0);
		button = NO_BUTTON;
	}
	
	public Point getCursorPosition() {
		return cursorPosition.copy();
	}
	
	public float getCursorX() {
		return cursorPosition.x;
	}
	
	public float getCursorY() {
		return cursorPosition.y;
	}
	
	final public boolean isIntercepted() { 
		return state == MOUSE_STATE.NONE; 
	}
	
	final public boolean isClicked() { 
		return state == MOUSE_STATE.CLICKED;  
	}
	
	final public boolean isPressed() { 
		return state == MOUSE_STATE.PRESSED;  
	}
	
	final public boolean isReleased() { 
		return state == MOUSE_STATE.RELEASED; 
	}
	
	final public boolean isDragged() { 
		return state == MOUSE_STATE.DRAGGED;  
	}
	
	final public boolean isMoved() { 
		return state == MOUSE_STATE.MOVED;    
	}
	
	final public void intercept() { 
		state = MOUSE_STATE.NONE;
	}
	
	final protected void click() { 
		state = MOUSE_STATE.CLICKED;  
	}
	
	final protected void press() { 
		state = MOUSE_STATE.PRESSED;  
	}
	
	final protected void release() { 
		state = MOUSE_STATE.RELEASED; 
	}
	
	final protected void drag() { 
		state = MOUSE_STATE.DRAGGED;  
	}
	
	final protected void move() { 
		state = MOUSE_STATE.MOVED;    
	}
	
	final public boolean isButton(String button) {
		return this.button == button;
	}
	
	final public void setButton(String button) {
//		InputEvent buttonEvent = InputEventBuilder.createWithDescription("MOUSE", button);
//		addEvent(buttonEvent);
		this.button = button;
	}

}