package UI;

import data.shapes.Point;

public class DropdownArrowButton extends ArrowButton {

	protected UILayer dropdownUI;
	protected boolean isDroppedDown;
	
	public DropdownArrowButton(Point POSITION, int OFFSET, int SIZE) {
		super(POSITION, OFFSET, SIZE);
		isDroppedDown = false;
		orientArrow();
	}
	
	public void setDropdownUI(UILayer DROPDOWN_UI) {
		dropdownUI  = DROPDOWN_UI;
		isDroppedDown = false;
		orientArrow();
	}
	
	private void flip() {
		isDroppedDown = ! isDroppedDown;
		orientArrow();
	}
	
	private void orientArrow() {
		if(isDroppedDown) {
			setOrientationUp();
		} else {
			setOrientationDown();
		}
	}
	
	@Override
	protected void pressAction() {
		flip();
	}
	
	@Override
	public void update(MouseUserDevice mouse) {
		super.update(mouse);
		if(isDroppedDown) {
			dropdownUI.update(mouse);
		}
	}
}
