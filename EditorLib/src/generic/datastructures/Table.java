package generic.datastructures;

import java.util.HashMap;
import java.util.Set;

public class Table <ItemType> {

	private HashMap<String, ItemType> map;
	
	public Table() {
		map = new HashMap<String, ItemType>();
	}
	
	public void insert(String name, ItemType item) {
		map.put(name, item);
	}
	
	public void remove(String name) {
		map.remove(name);
	}
	
	public ItemType getItem(String name) {
		return map.get(name);
	}
	
	public void merge(Table<ItemType> other) {
		map.putAll(other.map);
	}
	
	public void clear() {
		map.clear();
	}
	
	public Set<String> getNames() {
		return map.keySet();
	}
}
