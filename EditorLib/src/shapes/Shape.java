package shapes;

import generic.Reusable;

public abstract class Shape implements Reusable {

	private static long instanceCounter = 0;
	private long instance, id;
	
	public Shape() {
		instance = instanceCounter++;
		id = instance;
	}
	
	public long ID() { 
		return id; 
	}
	
	abstract public boolean contains(Point point);
	abstract public boolean contains(float x, float y);
	abstract public void	setCenterPosition(float x, float y);
	abstract public void    scale(float percent);
	abstract public void	shift(float xOffset, float yOffset);
	abstract public void	rotate(int degrees);
	abstract public Shape   copy();
	
}