package generic;

/***************************
 * DON'T YOU DARE USE THIS *
 ***************************/
public interface FunctionPointer<ReturnType, ArgumentType> {
	ReturnType call();
	ReturnType call(ArgumentType arg);
	ReturnType call(@SuppressWarnings("unchecked") ArgumentType... args);
}
