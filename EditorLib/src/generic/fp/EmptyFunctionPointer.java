package generic.fp;

final public class EmptyFunctionPointer implements FunctionPointer<Object, Object> {

	public Object call() {
		return null;
	}

	public Object call(Object arg) {
		return null;
	}

	public Object call(Object... args) {
		return null;
	}
	
}