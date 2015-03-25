package generic.ListenerPattern.Descriptive;

import generic.ListenerPattern.Listener;

import java.util.HashMap;

public class SelectiveNotifier<Signifier> {
	
	private HashMap<Signifier, Listener> listeners;
	
	public SelectiveNotifier() {
		listeners = new HashMap<Signifier, Listener>();
	}
	
	final public void addListener(Signifier signifier, Listener listener) {
		listeners.put(signifier, listener);
	}
	
	
	final public void notifyListener(Signifier signifier) {
		listeners.get(signifier).notifyListener();
	}
	
}