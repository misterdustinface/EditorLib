package generic.datastructures;

import generic.tags.NamedData;

public class Properties implements NamedData {
	
	@SuppressWarnings("rawtypes")
	private Table<Property> properties;
	
	@SuppressWarnings("rawtypes")
	public Properties() {
		properties = new Table<Property>();
	}

	@SuppressWarnings("rawtypes")
	public void addProperty(String name, Property prop) {
		properties.insert(name, prop);
	}
	
	@SuppressWarnings("rawtypes")
	public Property getProperty(String name) {
		return properties.get(name);
	}
	
}