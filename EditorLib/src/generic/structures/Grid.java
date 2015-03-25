package generic.structures;

import generic.tags.Structure;

public class Grid implements Structure {
	
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
	
}