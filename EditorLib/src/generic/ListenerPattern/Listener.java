package generic.ListenerPattern;

public abstract class Listener {
	final public void notifyListener() { 
		whenNotified(); 
	}
	protected abstract void whenNotified();
}
