package UI.widgets;

import shapes.Polygon;
import shapes.PolygonBuilder;
import structures.Grid;


public class StaticGridMenu extends UIMenu {

	final protected Grid displaygrid;
	
	public StaticGridMenu(Grid DISPLAYGRID) {
		displaygrid = DISPLAYGRID;
		buttonOffset = 20;
		buttonWidth = buttonHeight = 40;
		resetMenuDimensions();
	}
	
	public void setGridDimensions(int ROWS, int COLS) {
		displaygrid.rows = ROWS; displaygrid.cols = COLS;
		resetMenuDimensions();
	}
	
	protected void resetMenuDimensions() {
		width  = getSuggestedDimension(buttonOffset, buttonWidth,  displaygrid.cols);
		height = getSuggestedDimension(buttonOffset, buttonHeight, displaygrid.rows);
	}
	
	public void refreshButton(int index) {
		Polygon p = PolygonBuilder.makeBox(buttonWidth, buttonHeight);
		p.shift((int)position.x + getXOffset(index), (int)position.y + getYOffset(index));
		getButton(index).setPolygon(p);
	}
	
	protected float getXOffset(int buttonIndex) {
		return getUnadjustedXOffset(buttonIndex) % (width-buttonOffset);
	}
	
	protected float getYOffset(int buttonIndex) {	
		return getUnadjustedYOffset(getButtonRow(buttonIndex)) % (height-buttonOffset);
	}
	
	protected float getUnadjustedXOffset(int buttonIndex){
		return getUnadjustedOffset(buttonIndex, buttonWidth);
	}
	
	protected float getUnadjustedYOffset(int buttonIndex){
		return getUnadjustedOffset(buttonIndex, buttonHeight);
	}
	
	protected float getUnadjustedOffset(int buttonIndex, float buttonSize) {
		return (((buttonIndex+1) * buttonOffset) + ((buttonIndex) * buttonSize));
	}
	
	protected int getButtonRow(int buttonIndex) {
		return (int)(getUnadjustedXOffset(buttonIndex) / (float)(width-buttonOffset));
	}

}