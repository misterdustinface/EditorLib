package generic.fp;

public interface VoidFunctionPointer {
	void call();
	
	public final static VoidFunctionPointer EMPTY_FUNCTION = new VoidFunctionPointer() {
		@Override
		public void call() { }
	};
}
