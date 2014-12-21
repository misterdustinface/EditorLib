package data.shapes;


public class Polygon extends Shape {

	private static final String NAME = "POLYGON";
	
	private final int MAX_NUMBER_OF_POINTS;
	private int  points;
	public float[] xpoints;
	public float[] ypoints;
	
	private float centerX, centerY;
	
	public Polygon(int MAX_NUMBER_OF_POINTS) {
		super(NAME);
		xpoints = new float[MAX_NUMBER_OF_POINTS];
		ypoints = new float[MAX_NUMBER_OF_POINTS];
		this.MAX_NUMBER_OF_POINTS = MAX_NUMBER_OF_POINTS;
	}
	
	public Polygon(Point[] POINTS) {
		super(NAME);
		xpoints = new float[POINTS.length];
		ypoints = new float[POINTS.length];
		points = MAX_NUMBER_OF_POINTS = POINTS.length;
		for(int i = 0; i < points; ++i) {
			xpoints[i] = POINTS[i].x;
			ypoints[i] = POINTS[i].y;
		}
		calculateCenter();
	}
	
	public void clearPoints() {
		points  = 0;
		centerX = 0;
		centerY = 0;
	}
	
	public void addPoint(float x, float y) {
		if (points < MAX_NUMBER_OF_POINTS) {
			xpoints[points] = x;
			ypoints[points] = y;
			++points;
			calculateCenter();
		}
	}
	
	public int getNumberOfPoints() { return points; }
	
	public boolean contains(Point point) {
		return contains(point.x, point.y);
	}
	
	// right direction ray odds/evens intersection solution
	public boolean contains(float X, float Y) {
		boolean doesContain = isRightFacingRayFromXYCollidingWithPolygonLinesegmentAB(X, Y, 0, points-1);
		for(int i = 1; i < getNumberOfPoints(); ++i)
			if(isRightFacingRayFromXYCollidingWithPolygonLinesegmentAB(X, Y, i, i-1))
				doesContain = !doesContain;
		return doesContain;
	}
	
	// if Y is within yRange then we can compute: X <= xBase + (xRange * yPercent)
	private boolean isRightFacingRayFromXYCollidingWithPolygonLinesegmentAB(float X, float Y, int A, int B) {
		return isWithinBounds(ypoints[A], Y, ypoints[B])
		&& (X <= xpoints[A] + (xpoints[B] - xpoints[A]) * (Y - ypoints[A]) / (ypoints[B] - ypoints[A]) );
	}
	
	private boolean isWithinBounds(float A, float Y, float B) {
		return (Y < A) ^ (Y < B);
	}
	
	// O(2 n^2) is bad. Remake algorithm.
//	public boolean intersects(Polygon poly) {
//		for(int i = 0; i < poly.points; ++i)
//			if(contains(poly.xpoints[i], poly.ypoints[i]))
//				return true;
//		for(int i = 0; i < points; ++i)
//			if(poly.contains(xpoints[i], ypoints[i]))
//				return true;
//		return false;
//	}
	
	public boolean intersects(Rectangle rect) {
		return intersectsX(rect) && intersectsY(rect);
	}
	
	private boolean intersectsX(Rectangle rect) {
		return intersectionRange1D(smallest(xpoints), largest(xpoints), rect.x, (rect.x + rect.width));
	}
	
	private boolean intersectsY(Rectangle rect) {
		return intersectionRange1D(smallest(ypoints), largest(ypoints), rect.y, (rect.y + rect.height));
	}
	
	private boolean intersectionRange1D(float x1, float X1, float x2, float X2) {
		return (x1 <= x2 && x2 <= X1 ) || (x1 <= X2 && X2 <= X1 );
	}
	
	public Rectangle getBoundingRectangle() {
		float x = smallest(xpoints);
		float y = smallest(ypoints);
		return new Rectangle(x, y, largest(xpoints) - x, largest(ypoints) - y);
	}
	
	private float smallest(float[] ar) {
		float result = Float.MAX_VALUE;
		for(int i = 0; i < points; ++i)
			if(ar[i] < result)
				result = ar[i];
		return result;
	}
	
	private float largest(float[] ar) {
		float result = Float.MIN_VALUE;
		for(int i = 0; i < points; ++i)
			if(ar[i] > result)
				result = ar[i];
		return result;
	}

	@Override
	public void setPosition(float x, float y) {
		shift(x - centerX, y - centerY);
	}

	@Override
	public void scale(float percent) {
		for(int i = 0; i < points; ++i){
			double theta = Math.theta(centerX, centerY, xpoints[i], ypoints[i]);		
			xpoints[i] = (float) java.lang.Math.cos(theta) * Math.difference(xpoints[i], centerX) * percent;
			ypoints[i] = (float) java.lang.Math.sin(theta) * Math.difference(ypoints[i], centerY) * percent;
		}
	}

	@Override
	public void shift(float xOffset, float yOffset) {
		for(int i = 0; i < points; ++i){
			xpoints[i] += xOffset;
			ypoints[i] += yOffset;
		}
	}

	@Override
	public void rotate(int degrees) {
		double rads  = java.lang.Math.toRadians(degrees);
		final float COS = (float)java.lang.Math.cos(rads);
		final float SIN = (float)java.lang.Math.sin(rads);
		float xOff, yOff, length;
		for(int i = 0; i < points; ++i){
			length 	= Math.distance(centerX, centerY, xpoints[i], ypoints[i]);
			xOff   	= length * COS;
			yOff	= length * SIN;
	
			xpoints[i] = xpoints[i] > centerX ? centerX + xOff : centerX - xOff;
			ypoints[i] = ypoints[i] > centerY ? centerY + yOff : centerY - yOff;
		}	
	}
	
	private void calculateCenter() {
		centerX = 0;
		centerY = 0;
		for(int current = 0; current < points; ++current){
			centerX += xpoints[current];
			centerY += ypoints[current];
		}
		centerX /= points;
		centerY /= points;
	}
	
	public float getCenterX() { return centerX; }
	public float getCenterY() { return centerY; }
}