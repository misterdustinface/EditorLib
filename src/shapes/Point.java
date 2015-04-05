package shapes;

import base.Reusable;

public class Point implements Reusable {

	public float x;
	public float y;
	
	public Point() {
		set(0, 0);
	}
	
	public Point(float X, float Y) { 
		set(X, Y); 
	}
	
	public Point copy() { 
		return new Point(x, y); 
	}
	
	public void set(float X, float Y) { 
		x = X; 
		y = Y; 
	}
	
	public void setPosition(Point other) { 
		x = other.x; 
		y = other.y;
	}
	
	public void shift(float X, float Y) { 
		x += X; 
		y += Y; 
	}
	
	public boolean equals(Point other) { 
		return x == other.x && y == other.y; 
	}
	
	public int hashCode() {
		//http://stackoverflow.com/questions/919612/mapping-two-integers-to-one-in-a-unique-and-deterministic-way
		//Szudzik's function:
		//a >= b ? a * a + a + b : a + b * b;  where a, b >= 0
		int tx = Float.floatToIntBits(x);
		int ty = Float.floatToIntBits(y);
		return tx >= ty ? (tx * tx + tx + ty) : (tx + ty * ty);
	}
	
	public String toString() {
		return "Point[x: " + x + " y: " + y + "]";
	}

	public void reconstruct() {
		x = 0;
		y = 0;
	}
	
}