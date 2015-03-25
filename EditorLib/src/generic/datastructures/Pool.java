package generic.datastructures;

import generic.Reusable;

import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;

public class Pool <DataType extends Reusable> {

	final private LinkedList<DataType> resources;

	public Pool(int size) {	
		resources = new LinkedList<DataType>();
		allocateResources(size);
	}
	
	public DataType take() {
		if (resources.isEmpty()) {
			throw new RuntimeException("No more resources available in pool.");
		} else {
			return resources.pop();
		}
	}
	
	public void give(DataType element) {
		element.reconstruct();
		resources.push(element);
	}
	
	private void allocateResources(int size) {
		try {
			Class<DataType> type = getTemplateClass();
			for (int i = 0; i < size; ++i)
				resources.push(type.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private Class<DataType> getTemplateClass() {
		return (Class<DataType>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
}