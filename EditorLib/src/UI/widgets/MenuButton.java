package UI.widgets;

import generic.timers.DebounceTimer;
import shapes.Polygon;
import shapes.Rectangle;
import UI.input.MouseUserDevice;

public class MenuButton extends FunctionButton {

	private Polygon polygon;
	private TextLabel textLabel;
	private DebounceTimer debounceTimer;
	
	public MenuButton() {
		super();
		polygon = new Polygon(4);
		textLabel = new TextLabel();
		debounceTimer = new DebounceTimer();
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
		
		textLabel.alignText(polygon);
	}
	
	final public void debouncedPress() {
		if (debounceTimer.isDebounceComplete()) {
			debounceTimer.reset();
			press();
		}
	}
	
	public void setPolygon(Polygon POLY) {
		polygon.clearPoints();
		for (int i = 0; i < POLY.getNumberOfPoints(); ++i) {
			polygon.addPoint(POLY.xpoints[i], POLY.ypoints[i]);
		}
		textLabel.alignText(polygon);
	}
	
	public void setPosition(float x, float y) {
		polygon.shift(x - polygon.xpoints[0], y - polygon.ypoints[0]);
	}
	
	public void setCenterPosition(float x, float y) {
		polygon.setCenterPosition(x, y);
	}
	
	public void shift(float xOffset, float yOffset) {
		polygon.shift(xOffset, yOffset);
	}
	
	public Rectangle getBoundingRectangle() {
		return polygon.getBoundingRectangle();
	}
	
	public void setDebounceTime__sec(long time__sec) {
		debounceTimer.setDebounceTime__sec(time__sec);
	}
	
	public void setText(String text) {
		textLabel.setText(text);
		textLabel.center();
	}
	
	/**
	 * To be used by a MenuDrawer
	 */
	public Polygon getPolygon() {
		return polygon;
	}
	
	/**
	 * To be used by a MenuDrawer
	 */
	public TextLabel getTextLabel() {
		return textLabel;
	}
	
	private boolean contains(MouseUserDevice mouse) {
		return polygon.contains(mouse.getCursorX(), mouse.getCursorY());
	}

}