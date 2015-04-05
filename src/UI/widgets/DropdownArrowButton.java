//package UI.widgets;
//
//import shapes.Point;
//import shapes.Polygon;
//import shapes.PolygonBuilder;
//
//public class DropdownArrowButton extends MenuButton {
//
//	protected boolean isDroppedDown;
//	
//	private Point position;
//	private int width, height;
//	
//	public DropdownArrowButton(Point POSITION, int WIDTH, int HEIGHT) {
//		position = new Point(POSITION.x, POSITION.y);
//		width = WIDTH;
//		height = HEIGHT;
//		isDroppedDown = false;
//		orientArrow();
//	}
//	
//	private void flip() {
//		isDroppedDown = !isDroppedDown;
//		orientArrow();
//		notifyChanged();
//	}
//	
//	private void orientArrow() {
//		if (isDroppedDown) {
//			position.shift(0, -height);
//			Polygon p = PolygonBuilder.makeUpArrow(width, height);
//			p.shift(position.x, position.y);
//			setPolygon(p);
//		} else {
//			position.shift(0, height);
//			Polygon p = PolygonBuilder.makeDownArrow(width, height);
//			p.shift(position.x, position.y);
//			setPolygon(p);
//		}
//	}
//	
//	protected void pressAction() {
//		flip();
//		super.pressAction();
//	}
//	
//}