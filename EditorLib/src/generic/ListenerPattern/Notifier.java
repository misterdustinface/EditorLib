package generic.ListenerPattern;

import java.util.ArrayList;

public class Notifier {
	private ArrayList<Listener> listeners;
	
	public Notifier() {
		listeners = new ArrayList<Listener>();
	}
	
	final public void addListener(Listener listener) {
		listeners.add(listener);
	}
	
	final public void notifyListeners() {
		for (Listener listener : listeners) {
			listener.notifyListener();
		}
	}
}
