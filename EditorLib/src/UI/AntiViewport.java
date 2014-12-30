package UI;

import data.shapes.Point;

public class AntiViewport {

	private Viewport viewport;
	
	public AntiViewport() {}
	
	public void setViewport(Viewport VIEWPORT) {
		viewport = VIEWPORT;
	}
	
	public Point getPosition() {
		return new Point(-viewport.getXPosition(), -viewport.getYPosition());
	}
	
	public Point getPositionRelativeToOffsets(float xOff, float yOff) {
		return new Point(xOff-viewport.getXPosition(), yOff-viewport.getYPosition());
	}
}
