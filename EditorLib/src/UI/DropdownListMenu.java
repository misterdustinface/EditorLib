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
	
	public void setRoot(MenuButton ROOT) { 
		root = ROOT;
		root.setButtonPressedFunction(TOGGLE_LIST_MENU);
		buttons.clear();
		buttons.add(root);
	}
	public void setMenu(StaticListMenu MENU) { 
		menu = MENU;
	}
	
	protected void 	  toggleListMenu() { isListMenuOpen = !isListMenuOpen; }
	protected boolean isListMenuOpen() { return isListMenuOpen; }
	
	@Override
	public void update(MouseUserDevice mouse) {
		root.update(mouse);
		if(isListMenuOpen) { menu.update(mouse); }
	}
	
	public void setPosition(Point POSITION) {
		super.setPosition(POSITION);
		root.makeSuggestedBoxRelativeToPoint(position, 0,0); //root.setPosition(POSITION); // TODO
		menu.setPosition(new Point(POSITION.x, POSITION.y + root.getHeight() + buttonOffset));
	}	
	
	public void setButtonOffset(int BUTTON_OFFSET) { 
		super.setButtonOffset(BUTTON_OFFSET);
		root.makeSuggestedBoxRelativeToPoint(position, buttonOffset, buttonOffset);
		menu.setButtonOffset(BUTTON_OFFSET);
	}
	
	public void setButtonSize(int BUTTON_SIZE)     {
		super.setButtonSize(BUTTON_SIZE);
		root.makeBoxRelativeToPoint(position, buttonOffset, buttonOffset, BUTTON_SIZE, BUTTON_SIZE);
		menu.setButtonSize(BUTTON_SIZE);
	}
	
	public void setButtonDimensions(int WIDTH, int HEIGHT) {
		super.setButtonDimensions(WIDTH, HEIGHT);
		root.makeBoxRelativeToPoint(position, buttonOffset, buttonOffset, WIDTH, HEIGHT);
		menu.setButtonDimensions(WIDTH, HEIGHT);
	}
	
	public void setButtons(MenuButton ... BUTTONS) {
		for(int i = 0; i < BUTTONS.length; ++i)
			addButton(BUTTONS[i]);
	}
	
	public void setButtons(ArrayList<MenuButton> BUTTONS) {
		menu.setButtons(BUTTONS);
	}
	
	public void addButton(MenuButton BUTTON) {
		menu.addButton(BUTTON);
	}
	
	public void removeButton(MenuButton BUTTON) {
		menu.removeButton(BUTTON);
	}
	
	public void clearButtons() {
		menu.clearButtons();
	}
	
	public int numberOfButtons() { return menu.buttons.size(); }
	public MenuButton getButton(int index) { return menu.buttons.get(index); }
	
	public int getWidth()  	{ return (int) Math.max(root.getWidth(), menu.getWidth()); }
	public int getHeight() 	{ return (int) (root.getHeight() + buttonOffset + menu.height);}
	
	public boolean contains(MouseUserDevice mouse) {
		return super.contains(mouse) || menu.contains(mouse);
	}

	@Override
	protected void resetMenuDimensions() {
		menu.resetMenuDimensions();
	}

	@Override
	public void refreshButton(int index) {
		menu.refreshButton(index);
	}
}
