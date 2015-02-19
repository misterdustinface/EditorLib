package devices;


public abstract class UserDeviceButton {
	
	private enum BUTTON_STATE { PRESSED, RELEASED, CLICKED, DRAGGED, MOVED, NONE };
	private BUTTON_STATE state;
	
	public UserDeviceButton() {
		state = BUTTON_STATE.NONE;
	}
	
	final public boolean isClicked() { 
		return state == BUTTON_STATE.CLICKED;
	}
	final public boolean isPressed() { 
		return state == BUTTON_STATE.PRESSED;  
	}
	final public boolean isReleased() { 
		return state == BUTTON_STATE.RELEASED; 
	}
	
	final public void intercept() { 
		state = BUTTON_STATE.NONE; 
	}
	
	final protected void click() { 
		state = BUTTON_STATE.CLICKED;  
	}
	final protected void press() { 
		state = BUTTON_STATE.PRESSED;  
	}
	final protected void release() { 
		state = BUTTON_STATE.RELEASED; 
	}
}
