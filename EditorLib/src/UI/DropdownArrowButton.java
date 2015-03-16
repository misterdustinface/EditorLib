package UI;

import shapes.Point;

public class DropdownArrowButton extends MenuButton {

	protected boolean isDroppedDown;
	
	private Point position;
	private int offset, size;
	
	public DropdownArrowButton(Point POSITION, int OFFSET, int SIZE) {
		position = new Point(POSITION.x, POSITION.y);
		offset = OFFSET;
		size = SIZE;
		isDroppedDown = false;
		orientArrow();
	}
	
	private void flip() {
		isDroppedDown = !isDroppedDown;
		orientArrow();
		notifyChanged();
	}
	
	private void orientArrow() {
		if (isDroppedDown) {
			position.shift(0, -size);
			ArrowButton.up(this, position, offset, size);
		} else {
			position.shift(0, size);
			ArrowButton.down(this, position, offset, size);
		}
	}
	
	@Override
	protected void pressAction() {
		flip();
		super.pressAction();
	}
	
}
