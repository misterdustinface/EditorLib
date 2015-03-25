package generic.structures;

import generic.Reusable;
import generic.tags.Structure;

final public class Pair<A, B> implements Structure, Reusable {
	
	public A first;
	public B second;
	
	public Pair(A FIRST, B SECOND) {
		first  = FIRST;
		second = SECOND;
	}

	@Override
	public void reconstruct() {
		first = null;
		second = null;
	}
	
}