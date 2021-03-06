package shapes;

final public class Rectangle extends Shape {

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
		if (WIDTH  < 0) { 
			WIDTH = -WIDTH;  
			X -= WIDTH; 
		}
		if (HEIGHT < 0) { 
			HEIGHT = -HEIGHT; 
			Y -= HEIGHT;
		}
		
		x = X;
		y = Y;
		width = WIDTH;
		height = HEIGHT;
	}
	
	public float getCenterX() { 
		return x + (width /2); 
	}
	
	public float getCenterY() { 
		return y + (height/2); 
	}

	public boolean contains(Point point) {
		return contains(point.x, point.y);
	}

	public void setPosition(float x, float y) {
		setBounds(x, y, this.width, this.height);
	}
	
	public void setCenterPosition(float x, float y) {
		setPosition(x - this.width/2, y - this.height/2);
	}

	public void scale(float percent) {
		width  *= percent;
		height *= percent;
	}

	public void shift(float xOffset, float yOffset) {
		x += xOffset;
		y += yOffset;
	}

	public void rotate(int degrees) {
		if (degrees == 90 ^ degrees == 270) {
			width  = width + height;
			height = width - height;
			width  = width - height;
		}
	}

	public void reconstruct() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}
	
	public Rectangle copy() {
		return new Rectangle(x, y, width, height);
	}
	
}