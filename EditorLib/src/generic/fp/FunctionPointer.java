package generic.fp;

/***************************
 * DON'T YOU DARE USE THIS *
 ***************************/
// IT IS NOT DESCRIPTIVE ENOUGH
public interface FunctionPointer<ReturnType, ArgumentType> {
	ReturnType call();
	ReturnType call(ArgumentType arg);
	ReturnType call(@SuppressWarnings("unchecked") ArgumentType... args);
}
