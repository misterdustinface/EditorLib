package UI.input;

public class MouseUserDeviceWrapper {

	private MouseUserDevice mouseUserDevice;
	
	public MouseUserDeviceWrapper() {
		
	}
	
	public void set(MouseUserDevice MOUSE_USER_DEVICE) {
		mouseUserDevice = MOUSE_USER_DEVICE;
	}
	
	public void forceClick() {
		mouseUserDevice.click();
	}
	
	public void forcePress() {
		mouseUserDevice.press();
	}
	
	public void forceRelease() {
		mouseUserDevice.release();
	}
	
	public void forceButton(String button) {
		mouseUserDevice.setButton(button);
	}
	
	public void forcePosition(float x, float y) {
		mouseUserDevice.cursorPosition.set(x, y);
	}
	
}