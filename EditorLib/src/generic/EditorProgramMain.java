package generic;

import generic.fp.VoidFunctionPointer;
import UI.UIFunction;
import UI.UILayer;
import UI.UILayerManager;
import UI.input.MouseUserDevice;

public class EditorProgramMain extends TickingLoop {

	public static TickingLoop create(UILayerManager LAYER_MANAGER, MouseUserDevice MOUSE_USER_DEVICE) {
		return new EditorProgramMain(LAYER_MANAGER, MOUSE_USER_DEVICE);
	}
	
	protected MouseUserDevice mouse;
	protected UILayerManager layerManager;
	protected UIFunction uiUpdate = new UIFunction() {
		public void call(UILayer ui) {
			if (!mouse.isIntercepted()) {
				ui.update(mouse);
			}
		}
	};
	
	private EditorProgramMain(UILayerManager LAYER_MANAGER, MouseUserDevice MOUSE_USER_DEVICE) {
		super();
		
		layerManager 	= LAYER_MANAGER;
		mouse 			= MOUSE_USER_DEVICE;
		
		super.addFunction(new VoidFunctionPointer() {
			public void call() {
				layerManager.forAllUIPerformFunctionFrontToBack(uiUpdate);
			}
		});
	}
	
}