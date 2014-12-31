package UI;

import java.util.ArrayList;

import shapes.Point;

public interface ButtonMenu extends UILayer {
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	
	public void setPosition(Point POSITION);
	
	public void setButtonOffset(int BUTTON_OFFSET);
	public void setButtonSize(int BUTTON_SIZE);
	public void setButtonDimensions(int WIDTH, int HEIGHT);

	public void setButtons(MenuButton ... BUTTONS);
	public void setButtons(ArrayList<MenuButton> BUTTONS);
	
	public void addButton(MenuButton BUTTON);	
	public void removeButton(MenuButton BUTTON);
	public void clearButtons();
	public MenuButton getButton(int index);
	public int numberOfButtons();	
	public void refreshButtons();
	public void refreshButton(int index);
	
	public boolean contains(MouseUserDevice mouse);
}
