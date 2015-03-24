package UI.widgets;

import UI.UILayer;
import UI.input.MouseUserDevice;
import generic.fp.VoidFunctionPointer;
import shapes.Point;

public abstract class DropdownMenuBar implements UILayer {

	protected MenuButton 	dropdownButton;
	protected MenuBar		menuBar;
	private boolean			isDropped;
	private int 			dropdownArrowWidth;
	
	private VoidFunctionPointer dropdownButtonPressedFunction = new VoidFunctionPointer() {
		@Override
		public void call() {
			isDropped = ! isDropped;
			
			if (isDropped) {
				setArrowUp();
			} else {
				setArrowDown();
			}
		}
	};
	
	public DropdownMenuBar(MenuBar MENU_BAR) {
		isDropped 		   = false;
		dropdownArrowWidth = 8;
		dropdownButton = extendedMenuButton();
		dropdownButton.setButtonPressedFunction(dropdownButtonPressedFunction);
		setMenuBar(MENU_BAR);
	}
	
	protected abstract MenuButton extendedMenuButton();
	
	protected boolean isDropped() { 
		return isDropped; 
	}
	
	@Override
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
		ArrowButton.up(dropdownButton, position, 0, dropdownArrowWidth);
		dropdownButton.shift(0, -dropdownArrowWidth);
	}
	
	private void setArrowDown() {
		Point position = getDesiredButtonPosition();
		ArrowButton.down(dropdownButton, position, 0, dropdownArrowWidth);
	}
	
	private Point getDesiredButtonPosition() {
		return new Point(menuBar.getPosition().x + 2*dropdownArrowWidth, menuBar.getPosition().y + 2*dropdownArrowWidth);
	}
	
	private void updateArrowButtonPosition() {
		dropdownButton.setPosition(getDesiredButtonPosition());
	}

}
