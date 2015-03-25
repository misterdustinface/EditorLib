package generic.datastructures;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final public class Table <ItemType> {

	private Map<String, ItemType> map;
	
	public Table() {
		map = Collections.synchronizedMap(new HashMap<String, ItemType>());
	}
	
	public void insert(String name, ItemType item) {
		if (name != null) {
			map.put(name, item);
		}
	}
	
	public void remove(String name) {
		if (name != null) {
			map.remove(name);
		}
	}
	
	public ItemType get(String name) {
		if (name == null) {
			return null;
		} else {
			return map.get(name);
		}
	}
	
	public boolean contains(String name) {
		if (name == null) {
			return false;
		} else {
			return map.containsKey(name);
		}
	}
	
	public void merge(Table<ItemType> other) {
		if (other != null) {
			map.putAll(other.map);
		}
	}
	
	public void clear() {
		map.clear();
	}
	
	public Set<String> getNames() {
		return map.keySet();
	}

}