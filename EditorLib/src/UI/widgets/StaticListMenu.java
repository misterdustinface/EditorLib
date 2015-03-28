package UI.widgets;

import shapes.Polygon;
import shapes.PolygonBuilder;
import UI.input.MouseUserDevice;


public class StaticListMenu extends UIMenu {
	
	public StaticListMenu() {
		super();
		buttonOffset = 20;
		buttonWidth  = 80;
		buttonHeight = 40;
		width = height = 140;
	}
	
	protected void resetMenuDimensions() {
		width  = getSuggestedDimension(buttonOffset, buttonWidth,  1);
		height = getSuggestedDimension(buttonOffset, buttonHeight, buttons.size());
	}
	
	public void refreshButton(int index) {
		Polygon p = PolygonBuilder.makeBox(buttonWidth, buttonHeight);
		p.shift((int)position.x + buttonOffset, (int)position.y + getYOffset(index));
		getButton(index).setPolygon(p);
	}
	
	protected int getYOffset(int buttonIndex) {	
		return (((buttonIndex+1) * buttonOffset) + ((buttonIndex) * buttonHeight));
	}
	
	public void update(MouseUserDevice mouse) {
		if (contains(mouse)) {
			for (MenuButton button : buttons) {
				button.update(mouse);
			}
			mouse.intercept();
		}
	}
	
}