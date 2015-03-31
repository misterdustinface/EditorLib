package generic.datastructures;

import generic.Reusable;
import generic.tags.ThreadSafe;

final public class Datastore <DataType> implements Reusable, ThreadSafe {
	
	final private Table<DataType> data;
	final private Queue<String> orderedDataNames;
	
	public Datastore() {
		data = new Table<DataType>();
		orderedDataNames = new Queue<String>();
	}

	final public synchronized boolean canTake() {
		return !orderedDataNames.isEmpty();
	}
	
	final public synchronized DataType take() {
		final String name = orderedDataNames.dequeue();
		return take(name);
	}
	
	public synchronized DataType take(String name) {
		final DataType element = data.get(name);
		removeReferences(name);
		return element;
	}
	
	public synchronized void give(String name, DataType element) {
		data.insert(name, element);
		orderedDataNames.enqueue(name);
	}
	
	public synchronized void reconstruct() {
		data.clear();
		orderedDataNames.clear();
	}
	
	private synchronized void removeReferences(String name) {
		data.remove(name);
		orderedDataNames.remove(name);
	}

}