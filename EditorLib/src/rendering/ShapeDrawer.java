package rendering;

import data.shapes.Circle;
import data.shapes.LineSegment;
import data.shapes.Point;
import data.shapes.Polygon;
import data.shapes.Rectangle;

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
