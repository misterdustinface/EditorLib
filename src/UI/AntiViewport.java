package UI;


public class AntiViewport {

	private Viewport viewport;
	
	public AntiViewport() {}
	
	public void setViewport(Viewport VIEWPORT) {
		viewport = VIEWPORT;
	}
	
	public float getXPosition() {
		return -viewport.getXPosition();
	}
	
	public float getYPosition() {
		return -viewport.getYPosition();
	}
	
}