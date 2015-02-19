package shapes;


public class Polygon extends Shape {
	
	private final int MAX_NUMBER_OF_POINTS;
	private int points;
	public float[] xpoints;
	public float[] ypoints;
	
	private Point center;
	
	public Polygon(int MAX_NUMBER_OF_POINTS) {
		xpoints = new float[MAX_NUMBER_OF_POINTS];
		ypoints = new float[MAX_NUMBER_OF_POINTS];
		this.MAX_NUMBER_OF_POINTS = MAX_NUMBER_OF_POINTS;
		center = new Point(0,0);
	}
	
	public Polygon(Point[] POINTS) {
		xpoints = new float[POINTS.length];
		ypoints = new float[POINTS.length];
		points = MAX_NUMBER_OF_POINTS = POINTS.length;
		center = new Point(0,0);
		for(int i = 0; i < points; ++i) {
			xpoints[i] = POINTS[i].x;
			ypoints[i] = POINTS[i].y;
		}
		calculateCenter();
	}
	
	public void clearPoints() {
		points = 0;
		center.set(0, 0);
	}
	
	public void addPoint(float x, float y) {
		if (points < MAX_NUMBER_OF_POINTS) {
			xpoints[points] = x;
			ypoints[points] = y;
			++points;
			calculateCenter();
		}
	}

	public int getNumberOfPoints() { 
		return points; 
	}
	
	public boolean contains(Point point) {
		return contains(point.x, point.y);
	}
	
	// right direction ray odds/evens intersection solution
	public boolean contains(float X, float Y) {
		boolean doesContain = isRightFacingRayFromXYCollidingWithPolygonLinesegmentAB(X, Y, 0, points-1);
		for (int i = 1; i < getNumberOfPoints(); ++i)
			if (isRightFacingRayFromXYCollidingWithPolygonLinesegmentAB(X, Y, i, i-1))
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

	/**
	 * UNTESTED
	 * @return
	 */
	public boolean intersects(Polygon other) {
		Point C = new Point(0,0);
		Point D = new Point(0,0);
		int intersections = 0;
		
		for (int i = 0; i < points - 1; ++i) {
			C.x = xpoints[i]; 	C.y = ypoints[i];
			D.x = xpoints[i+1]; D.y = ypoints[i+1];
			if (Math.doLineSegmentsABandCDIntersect(center, other.center, C, D)) ++intersections;
		}
		for (int i = 0; i < other.points - 1; ++i) {
			C.x = other.xpoints[i]; 	C.y = other.ypoints[i];
			D.x = other.xpoints[i+1]; 	D.y = other.ypoints[i+1];
			if (Math.doLineSegmentsABandCDIntersect(center, other.center, C, D)) ++intersections;
		}
		
		return (intersections == 0) || Math.isOdd(intersections);
	}
	
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
	
	
	/**
	 * UNTESTED
	 * @return
	 */
	public Rectangle getBoundingRectangle() {
		float x = smallest(xpoints);
		float y = smallest(ypoints);
		return new Rectangle(x, y, largest(xpoints) - x, largest(ypoints) - y);
	}
	
	private float smallest(float[] ar) {
		float result = Float.MAX_VALUE;
		for (int i = 0; i < points; ++i)
			if (ar[i] < result)
				result = ar[i];
		return result;
	}
	
	private float largest(float[] ar) {
		float result = Float.MIN_VALUE;
		for (int i = 0; i < points; ++i)
			if (ar[i] > result)
				result = ar[i];
		return result;
	}

	/**
	 * UNTESTED
	 * @return
	 */
	@Override
	public void setPosition(float x, float y) {
		shift(x - center.x, y - center.y);
	}

	/**
	 * UNTESTED
	 * @return
	 */
	@Override
	public void scale(float percent) {
		for (int i = 0; i < points; ++i) {
			double theta = Math.theta(center.x, center.y, xpoints[i], ypoints[i]);		
			xpoints[i] = (float) java.lang.Math.cos(theta) * Math.difference(xpoints[i], center.x) * percent;
			ypoints[i] = (float) java.lang.Math.sin(theta) * Math.difference(ypoints[i], center.y) * percent;
		}
	}

	@Override
	public void shift(float xOffset, float yOffset) {
		for (int i = 0; i < points; ++i) {
			xpoints[i] += xOffset;
			ypoints[i] += yOffset;
		}
		calculateCenter();
	}

	/**
	 * UNTESTED
	 * @return
	 */
	@Override
	public void rotate(int degrees) {
		double rads  = java.lang.Math.toRadians(degrees);
		final float COS = (float)java.lang.Math.cos(rads);
		final float SIN = (float)java.lang.Math.sin(rads);
		float xOff, yOff, length;
		for (int i = 0; i < points; ++i) {
			length 	= Math.distance(center.x, center.y, xpoints[i], ypoints[i]);
			xOff   	= length * COS;
			yOff	= length * SIN;
	
			xpoints[i] = xpoints[i] > center.x ? center.x + xOff : center.x - xOff;
			ypoints[i] = ypoints[i] > center.y ? center.y + yOff : center.y - yOff;
		}
	}
	
	private void calculateCenter() {
		center.x = 0;
		center.y = 0;
		for (int current = 0; current < points; ++current) {
			center.x += xpoints[current];
			center.y += ypoints[current];
		}
		center.x /= points;
		center.y /= points;
	}
	
	public float getCenterX() { 
		return center.x; 
	}
	public float getCenterY() { 
		return center.y; 
	}

}