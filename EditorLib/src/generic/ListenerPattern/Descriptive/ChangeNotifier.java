package generic.ListenerPattern.Descriptive;

import generic.ListenerPattern.Listener;
import generic.ListenerPattern.Notifier;

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