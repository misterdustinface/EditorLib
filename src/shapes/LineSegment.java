package shapes;

import tags.Aggregate;
import base.Reusable;


final public class LineSegment extends Shape implements Reusable, Aggregate {

	public Point a;
	public Point b;
	
	public LineSegment(Point A, Point B){
		a = A; 
		b = B;
	}
	
	public LineSegment(LineSegment other){
		a = other.a;
		b = other.b;
	}
	
	public float length(){
		return Math.distance(a, b);
	}
	
	public Point midpoint(){
		return Math.midpoint(a, b);
	}
	
	/**
	 * @param percent 0.0 - 1.0
	 * @return Point
	 */
	public Point pointAt(double percent){
		//percent = percent > 1.0f ? (percent < 0.0f ? 0.0f : percent) : 1.0f;
		double offset = percent * length();
		double theta  = Math.theta(a, b);
		return new Point(a.x + (float)(offset*java.lang.Math.cos(theta)), a.y + (float)(offset*java.lang.Math.sin(theta)));
	}
	
	public void shift(float x, float y){
		a.x += x; 
		a.y += y; 
		b.x += x;
		b.y += y;
	}
	
	public void scale(float percent){
		double theta = Math.theta(a, b);
		float halfLength = length()/2;
		resize(	(float)(java.lang.Math.cos(theta) * halfLength * percent),
				(float)(java.lang.Math.sin(theta) * halfLength * percent));
	}
	
	public void rotate(int degrees){
		rotateByTheta(java.lang.Math.toRadians(degrees));
	}
	
	private void rotateByTheta(double theta){
		theta += Math.theta(a, b);
		float halfLength = length()/2;
		resize(	(float)(java.lang.Math.cos(theta) * halfLength),
				(float)(java.lang.Math.sin(theta) * halfLength));
	}
	
	public boolean contains(Point point) {
		return a.equals(point) || b.equals(point);
	}

	public boolean contains(float x, float y) {
		return (a.x == x && a.y == y) || (b.x == x && b.y == y);
	}

	public void setCenterPosition(float x, float y) {
		Point midpoint = midpoint();
		shift(x - midpoint.x, y - midpoint.y);
	}
	
	/**
	 * @param percent 0.0 - 1.0
	 * @return Line
	 */
	public LineSegment split(double percent){
		Point temp = b;
		b = pointAt(percent);
		return new LineSegment(b, temp);
	}
	
	/**
	 * Offsets from center
	 * @param xOff
	 * @param yOff
	 */
	private void resize(float xOff, float yOff){
		Point midpoint = midpoint();
		
		if (a.x > b.x) { 
			a.x = midpoint.x + xOff; 
			b.x = midpoint.x - xOff;
		} else {
			a.x = midpoint.x - xOff; 
			b.x = midpoint.x + xOff;
		}
		
		if (a.y > b.y) {
			a.y = midpoint.y + yOff; 
			b.y = midpoint.y - yOff;
		} else {
			a.y = midpoint.y - yOff; 
			b.y = midpoint.y + yOff;
		}
	}
	
	public boolean isEdge(Point point) {
		return a.equals(point) || b.equals(point);
	}
	
	public boolean isOnSegment(Point point) {
		return Math.isOnLineSegment(a, point, b);
	}
	
	public boolean intersects(LineSegment other) {
		return Math.doLineSegmentsABandCDIntersect(a, b, other.a, other.b);
	}

	public void reconstruct() {
		a.reconstruct();
		b.reconstruct();
	}
	
	public LineSegment copy() {
		return new LineSegment(a.copy(), b.copy());
	}

}