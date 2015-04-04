package notifiers;

import listenerpattern.Listener;
import listenerpattern.Notifier;

abstract public class ChangeNotifier {

	private Notifier notifier;
	
	public ChangeNotifier() {
		notifier = new Notifier();
	}
	
	final public void addChangeListener(Listener listener) {
		notifier.addListener(listener);
	}
	
	final protected void notifyChanged() {
		notifier.notifyListeners();
	}

}