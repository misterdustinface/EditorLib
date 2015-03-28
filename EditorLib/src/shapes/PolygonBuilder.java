package shapes;

import generic.tags.Library;

final public class PolygonBuilder implements Library {

	private PolygonBuilder() {
		
	}

	public static Polygon makeBox(int width, int height) {
		Polygon polygon = new Polygon(4);
		polygon.addPoint(0, 0);
		polygon.addPoint(width, 0);
		polygon.addPoint(width, height);
		polygon.addPoint(0, height);
		return polygon;
	}
	
	public static Polygon makeUpArrow(int width, int height) {
		Polygon polygon = new Polygon(3);
		polygon.addPoint(0, 0);
		polygon.addPoint(-width/2, height);
		polygon.addPoint(width/2, height);
		return polygon;
	}
	
	public static Polygon makeDownArrow(int width, int height) {
		Polygon polygon = new Polygon(3);
		polygon.addPoint(0, 0);
		polygon.addPoint(-width/2, -height);
		polygon.addPoint(width/2, -height);
		return polygon;
	}
	
	public static Polygon makeLeftArrow(int width, int height) {
		Polygon polygon = new Polygon(3);
		polygon.addPoint(0, 0);
		polygon.addPoint(width, -height/2);
		polygon.addPoint(width, height/2);
		return polygon;
	}
	
	public static Polygon makeRightArrow(int width, int height) {
		Polygon polygon = new Polygon(3);
		polygon.addPoint(0, 0);
		polygon.addPoint(-width, -height/2);
		polygon.addPoint(-width, height/2);
		return polygon;
	}

}