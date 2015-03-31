package UI.widgets;

import java.util.ArrayList;

import shapes.Rectangle;
import UI.AntiViewport;
import UI.UILayer;
import UI.Viewport;
import UI.input.MouseUserDevice;

public class MenuBar extends AntiViewport implements UILayer {

	protected ArrayList<ButtonMenu> menus;
	protected Rectangle			boundingBox;
	private   int 				spacingOffset;
	private   float				xOffset, yOffset;

	public MenuBar() {
		boundingBox = new Rectangle(0,0,0,0);
		menus = new ArrayList<ButtonMenu>();
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
		super.setViewport(VIEWPORT);
		setBoundingBoxPosition();
	}
	
	private void setBoundingBoxPosition() {
		boundingBox.setPosition(getXPosition() + xOffset, getYPosition() + yOffset);
	}
	
	public void addUIMenu(ButtonMenu MENU) {
		menus.add(MENU);
		updateMenuPositions();
		updateMenuOffsets();
		calculateDimensions();
	}
	
	public void addUIMenus(ButtonMenu ... MENUS) {
		for (ButtonMenu menu : MENUS) {
			menus.add(menu);
		}
		updateMenuPositions();
		updateMenuOffsets();
		calculateDimensions();
	}
	
	public void removeUIMenu(ButtonMenu MENU) {
		menus.remove(MENU);
		updateMenuPositions();
		updateMenuOffsets();
		calculateDimensions();
	}

	public void update(MouseUserDevice mouse) {
		setBoundingBoxPosition();
		updateMenuPositions();
		updateMenus(mouse);
		if (isMouseInMenuBarBoundingBox(mouse)) {
			mouse.intercept();
		}
	}
	
	private void updateMenuPositions() {
		float x = boundingBox.x + spacingOffset;
		float y = boundingBox.y + spacingOffset;
		for (ButtonMenu menu : menus) {
			menu.setPosition(x, y);
			x += menu.getWidth() + spacingOffset;
		}
	}
	
	private void updateMenuOffsets() {
		for (ButtonMenu menu : menus) {
			menu.setButtonOffset(spacingOffset);
		}
	}
	
	protected boolean isMouseInMenuBarBoundingBox(MouseUserDevice mouse) {
		return boundingBox.contains(mouse.getCursorPosition());
	}
	
	private void updateMenus(MouseUserDevice mouse) {
		for (ButtonMenu menu : menus) {
			menu.update(mouse);
		}
	}
	
	private void calculateDimensions() {
		boundingBox.width  = 0;
		boundingBox.height = 0;
		for (ButtonMenu menu : menus) {
			boundingBox.width += menu.getWidth() + spacingOffset;
			boundingBox.height = Math.max(boundingBox.height, menu.getHeight() + spacingOffset);
		}
		boundingBox.width += spacingOffset;
	}

}