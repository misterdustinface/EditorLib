package data.shapes;

public abstract class Shape {

	private static long instanceCounter = 0;
	private long instance;
	private String id;
	
	public Shape(String NAME) {
		instance = instanceCounter++;
		id = NAME + instance;
	}
	
	public String ID() { return id; }
	
	abstract public boolean contains(Point point);
	abstract public boolean contains(float x, float y);
	abstract public void	setPosition(float x, float y);
	abstract public void    scale(float percent);
	abstract public void	shift(float xOffset, float yOffset);
	abstract public void	rotate(int degrees);
}
