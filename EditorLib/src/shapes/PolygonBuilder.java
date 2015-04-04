package shapes;

import tags.Library;

final public class PolygonBuilder implements Library {

	private PolygonBuilder() {
		
	}

	public static Polygon makeBox(float width, float height) {
		Polygon polygon = new Polygon(4);
		polygon.addPoint(0, 0);
		polygon.addPoint(width, 0);
		polygon.addPoint(width, height);
		polygon.addPoint(0, height);
		return polygon;
	}
	
	public static Polygon makeUpArrow(float width, float height) {
		Polygon polygon = new Polygon(3);
		polygon.addPoint(0, 0);
		polygon.addPoint(-width/2, height);
		polygon.addPoint(width/2, height);
		return polygon;
	}
	
	public static Polygon makeDownArrow(float width, float height) {
		Polygon polygon = new Polygon(3);
		polygon.addPoint(0, 0);
		polygon.addPoint(-width/2, -height);
		polygon.addPoint(width/2, -height);
		return polygon;
	}
	
	public static Polygon makeLeftArrow(float width, float height) {
		Polygon polygon = new Polygon(3);
		polygon.addPoint(0, 0);
		polygon.addPoint(width, -height/2);
		polygon.addPoint(width, height/2);
		return polygon;
	}
	
	public static Polygon makeRightArrow(float width, float height) {
		Polygon polygon = new Polygon(3);
		polygon.addPoint(0, 0);
		polygon.addPoint(-width, -height/2);
		polygon.addPoint(-width, height/2);
		return polygon;
	}

}