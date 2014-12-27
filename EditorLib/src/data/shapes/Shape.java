package data.shapes;

public abstract class Shape {

	private static long instanceCounter = 0;
	private long instance, id;
	
	public Shape() {
		instance = instanceCounter++;
		id = instance;
	}
	
	public long ID() { return id; }
	
	abstract public boolean contains(Point point);
	abstract public boolean contains(float x, float y);
	abstract public void	setPosition(float x, float y);
	abstract public void    scale(float percent);
	abstract public void	shift(float xOffset, float yOffset);
	abstract public void	rotate(int degrees);
}
