package generic.datastructures;

import generic.tags.NamedData;

public class Property <PropertyValue> implements NamedData {

	private Table<PropertyValue> elements;
	private PropertyValue defaultValue;
	
	public Property() {
		elements = new Table<PropertyValue>();
	}
	
	public void setDefaultValue(PropertyValue defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	public void add(String nameOfElementThatConformsToThisProperty, PropertyValue value) {
		elements.insert(nameOfElementThatConformsToThisProperty, value);
	}
	
	public PropertyValue of(String nameOfElementThatConformsToThisProperty) {
		if (! elements.contains(nameOfElementThatConformsToThisProperty)) {
			return defaultValue;
		} else {
			return elements.get(nameOfElementThatConformsToThisProperty);
		}
	}
	
}
