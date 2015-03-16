package UI;

import generic.ListenerPattern.Descriptive.ChangeNotifier;

public abstract class UIElement extends ChangeNotifier implements UILayer {

	private boolean isPressed;
	private boolean isHighlighted;
	
	public UIElement() { 
		isPressed = isHighlighted = false; 
	}

	final public void press() { 
		if (!isPressed) notifyChanged();
		isPressed = true; 
		pressAction();
	}
	
	final public void release() { 
		if (isPressed) notifyChanged();
		isPressed = false; 
		releaseAction();
	}
	
	final public boolean isPressed() { 
		return isPressed; 
	}
	
	final public boolean isHighlighted() { 
		return isHighlighted; 
	}
	
	final protected void highlight() {
		if (!isHighlighted) notifyChanged();
		isHighlighted = true;
	}
	
	final protected void removeHighlight() { 
		if (isHighlighted) notifyChanged();
		isHighlighted = false; 
	}
	
	protected abstract void pressAction();
	protected abstract void releaseAction();
}
