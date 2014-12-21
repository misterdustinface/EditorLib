package data.shapes;

public class Circle extends Shape {

	private static final String NAME = "CIRCLE";
	
	private float r;
	private Point center;
	
	public Circle(final float x, final float y, final float r){
		super(NAME);
		this.r = Math.abs(r);
		this.center = new Point(x,y);
	}
	public Circle(final Circle other){
		super(NAME);
		this.r = other.r;
		this.center = other.center.copy();
	}
	
	public Circle(final Point center, final float r){
		super(NAME);
		this.center = center.copy();
		this.r = Math.abs(r);
	}
	public void setPosition(float x, float y){center.x = x; center.y = y;}
	void setRadius(float r){this.r = Math.abs(r);}
	
	public Point center(){return center;}
	public Point centerCopy(){return center.copy();}
	public float radius(){return r;}
	public float diameter(){return r*2;}
	public float x(){return center.x;}
	public float y(){return center.y;}
	public float area(){return (float)(Math.PI) * Math.squared(r);}
	public float circumference(){return diameter() * (float)Math.PI;}
	
	@Override
	public boolean contains(Point point){
		return Math.distance(center, point) <= r;
	}
	public boolean contains(final float X, final float Y){
		return Math.distance(center.x, center.y, X, Y) <= r;
	}
	
	@Override
	public int hashCode(){
		return center.hashCode();
	}

	@Override
	public void scale(float percent) {
		setRadius(radius() * percent);
	}	
	@Override
	public void shift(float xOffset, float yOffset) {
		setPosition(center.x + xOffset, center.y + yOffset);
	}
	@Override
	public void rotate(int degrees) {}
	
//	public boolean intersects(Rectangle rect) {
//		return center.x + r >= rect.x
//			&& center.x - r <= rect.x + rect.width
//			&& center.y + r >= rect.y
//			&& center.y - r <= rect.y + rect.height;
//	}
}
