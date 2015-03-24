package generic.fp;

final public class EmptyFunctionPointer implements FunctionPointer<Object, Object> {
	@Override
	public Object call() {
		return null;
	}
	@Override
	public Object call(Object arg) {
		return null;
	}
	@Override
	public Object call(Object... args) {
		return null;
	}
}
