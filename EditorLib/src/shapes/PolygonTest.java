package shapes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PolygonTest {

	private final float DELTA = 0.01f;
	private final int MAX_POLYGON_SIZE = 4;
	private Polygon polygon;
	
	@Before
	public void setUp() throws Exception {
		polygon = createPolygonWithMaxSize(MAX_POLYGON_SIZE);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	public Polygon createPolygonWithMaxSize(final int MAX_SIZE) {
		return new Polygon(MAX_SIZE);
	}
	
	public void addPointToPolygon(Polygon poly, Point A) {
		poly.addPoint(A.x, A.y);
	}
	
	public void assertFloatsEqual(float EXPECTED, float ACTUAL) {
		assertEquals(EXPECTED, ACTUAL, DELTA);
	}
	
	public void assertPolygonCenterEqualsPoint(Polygon poly, Point A) {
		assertFloatsEqual(A.x, poly.getCenterX());
		assertFloatsEqual(A.y, poly.getCenterY());
	}
	
	@Test
	public void test_newPolygon_expectHasNoPoints() {
		assertEquals(polygon.getNumberOfPoints(), 0);
	}
	
	@Test
	public void test_addPointToPolygonWithNoPoints_expectPolygonHasOnePoint() {
		polygon.addPoint(0, 0);
		
		assertEquals(polygon.getNumberOfPoints(), 1);
	}
	
	@Test
	public void test_addPointToPolygonWithNoPoints_expectPolygonCenterEqualsAddedPoint() {
		final Point point = new Point(57, 13);
		
		addPointToPolygon(polygon, point);
		
		assertPolygonCenterEqualsPoint(polygon, point);
	}
	
	@Test
	public void test_addPointAndClearPoints_expectNoPointsInPolygon() {
		polygon.addPoint(0,0);
		polygon.clearPoints();
		
		assertEquals(polygon.getNumberOfPoints(), 0);
	}

	@Test
	public void test_addTwoPointsToPolygonWithNoPoints_expectPolygonCenterEqualsMidpoint() {
		final Point A = new Point(15, 18);
		final Point B = new Point(-3, 27);
		final Point MIDPOINT = Math.midpoint(A, B);
		
		addPointToPolygon(polygon, A);
		addPointToPolygon(polygon, B);
		
		assertPolygonCenterEqualsPoint(polygon, MIDPOINT);
	}
	
	@Test 
	public void test_makePolygonIntoRectangle_expectPolygonCenterEqualsRectangleCenter() {
		final float WIDTH  = 11.8f;
		final float HEIGHT = 15.2f;
		final Point A = new Point(-4, 1);
		final Point B = new Point(A.x + WIDTH, A.y);
		final Point C = new Point(A.x + WIDTH, A.y + HEIGHT);
		final Point D = new Point(A.x, A.y + HEIGHT);
		final Point EXPECTED_CENTER = new Point(A.x + WIDTH/2, A.y + HEIGHT/2);
		
		addPointToPolygon(polygon, A);
		addPointToPolygon(polygon, B);
		addPointToPolygon(polygon, C);
		addPointToPolygon(polygon, D);
		
		assertPolygonCenterEqualsPoint(polygon, EXPECTED_CENTER);
	}
	
	@Test 
	public void test_makePolygonIntoRectangle_expectPolygonContainsRectangleCenter() {
		final float WIDTH  = 14.0f;
		final float HEIGHT = 3.3f;
		final Point A = new Point(0, -11);
		final Point B = new Point(A.x + WIDTH, A.y);
		final Point C = new Point(A.x + WIDTH, A.y + HEIGHT);
		final Point D = new Point(A.x, A.y + HEIGHT);
		final Point EXPECTED_CENTER = new Point(A.x + WIDTH/2, A.y + HEIGHT/2);
		
		addPointToPolygon(polygon, A);
		addPointToPolygon(polygon, B);
		addPointToPolygon(polygon, C);
		addPointToPolygon(polygon, D);
		
		assertTrue(polygon.contains(EXPECTED_CENTER));
	}
	
	@Test 
	public void test_makePolygonIntoRectangle_expectPolygonDoesNotContainPointOutsideOfIt() {
		final float WIDTH  = 14.0f;
		final float HEIGHT = 3.3f;
		final Point A = new Point(0, -11);
		final Point B = new Point(A.x + WIDTH, A.y);
		final Point C = new Point(A.x + WIDTH, A.y + HEIGHT);
		final Point D = new Point(A.x, A.y + HEIGHT);
		final Point POINT_OUTSIDE_OF_RECTANGLE = new Point(A.x - WIDTH, A.y);
		
		addPointToPolygon(polygon, A);
		addPointToPolygon(polygon, B);
		addPointToPolygon(polygon, C);
		addPointToPolygon(polygon, D);
		
		assertFalse(polygon.contains(POINT_OUTSIDE_OF_RECTANGLE));
	}
	
	@Test
	public void test_shiftOnePointPolygon_expectEqualsPointShift() {
		Point point = new Point(3, -2);
		final float X_SHIFT = -4.0f;
		final float Y_SHIFT = 15.0f;
		
		addPointToPolygon(polygon, point);
		
		polygon.shift(X_SHIFT, Y_SHIFT);
		point.shift(X_SHIFT, Y_SHIFT);
		
		assertPolygonCenterEqualsPoint(polygon, point);
	}
}
