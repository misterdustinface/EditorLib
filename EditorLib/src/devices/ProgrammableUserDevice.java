package devices;

import java.util.HashMap;

import UI.MouseUserDevice;

public class ProgrammableUserDevice {
	public HashMap<String, UserDeviceButton> buttons;
	public HashMap<String, MouseUserDevice>  directionalSticks;
	
	public ProgrammableUserDevice() {
		buttons = new HashMap<String, UserDeviceButton>();
		directionalSticks = new HashMap<String, MouseUserDevice>();
	}
	
	public void addButton(String name, UserDeviceButton button) {
		buttons.put(name, button);
	}
	
	public void addDirectionalStick(String name, MouseUserDevice stick) {
		directionalSticks.put(name, stick);
	}
}
