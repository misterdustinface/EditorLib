package shapes;

import generic.tags.Aggregate;

final public class Pipe extends Shape implements Aggregate {
	
	public  LineSegment  centerLine;
	private float 		 thickness;
	
	private Point 		 previousA;
	private Point 		 previousB;
	private Polygon 	 area;
	
	public Pipe(Point A, Point B, float THICKNESS) {
		this(new LineSegment(A, B), THICKNESS);
	}
	
	public Pipe(LineSegment CENTERLINE, float THICKNESS){
		centerLine = CENTERLINE; 
		thickness = THICKNESS;
		previousA  = new Point(centerLine.a.x, centerLine.a.y);
		previousB  = new Point(centerLine.b.x, centerLine.b.y);
		area       = new Polygon(4);
		calculateArea();
	}
	
	public float thickness() { 
		return thickness; 
	}
	
	public void scaleThickness(double percent){
		thickness *= percent;
		calculateArea();
	}
	
	public Polygon getArea(){
		
		if (!previousA.equals(centerLine.a) || !previousB.equals(centerLine.b)) {
			resetPreviousPoints();
			calculateArea();
		}

		return area;
	}
	
	public Rectangle getBoundingRectangle(){
		return getArea().getBoundingRectangle();
	}
	
	private void resetPreviousPoints(){
		previousA.set(centerLine.a.x, centerLine.a.y);
		previousB.set(centerLine.b.x, centerLine.b.y);
	}
	
	private void calculateArea(){
		double perpTheta 	= Math.perpendicular(Math.theta(centerLine.a, centerLine.b));
		float yOff 			= (float)java.lang.Math.cos(perpTheta)*thickness;
		float xOff 			= (float)java.lang.Math.sin(perpTheta)*thickness;
		
		area.clearPoints();
		
		area.addPoint(	(int)(centerLine.a.x - xOff), 
						(int)(centerLine.a.y - yOff));
		area.addPoint(	(int)(centerLine.a.x + xOff), 
						(int)(centerLine.a.y + yOff));
		area.addPoint(	(int)(centerLine.b.x + xOff), 
						(int)(centerLine.b.y + yOff));
		area.addPoint(	(int)(centerLine.b.x - xOff), 
						(int)(centerLine.b.y - yOff));	
	}

	public boolean contains(Point point) {
		return getArea().contains(point.x, point.y);
	}
	
	public boolean contains(float x, float y) {
		return getArea().contains(x, y);
	}
	
	public boolean intersects(Rectangle rect){
		return getArea().intersects(rect);
	}
	
	public void scale(float percent) {
		centerLine.scale(percent);
		scaleThickness(percent);
		calculateArea();
	}

	public void shift(float xOffset, float yOffset){
		centerLine.shift(xOffset, yOffset);
	}

	public void rotate(int degrees){
		centerLine.rotate(degrees);
	}

	public void setCenterPosition(float x, float y) {
		Point midp = centerLine.midpoint();
		float xoff = Math.abs(Math.abs(x) - Math.abs(midp.x));
		float yoff = Math.abs(Math.abs(y) - Math.abs(midp.y));
		if (x < midp.x) xoff = -xoff;
		if (y < midp.y) yoff = -yoff;
		shift(xoff, yoff);
	}

	public void reconstruct() {
		thickness = 0;
		centerLine.reconstruct();
		area.reconstruct();
		previousA.reconstruct();
		previousB.reconstruct();
	}
	
	public Pipe copy() {
		return new Pipe(centerLine.copy(), thickness);
	}
	
}