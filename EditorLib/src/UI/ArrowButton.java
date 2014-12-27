package UI;

import data.shapes.Point;
import data.shapes.Polygon;

public class ArrowButton extends MenuButton {

	private Point position;
	private int offset, size;
	
	public ArrowButton(Point POSITION, int OFFSET, int SIZE) {
		position = POSITION;
		offset   = OFFSET;
		size     = SIZE;
		setOrientationRight();
	}
	
	public void setOrientationRight(){ right(this, position, offset, size); }
	public void setOrientationLeft() {  left(this, position, offset, size); }
	public void setOrientationUp()   {    up(this, position, offset, size); }
	public void setOrientationDown() {  down(this, position, offset, size); }
	
	private static void right(ArrowButton b, Point p, int xoff, int size) {
		b.polygon = new Polygon(3);
		b.addPointRelativeToMenuPosition(p, xoff,   0);
		b.addPointRelativeToMenuPosition(p, xoff - size,  size);
		b.addPointRelativeToMenuPosition(p, xoff - size, -size);
	}
	
	private static void left(ArrowButton b, Point p, int xoff, int size) {
		b.polygon = new Polygon(3);
		b.addPointRelativeToMenuPosition(p, xoff,   0);
		b.addPointRelativeToMenuPosition(p, xoff + size,  size);
		b.addPointRelativeToMenuPosition(p, xoff + size, -size);
	}
	
	private static void up(ArrowButton b, Point p, int yoff, int size) {
		b.polygon = new Polygon(3);
		b.addPointRelativeToMenuPosition(p, 0, yoff);
		b.addPointRelativeToMenuPosition(p, size,  yoff-size);
		b.addPointRelativeToMenuPosition(p, -size, yoff-size);
	}
	
	private static void down(ArrowButton b, Point p, int yoff, int size) {
		b.polygon = new Polygon(3);
		b.addPointRelativeToMenuPosition(p, 0, yoff);
		b.addPointRelativeToMenuPosition(p, size,  yoff+size);
		b.addPointRelativeToMenuPosition(p, -size, yoff+size);
	}

}
