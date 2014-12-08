package generic;

public interface FunctionPointer {
	Object call(Object ... args);
	public final static FunctionPointer EMPTY_FUNCTION = new FunctionPointer(){
		@Override
		public Object call(Object ... args) { return null; }
	};
}
