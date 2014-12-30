package rendering;

import shapes.Circle;
import shapes.LineSegment;
import shapes.Point;
import shapes.Polygon;
import shapes.Rectangle;

public interface ShapeDrawer {
	void drawPoint        			(Point       point);
	void drawLineSegment  			(LineSegment lineSegment);
	void drawCircle       			(Circle      circle);
	void drawFilledCircle   		(Circle      circle);
	void drawRectangle				(Rectangle   rectangle);
	void drawFilledRectangle    	(Rectangle   rectangle);
	void drawPolygon				(Polygon     polygon);
	void drawFilledPolygon      	(Polygon     polygon);
}
