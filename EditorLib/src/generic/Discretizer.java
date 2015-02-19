package generic;

final public class Discretizer {
	
	private Discretizer() {}
	
	public static int getMouseoverTileXPosition(int mouseXPos, Tiled grid) {
		int tileX = mouseXPos - (mouseXPos % grid.getTileWidth());
		if (mouseXPos < 0) { 
			tileX -= grid.getTileWidth(); 
		}
		return tileX;
	}
	
	public static int getMouseoverTileYPosition(int mouseYPos, Tiled grid) {
		int tileY = mouseYPos - (mouseYPos % grid.getTileHeight());
		if (mouseYPos < 0) { 
			tileY -= grid.getTileHeight(); 
		}
		return tileY;
	}
	
	public static int getColAtXPosition(int xPos, Tiled grid) {
		return getMouseoverTileXPosition(xPos, grid) / grid.getTileWidth();
	}
	public static int getRowAtYPosition(int yPos, Tiled grid) {
		return getMouseoverTileYPosition(yPos, grid) / grid.getTileHeight();
	}
}
