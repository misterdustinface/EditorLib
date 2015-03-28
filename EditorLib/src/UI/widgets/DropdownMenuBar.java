package UI.widgets;

import UI.UILayer;
import UI.input.MouseUserDevice;
import generic.fp.VoidFunctionPointer;
import generic.tags.FactoryMethodPattern;
import shapes.Point;
import shapes.Polygon;
import shapes.PolygonBuilder;

public abstract class DropdownMenuBar implements UILayer, FactoryMethodPattern {

	protected MenuButton 	dropdownButton;
	protected MenuBar		menuBar;
	private boolean			isDropped;
	private int 			dropdownArrowWidth, dropdownArrowHeight;
	
	public DropdownMenuBar(MenuBar MENU_BAR) {
		isDropped 		   = false;
		dropdownArrowWidth  = 16;
		dropdownArrowHeight = 8;
		dropdownButton = newDropdownMenuButton();
		dropdownButton.setButtonPressedFunction(dropdownButtonPressedFunction);
		setMenuBar(MENU_BAR);
	}
	
	protected abstract MenuButton newDropdownMenuButton();
	
	protected boolean isDropped() { 
		return isDropped; 
	}
	
	final public void update(MouseUserDevice mouse) {
		updateArrowButtonPosition();
		dropdownButton.update(mouse);
		if (isDropped) {
			menuBar.update(mouse);
		}
	}
	
	private void setMenuBar(MenuBar MENU_BAR) {
		menuBar = MENU_BAR;
		setArrowDown();
	}
	
	private void setArrowUp() {
		Point position = getDesiredButtonPosition();
		Polygon p = PolygonBuilder.makeUpArrow(dropdownArrowWidth, dropdownArrowHeight);
		p.shift(position.x, position.y);
		dropdownButton.setPolygon(p);
		dropdownButton.shift(0, -dropdownArrowHeight);
	}
	
	private void setArrowDown() {
		Point position = getDesiredButtonPosition();
		Polygon p = PolygonBuilder.makeDownArrow(dropdownArrowWidth, dropdownArrowHeight);
		p.shift(position.x, position.y);
		dropdownButton.setPolygon(p);
	}
	
	private Point getDesiredButtonPosition() {
		return new Point(menuBar.getPosition().x + dropdownArrowWidth, menuBar.getPosition().y + 2*dropdownArrowHeight);
	}
	
	private void updateArrowButtonPosition() {
		dropdownButton.setCenterPosition(getDesiredButtonPosition());
	}
	
	private VoidFunctionPointer dropdownButtonPressedFunction = new VoidFunctionPointer() {
		public void call() {
			isDropped = ! isDropped;
			
			if (isDropped) {
				setArrowUp();
			} else {
				setArrowDown();
			}
		}
	};

}