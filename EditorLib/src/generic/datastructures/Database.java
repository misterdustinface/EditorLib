package generic.datastructures;

import generic.Reusable;
import generic.tags.ThreadSafe;


final public class Database <DataType> implements Reusable, ThreadSafe {
	
	final private Table<DataType> data;
	final private Queue<String> giveOrder;
	
	public Database() {
		data = new Table<DataType>();
		giveOrder = new Queue<String>();
	}

	final public synchronized boolean canTake() {
		return !giveOrder.isEmpty();
	}
	
	final public synchronized DataType take() {
		final String name = giveOrder.dequeue();
		return take(name);
	}
	
	public synchronized DataType take(String name) {
		final DataType element = data.get(name);
		removeReferences(name);
		return element;
	}
	
	public synchronized void give(String name, DataType element) {
		data.insert(name, element);
		giveOrder.enqueue(name);
	}
	
	private synchronized void removeReferences(String name) {
		data.remove(name);
		giveOrder.remove(name);
	}

	public synchronized void reconstruct() {
		data.clear();
		giveOrder.clear();
	}

}