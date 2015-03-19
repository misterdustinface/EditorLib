package generic.ListenerPattern.Descriptive;

import generic.ListenerPattern.Notifier;

public class SelectiveNotifier extends Notifier {
	
	final public void notifyListener(int index) {
		listeners.get(index).notifyListener();
	}
	
}
