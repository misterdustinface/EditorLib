package generic.structures;

import generic.tags.Structure;

final public class Pair<A, B> implements Structure {
	
	public A first;
	public B second;
	
	public Pair(A FIRST, B SECOND) {
		first  = FIRST;
		second = SECOND;
	}
	
}