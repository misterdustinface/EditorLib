package UI;

import java.util.ArrayList;
import java.util.HashMap;

import UI.StratifiableUI;
import UI.UILayer;

public class UILayerManager implements StratifiableUI {

	private HashMap<UILayer, Boolean> 	shouldShow;
	private ArrayList<UILayer>	  		uis;
	
	public UILayerManager() {
		shouldShow 	= new HashMap<UILayer, Boolean>();
		uis   		= new ArrayList<UILayer>();
	}
	
	public void addLayer(UILayer ui) { 
		uis.add(ui);
		shouldShow.put(ui, true); 
	}
	
	public void addLayers(UILayer... layers) { 
		for (UILayer layer : layers) 
			addLayer(layer);
	}
	
	public void removeLayer(UILayer ui) { 
		uis.remove(ui);
		shouldShow.put(ui, true); 
	}
	
	public void toggleLayer(UILayer ui) { 
		shouldShow.put(ui, !shouldShow.get(ui)); 
	}
	
	private boolean shouldShow(UILayer ui) { 
		return shouldShow.get(ui); 
	}
	
	public void forAllUIPerformFunctionBackToFront(UIFunction functionOnUI) {
		for (UILayer ui : uis) {
			if (shouldShow(ui)) {
				functionOnUI.call(ui);
			}
		}
	}
	
	public void forAllUIPerformFunctionFrontToBack(UIFunction functionOnUI) {
		UILayer ui;
		for (int i = uis.size() - 1; i >= 0; --i) {
			ui = uis.get(i);
			if (shouldShow(ui)) {
				functionOnUI.call(ui);
			}
		}
	}

}