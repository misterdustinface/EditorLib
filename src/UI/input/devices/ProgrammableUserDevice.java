package UI.input.devices;

import UI.input.MouseUserDevice;
import datastructures.Table;

public class ProgrammableUserDevice {
	
	public Table<UserDeviceButton> buttons;
	public Table<MouseUserDevice>  directionalSticks;
	
	public ProgrammableUserDevice() {
		buttons = new Table<UserDeviceButton>();
		directionalSticks = new Table<MouseUserDevice>();
	}
	
	public void addButton(String name, UserDeviceButton button) {
		buttons.insert(name, button);
	}
	
	public void addDirectionalStick(String name, MouseUserDevice stick) {
		directionalSticks.insert(name, stick);
	}
	
}