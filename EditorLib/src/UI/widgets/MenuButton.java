package UI.widgets;

import UI.input.MouseUserDevice;
import shapes.Point;
import shapes.Polygon;
import generic.timers.DebounceTimer;

public class MenuButton extends FunctionButton {

	public TextLabel 	 textLabel;
	public Polygon   	 polygon;
	public DebounceTimer debounceTimer;
	
	public MenuButton() {
		super();
		polygon = new Polygon(4);
		textLabel = new TextLabel();
		debounceTimer = new DebounceTimer();
	}
	
	public void setPolygon(Polygon POLY) {
		polygon.clearPoints();
		for (int i = 0; i < POLY.getNumberOfPoints(); ++i) {
			polygon.addPoint(POLY.xpoints[i], POLY.ypoints[i]);
		}
		textLabel.alignText(polygon);
	}
	
	public void setPosition(Point position) {
		polygon.shift(position.x - polygon.xpoints[0], position.y - polygon.ypoints[0]);
	}
	
	public void setCenterPosition(Point position) {
		polygon.setCenterPosition(position.x, position.y);
	}
	
	public void shift(float xOffset, float yOffset) {
		polygon.shift(xOffset, yOffset);
	}
	
	public float getWidth() { 
		return polygon.getBoundingRectangle().width;  
	}
	
	public float getHeight() { 
		return polygon.getBoundingRectangle().height; 
	}
	
	public float getCenterX() { 
		return polygon.getBoundingRectangle().getCenterX(); 
	}
	
	public float getCenterY() { 
		return polygon.getBoundingRectangle().getCenterY(); 
	}
	
	public void update(MouseUserDevice mouse) {
		if (contains(mouse)) {
			highlight();
			if (mouse.isPressed()  || mouse.isClicked()) debouncedPress();
			if (mouse.isReleased() || mouse.isClicked()) release();
			if (mouse.isPressed()  || mouse.isClicked()) mouse.intercept();
		} else {
			removeHighlight();
			if (isPressed()) release();
		}
		
		if (textLabel.isCentered()) textLabel.alignText(polygon);
	}
	
	private boolean contains(MouseUserDevice mouse) {
		return polygon.contains(mouse.getCursorX(), mouse.getCursorY());
	}
	
	final public void debouncedPress() {
		synchronized(this) {
			if (debounceTimer.isDebounceComplete()) {
				debounceTimer.reset();
				press();
			}
		}
	}

}