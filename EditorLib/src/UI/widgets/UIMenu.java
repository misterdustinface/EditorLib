package UI.widgets;

import java.util.ArrayList;
import java.util.Iterator;

import UI.input.MouseUserDevice;
import shapes.Point;

public abstract class UIMenu implements ButtonMenu {
	
	protected Point position;
	protected ArrayList<MenuButton> buttons;
	protected float width, height, buttonOffset, buttonWidth, buttonHeight;
	
	public UIMenu() {
		buttons = new ArrayList<MenuButton>();
		buttonOffset = 20;
		buttonWidth = buttonHeight = 40;
		width = height = 140;
		position = new Point(0,0);
	}
	
	abstract protected void resetMenuDimensions();

	public float getX() { 
		return position.x; 
	}
	
	public float getY() { 
		return position.y; 
	}
	
	public float getWidth() { 
		return width; 
	}
	
	public float getHeight() { 
		return height;
	}
	
	public void setPosition(float x, float y) {
		position.set(x, y);
		refreshButtons();
	}
	
	public void setButtonOffset(float BUTTON_OFFSET) { 
		buttonOffset = BUTTON_OFFSET; 
		resetMenuDimensions();
		refreshButtons();
	}
	
	public void setButtonSize(float BUTTON_SIZE) {
		buttonWidth = buttonHeight = BUTTON_SIZE;
		resetMenuDimensions();
		refreshButtons();
	}
	
	public void setButtonDimensions(float WIDTH, float HEIGHT) {
		buttonWidth  = WIDTH;
		buttonHeight = HEIGHT;
		resetMenuDimensions();
		refreshButtons();
	}
	
	public void setButtons(MenuButton ... BUTTONS) {
		for (int i = 0; i < BUTTONS.length; ++i)
			addButton(BUTTONS[i]);
	}
	
	public void addButton(MenuButton BUTTON) {
		buttons.add(BUTTON);
		resetMenuDimensions();
		refreshButtons();
	}
	
	public void removeButton(MenuButton BUTTON) {
		buttons.remove(BUTTON);
		resetMenuDimensions();
		refreshButtons();
	}
	
	public void clearButtons() {
		buttons.clear();
		resetMenuDimensions();
	}
	
	public void refreshButtons() {
		for (int i = 0; i < numberOfButtons(); ++i)
			refreshButton(i);
	}
	
	abstract public void refreshButton(int index);
	
	public int numberOfButtons() { 
		return buttons.size(); 
	}
	
	public MenuButton getButton(int index) { 
		return buttons.get(index); 
	}
	
	public boolean contains(MouseUserDevice mouse) {
		return getX() <= mouse.getCursorX() && mouse.getCursorX() <= getX() + getWidth()
			&& getY() <= mouse.getCursorY() && mouse.getCursorY() <= getY() + getHeight();
	}
	
	public void update(MouseUserDevice mouse) {
		if (contains(mouse)) {
			for (MenuButton button : buttons) {
				button.update(mouse);
			}
		}
	}
	
	protected float getSuggestedDimension(float buttonOffset, float buttonSize, int numButtonsAcross) {
		return (((numButtonsAcross+1) * buttonOffset) + ((numButtonsAcross) * buttonSize));
	}

	public Iterator<MenuButton> iterator() {
		
		return new Iterator<MenuButton>() {

			private int i = 0;

			public boolean hasNext() {
				return i < numberOfButtons();
			}

			public MenuButton next() {
				return getButton(i++);
			}

			public void remove() {
				removeButton(getButton(i));
			}
		};
	}
	
}