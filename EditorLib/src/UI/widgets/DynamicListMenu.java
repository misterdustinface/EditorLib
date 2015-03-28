package UI.widgets;

import shapes.Polygon;
import shapes.PolygonBuilder;
import generic.tags.FactoryMethodPattern;

public abstract class DynamicListMenu extends StaticListMenu implements FactoryMethodPattern {

	public DynamicListMenu() {
		
	}
	
	public void makeButtons(int number) {
		for (int i = 0; i < number; ++i)
			makeButton(i);
		resetMenuDimensions();
	}
	
	protected void makeButton(int index) {
		MenuButton button = newButton(index);
		Polygon p = PolygonBuilder.makeBox(buttonWidth, buttonHeight);
		p.shift((int)position.x + buttonOffset, (int)position.y + getYOffset(index));
		button.setPolygon(p);
		buttons.add(button);
	}
	
	protected abstract MenuButton newButton(int index);
	
}