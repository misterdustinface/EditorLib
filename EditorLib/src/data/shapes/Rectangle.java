package data.shapes;

public class Rectangle {

	public float x, y, width, height;
	
	public Rectangle() {
		setBounds(0,0,0,0);
	}
	
	public Rectangle(Point XY, float WIDTH, float HEIGHT) {
		setBounds(XY.x, XY.y, WIDTH, HEIGHT);
	}
	
	public Rectangle(float X, float Y, float WIDTH, float HEIGHT) {
		setBounds(X,Y,WIDTH,HEIGHT);
	}
	
	public boolean contains(float X, float Y) {
		return x <= X && X <= (x+width) 
			&& y <= Y && Y <= (y+height);
	}
	
	public void setBounds(float X, float Y, float WIDTH, float HEIGHT) {
		if(WIDTH  < 0) { WIDTH  = -WIDTH;  X -= WIDTH; }
		if(HEIGHT < 0) { HEIGHT = -HEIGHT; Y -= HEIGHT;}
		
		x = X;
		y = Y;
		width = WIDTH;
		height = HEIGHT;
	}
	
	public float getCenterX() { return x + (width /2); }
	public float getCenterY() { return y + (height/2); }
}
