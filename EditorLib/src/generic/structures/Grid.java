package generic.structures;

import tags.Structure;
import base.Reusable;

public class Grid implements Structure, Reusable {
	
	public int rows, cols;
	
	public Grid() {
		rows = 0; 
		cols = 0;
	}
	
	public Grid(int ROWS, int COLS) {
		rows = ROWS; 
		cols = COLS;
	}
	
	public int getNumberOfCells() { 
		return rows * cols; 
	}

	@Override
	public void reconstruct() {
		rows = 0;
		cols = 0;
	}
	
}