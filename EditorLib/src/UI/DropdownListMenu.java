package UI;

import java.util.ArrayList;

import shapes.Point;
import generic.VoidFunctionPointer;

public class DropdownListMenu extends UIMenu {
	protected MenuButton 	 root;
	protected StaticListMenu menu;
	private   boolean isListMenuOpen;
	
	private final VoidFunctionPointer TOGGLE_LIST_MENU = new VoidFunctionPointer() {
		@Override
		public void call() {
			toggleListMenu();
		}
	};
	
	public DropdownListMenu() {
		isListMenuOpen = false;
	}
	
	final public void setRoot(MenuButton ROOT) { 
		root = ROOT;
		root.setButtonPressedFunction(TOGGLE_LIST_MENU);
		buttons.clear();
		buttons.add(root);
	}
	final public void setMenu(StaticListMenu MENU) { 
		menu = MENU;
	}
	
	final protected void 	toggleListMenu() { isListMenuOpen = !isListMenuOpen; }
	final protected boolean isListMenuOpen() { return isListMenuOpen; }
	
	@Override
	final public void update(MouseUserDevice mouse) {
		root.update(mouse);
		if(isListMenuOpen) { 
			menu.update(mouse); 
		}
	}
	
	final public void setPosition(Point POSITION) {
		super.setPosition(POSITION);
		root.makeSuggestedBoxRelativeToPoint(position, 0,0); //root.setPosition(POSITION); // TODO
		menu.setPosition(new Point(POSITION.x, POSITION.y + root.getHeight() + buttonOffset));
	}	
	
	final public void setButtonOffset(int BUTTON_OFFSET) { 
		super.setButtonOffset(BUTTON_OFFSET);
		root.makeSuggestedBoxRelativeToPoint(position, buttonOffset, buttonOffset);
		menu.setButtonOffset(BUTTON_OFFSET);
	}
	
	final public void setButtonSize(int BUTTON_SIZE)     {
		super.setButtonSize(BUTTON_SIZE);
		root.makeBoxRelativeToPoint(position, buttonOffset, buttonOffset, BUTTON_SIZE, BUTTON_SIZE);
		menu.setButtonSize(BUTTON_SIZE);
	}
	
	final public void setButtonDimensions(int WIDTH, int HEIGHT) {
		super.setButtonDimensions(WIDTH, HEIGHT);
		root.makeBoxRelativeToPoint(position, buttonOffset, buttonOffset, WIDTH, HEIGHT);
		menu.setButtonDimensions(WIDTH, HEIGHT);
	}
	
	final public void setButtons(MenuButton ... BUTTONS) {
		for(int i = 0; i < BUTTONS.length; ++i)
			addButton(BUTTONS[i]);
	}
	
	final public void setButtons(ArrayList<MenuButton> BUTTONS) {
		menu.setButtons(BUTTONS);
	}
	
	final public void addButton(MenuButton BUTTON) {
		menu.addButton(BUTTON);
	}
	
	final public void removeButton(MenuButton BUTTON) {
		menu.removeButton(BUTTON);
	}
	
	final public void clearButtons() {
		menu.clearButtons();
	}
	
	final public int numberOfButtons() { return menu.buttons.size(); }
	final public MenuButton getButton(int index) { return menu.buttons.get(index); }
	
	final public int getWidth()  	{ return (int) Math.max(root.getWidth(), menu.getWidth()); }
	final public int getHeight() 	{ return (int) (root.getHeight() + buttonOffset + menu.height);}
	
	final public boolean contains(MouseUserDevice mouse) {
		return super.contains(mouse) || menu.contains(mouse);
	}

	@Override
	final public void resetMenuDimensions() {
		menu.resetMenuDimensions();
	}

	@Override
	final public void refreshButton(int index) {
		menu.refreshButton(index);
	}
}
