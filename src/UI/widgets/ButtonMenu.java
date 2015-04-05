package UI.widgets;

import UI.UILayer;
import UI.input.MouseUserDevice;

public interface ButtonMenu extends UILayer, Iterable<MenuButton> {
	public float getX();
	public float getY();
	public float getWidth();
	public float getHeight();
	public void setPosition(float x, float y);
	
	public void setButtonOffset(float BUTTON_OFFSET);
	public void setButtonSize(float BUTTON_SIZE);
	public void setButtonDimensions(float WIDTH, float HEIGHT);

	public void setButtons(MenuButton ... BUTTONS);
	public void addButton(MenuButton BUTTON);	
	public void removeButton(MenuButton BUTTON);
	public void clearButtons();
	
	public int numberOfButtons();	
	public void refreshButtons();
	public void refreshButton(int index);
	public MenuButton getButton(int index);
	
	public boolean contains(MouseUserDevice mouse);
}
