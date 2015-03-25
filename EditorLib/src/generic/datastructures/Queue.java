package generic.datastructures;

import generic.Reusable;

import java.util.ArrayList;

final public class Queue <DataType> implements Reusable {
	
	private ArrayList<DataType> q;
	
	public Queue() {
		q = new ArrayList<DataType>();
	}

	public void enqueue(DataType data) {
		q.add(data);
	}
	
	public DataType dequeue() {
		if (isEmpty()) {
			return null;
		} else {
			return q.remove(0);
		}
	}
	
	public DataType peek() {
		if (isEmpty()) {
			return null;
		} else {
			return q.get(0);
		}
	}

	public void clear() {
		q.clear();
	}

	public boolean isEmpty() {
		return q.isEmpty();
	}

	public int size() {
		return q.size();
	}
	
	protected void remove(String name) {
		if (name != null) {
			q.remove(name);
		}
	}

	@Override
	public void reconstruct() {
		q.clear();
	}
	
}