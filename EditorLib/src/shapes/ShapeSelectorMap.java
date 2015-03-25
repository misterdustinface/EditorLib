package shapes;

import java.util.ArrayList;
import java.util.HashMap;

public class ShapeSelectorMap{
	
	private HashMap<Long, Boolean> shapeSelectionMap;
	
	public ShapeSelectorMap(){
		shapeSelectionMap = new HashMap<Long, Boolean>();
	}
	
	private static Long hash(Shape s) { 
		return s.ID(); 
	}
	
	public boolean isSelected(Shape s) { 
		return shapeSelectionMap.get(hash(s));
	}
	
	public void toggleSelected(Shape s) { 
		shapeSelectionMap.put(hash(s), !isSelected(s)); 
	}
	
	public void select(Shape s) {
		shapeSelectionMap.put(hash(s), true);
	}

	public void put(Shape s) {
		shapeSelectionMap.put(hash(s), false);
	}
	
	public void putWithSelected(Shape s) {
		shapeSelectionMap.put(hash(s), true);
	}
	
	public void remove(Shape s) {
		shapeSelectionMap.remove(hash(s));
	}
	
	public void putWithAllSelected(ArrayList<Shape> shapes) {
		for (Shape s : shapes) 
			putWithSelected(s);
	}
	
	public void remove(ArrayList<Shape> shapes) {
		for (Shape s : shapes) 
			remove(s);
	}

}