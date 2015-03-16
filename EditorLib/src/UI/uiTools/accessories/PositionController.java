package UI.uiTools.accessories;

import shapes.Point;

public class PositionController {
	
	public  Point position;
	private Point initialPosition;

	public PositionController() {
		initialPosition = new Point(0,0);
		position = new Point(0,0);
	}
	
	public PositionController(Point INITIAL_POSITION) {
		initialPosition = new Point(INITIAL_POSITION.x, INITIAL_POSITION.y);
		position = new Point(INITIAL_POSITION.x, INITIAL_POSITION.y);
	}
	
	public void reset() {
		position.set(initialPosition.x, initialPosition.y);
	}
	
	public Point getPosition() {
		return position;
	}
	
}
