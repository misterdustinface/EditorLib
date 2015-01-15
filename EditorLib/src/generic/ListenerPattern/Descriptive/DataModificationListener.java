package generic.ListenerPattern.Descriptive;

public abstract class DataModificationListener {
	final public void notifyListenerAboutDataModification() { whenMyDataIsModifiedExternally(); }
	protected abstract void whenMyDataIsModifiedExternally();
}
