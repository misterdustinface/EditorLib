package UI.widgets;

import UI.input.MouseUserDevice;
import shapes.Rectangle;

public class BarSlider extends UIElement {

	enum ORIENTATION { VERTICAL, HORIZONTAL };
	private ORIENTATION orientation;
	
	private Rectangle base;
	private Rectangle fill;
	private float 	  fillPercent;
	
	public BarSlider() {
		super();	
		orientation   = ORIENTATION.VERTICAL;
		fillPercent   = 1.0f;
		base 		  = new Rectangle();
		fill          = new Rectangle();
	}
	
	final public void setBase(Rectangle bounding) { 
		base = bounding; 
		notifyChanged();
	}
	
	final public void setHorizontal() { 
		if (orientation != ORIENTATION.HORIZONTAL) notifyChanged();
		orientation = ORIENTATION.HORIZONTAL; 
	}
	
	final public void setVertical() { 
		if (orientation != ORIENTATION.VERTICAL) notifyChanged();
		orientation = ORIENTATION.VERTICAL; 
	}
	
	final public Rectangle getBase() { 
		return base; 
	}
	
	final public Rectangle getFill() { 
		return fill; 
	}
	
	final public void update(MouseUserDevice mouse) {
		
		updateSlider(mouse.getCursorX(), mouse.getCursorY());
		
		if (base.contains(mouse.getCursorX(), mouse.getCursorY())) {
			highlight();
			if (mouse.isPressed()  || mouse.isDragged()) press();
			if (mouse.isReleased() || mouse.isClicked()) release();
			mouse.intercept();
		} else {
			removeHighlight();
			release();
		}
	}
	
	private void updateSlider(float mouseX, float mouseY) {
		if (isPressed()) {
			switch(orientation) {
			case HORIZONTAL: setFillPercent(  ((mouseX - base.x)/base.width)  );
				break;
			case VERTICAL:   setFillPercent(1-((mouseY - base.y)/base.height) );
				break;
			}
		}
	}
	
	final public float getFillPercent() { 
		return fillPercent; 
	}
	
	final public void setFillPercent(float delta) {
		fillPercent = delta;
		if (fillPercent > 1.0f) { 
			fillPercent = 1.0f; 
		} else if (fillPercent < 0.0f) { 
			fillPercent = 0.0f; 
		}
		updateFillBounds();
		notifyChanged();
	}
	
	private void updateFillBounds() {
		switch(orientation) {
		case HORIZONTAL: fill.setBounds(base.x, base.y, (int)(base.width * fillPercent), base.height);
			break;
		case VERTICAL:   fill.setBounds(base.x, base.y+base.height, base.width, -(int)(base.height * fillPercent));
			break;
		}
	}

	protected void pressAction() {
		
	}

	protected void releaseAction() {

	}
	
}