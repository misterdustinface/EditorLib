package shapes;

public class Math {
	final public static double PI = java.lang.Math.PI;
	
	public static float length(final LineSegment line) { 
		return distance(line.a, line.b); 
	}
	
	public static float distance(final Point A, final Point B) { 
		return sqrt(squared(A.x - B.x) + squared(A.y - B.y));
	}
	
	public static float distance(final float X1, final float Y1, final float X2, final float Y2){
		return sqrt(squared(X1 - X2) + squared(Y1 - Y2));
	}
	
	public static float slope(final LineSegment line) { 
		return slope(line.a, line.b);
	}
	
	public static float slope(final Point A, final Point B) { 
		return (A.y - B.y)/(A.x - B.x); 
	}
	
	public static double theta(Point A, Point B) {
		return java.lang.Math.atan2((double)(B.y-A.y),(double)(B.x-A.x));
	}
	
	public static double theta(float x1, float y1, float x2, float y2) {
		return java.lang.Math.atan2((double)(y2-y1),(double)(x2-x1));
	}
	
	public static double perpendicular(double theta) { 
		return Math.PI - theta; 
	}
	
	public static float sqrt(final float VALUE) { 
		return (float) java.lang.Math.sqrt((double)VALUE);
	}
	
	public static float squared(final float VALUE) { 
		return VALUE * VALUE; 
	}
	
	public static float abs(float val) { 
		return java.lang.Math.abs(val); 
	}
	
	public static boolean isEven(final int number) {
		return (number & 0x1) == 0;
	}
	
	public static boolean isOdd(final int number) {
		return (number & 0x1) == 1;
	}
	
	public static Point midpoint(Point A, Point B) {
		Point midpoint = new Point(A.x, A.y);
		midpoint.x = (midpoint.x + B.x)/2;
		midpoint.y = (midpoint.y + B.y)/2;
		return midpoint;
	}
	
	public static float difference(float A, float B) {
		return Math.abs(Math.abs(A) - Math.abs(B));
	}
	
	public static float max(float A, float B) {
		return java.lang.Math.max(A, B);
	}
	
	public static float min(float A, float B) {
		return java.lang.Math.min(A, B);
	}
	
	enum ORIENTATION { COLINEAR, CLOCKWISE, COUNTERCLOCKWISE };
	public static ORIENTATION orientation(Point A, Point B, Point C) {
	    // See 10th slides from following link for derivation of the formula
	    // http://www.dcs.gla.ac.uk/~pat/52233/slides/Geometry1x1.pdf
	    float val = (B.y - A.y) * (C.x - B.x) -
	              	(B.x - A.x) * (C.y - B.y);
	 
	    if (val == 0) return ORIENTATION.COLINEAR;
	    return (val > 0) ? ORIENTATION.CLOCKWISE : ORIENTATION.COUNTERCLOCKWISE;
	}
	
	public static boolean doLineSegmentsABandCDIntersect(Point A, Point B, Point C, Point D) {
		ORIENTATION o1 = orientation(A, B, C);
		ORIENTATION o2 = orientation(A, B, D);
		ORIENTATION o3 = orientation(C, D, A);
		ORIENTATION o4 = orientation(C, D, B);
		
		return (o1 != o2 && o3 != o4)
			|| (o1 == ORIENTATION.COLINEAR && onSegment(A, C, B))
			|| (o2 == ORIENTATION.COLINEAR && onSegment(A, D, B)) 
			|| (o3 == ORIENTATION.COLINEAR && onSegment(C, A, D)) 
			|| (o4 == ORIENTATION.COLINEAR && onSegment(C, B, D));
	}
	
	// Given three colinear points A, B, C the function checks if
	// point lies on line segment 'AB'
	private static boolean onSegment(Point A, Point point, Point B) {
	    return (point.x <= max(A.x, B.x) && point.x >= min(A.x, B.x) &&
	    		point.y <= max(A.y, B.y) && point.y >= min(A.y, B.y));
	}
	
	public static boolean isOnLineSegment(Point A, Point point, Point B) {
		return orientation(A, point, B) == ORIENTATION.COLINEAR
			&& onSegment(A, point, B);
	}
	
}