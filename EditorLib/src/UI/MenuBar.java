package UI;

import java.util.ArrayList;

import data.shapes.Point;
import data.shapes.Rectangle;

public class MenuBar implements UILayer {

	protected ArrayList<UIMenu> menus;
	protected Rectangle			boundingBox;
	private Viewport			viewport;
	private int 				spacingOffset;
	private float				xOffset, yOffset;

	public MenuBar() {
		boundingBox = new Rectangle(0,0,0,0);
		menus = new ArrayList<UIMenu>();
		spacingOffset = 0;
		xOffset = yOffset = 0;
	}
	
	public void setOffset(float xOff, float yOff) {
		xOffset = xOff;
		yOffset = yOff;
	}
	
	public void setSpacing(int SPACING) { 
		spacingOffset = SPACING;
		updateMenuOffsets();
		calculateDimensions();
	}

	public void setViewport(Viewport VIEWPORT) {
		viewport = VIEWPORT;
		setBoundingBoxPosition();
	}
	
	private void setBoundingBoxPosition() {
		boundingBox.setPosition(xOffset-viewport.getXPosition(), yOffset-viewport.getYPosition());
	}
	
	public void addUIMenu(UIMenu MENU) {
		menus.add(MENU);
		updateMenuPositions();
		updateMenuOffsets();
		calculateDimensions();
	}
	
	public void addUIMenus(UIMenu ... MENUS) {
		for(UIMenu menu : MENUS) {
			menus.add(menu);
		}
		updateMenuPositions();
		updateMenuOffsets();
		calculateDimensions();
	}
	
	public void removeUIMenu(UIMenu MENU) {
		menus.remove(MENU);
		updateMenuPositions();
		updateMenuOffsets();
		calculateDimensions();
	}

	@Override
	public void update(MouseUserDevice mouse) {
		setBoundingBoxPosition();
		updateMenuPositions();
		if(isMouseInMenuBarBoundingBox(mouse)) {
			updateMenus(mouse);
			mouse.intercept();
		}
	}
	
	private void updateMenuPositions() {
		Point newPosition = new Point(boundingBox.x + spacingOffset, boundingBox.y + spacingOffset);
		for(int i = menus.size()-1; i >= 0; --i) {
			menus.get(i).setPosition(newPosition);
			newPosition.shift(menus.get(i).getWidth() + spacingOffset, 0);
		}
	}
	
	private void updateMenuOffsets() {
		for(UIMenu menu : menus) {
			menu.setButtonOffset(spacingOffset);
		}
	}
	
	protected boolean isMouseInMenuBarBoundingBox(MouseUserDevice mouse) {
		return boundingBox.contains(mouse.getCursorPosition());
	}
	
	private void updateMenus(MouseUserDevice mouse) {
		for(UIMenu menu : menus) {
			menu.update(mouse);
		}
	}
	
	private void calculateDimensions() {
		boundingBox.width  = 0;
		boundingBox.height = 0;
		for(UIMenu menu : menus) {
			boundingBox.width += menu.getWidth() + spacingOffset;
			boundingBox.height = Math.max(boundingBox.height, menu.getHeight() + spacingOffset);
		}
		boundingBox.width  += spacingOffset;
		boundingBox.height += spacingOffset;
	}
}
