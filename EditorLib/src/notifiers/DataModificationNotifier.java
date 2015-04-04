package notifiers;

import java.util.ArrayList;

import listeners.DataModificationListener;

abstract public class DataModificationNotifier {

	private ArrayList<DataModificationListener> dataModificationListeners;
	
	public DataModificationNotifier() {
		dataModificationListeners = new ArrayList<DataModificationListener>();
	}
	
	final public void addDataModificationListener(DataModificationListener listener) {
		dataModificationListeners.add(listener);
	}
	
	final protected void notifyDataModified() {
		for (DataModificationListener listener : dataModificationListeners) {
			listener.notifyListenerAboutDataModification();
		}
	}

}