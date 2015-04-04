package generic;

import shapes.Polygon;
import base.Reusable;
import datastructures.Table;

public class Layout implements Reusable {

	final private Table<Polygon> components;
	
	public Layout() {
		components = new Table<Polygon>();
	}
	
	public void addComponent(String name, Polygon component) {
		components.insert(name, component);
	}
	
	public Polygon getComponent(String name) {
		return components.get(name);
	}
	
	public void reconstruct() {
		components.clear();
	}

}