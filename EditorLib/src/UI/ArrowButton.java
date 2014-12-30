package UI;

import data.shapes.Point;
import data.shapes.Polygon;

final public class ArrowButton {
	
	private ArrowButton() {} ;
	
	public static void right(MenuButton b, Point p, int xoff, int size) {
		b.polygon = new Polygon(3);
		b.addPointRelativeToMenuPosition(p, xoff,   0);
		b.addPointRelativeToMenuPosition(p, xoff - size,  size);
		b.addPointRelativeToMenuPosition(p, xoff - size, -size);
	}
	
	public static void left(MenuButton b, Point p, int xoff, int size) {
		b.polygon = new Polygon(3);
		b.addPointRelativeToMenuPosition(p, xoff,   0);
		b.addPointRelativeToMenuPosition(p, xoff + size,  size);
		b.addPointRelativeToMenuPosition(p, xoff + size, -size);
	}
	
	public static void down(MenuButton b, Point p, int yoff, int size) {
		b.polygon = new Polygon(3);
		b.addPointRelativeToMenuPosition(p, 0, yoff);
		b.addPointRelativeToMenuPosition(p, size,  yoff-size);
		b.addPointRelativeToMenuPosition(p, -size, yoff-size);
	}
	
	public static void up(MenuButton b, Point p, int yoff, int size) {
		b.polygon = new Polygon(3);
		b.addPointRelativeToMenuPosition(p, 0, yoff);
		b.addPointRelativeToMenuPosition(p, size,  yoff+size);
		b.addPointRelativeToMenuPosition(p, -size, yoff+size);
	}

}
