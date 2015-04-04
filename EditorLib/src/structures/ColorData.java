package structures;

import tags.Structure;
import base.Reusable;

final public class ColorData implements Cloneable, Structure, Reusable {
	
	final private static int COLOR_RANGE = 255;
	public float r, g, b, a;
	
	public ColorData() {
		this(1.0f, 1.0f, 1.0f, 1.0f);
	}
	
	public ColorData(float R, float G, float B, float A) {
		r = R; 
		g = G; 
		b = B; 
		a = A;
	}
	
	public ColorData(int R, int G, int B, int A) {
		this((float)R/COLOR_RANGE, 
			 (float)G/COLOR_RANGE, 
			 (float)B/COLOR_RANGE, 
			 (float)A/COLOR_RANGE);
	}
	
	public ColorData(int[] RGBA) {
		this((float)RGBA[0]/COLOR_RANGE, 
			 (float)RGBA[1]/COLOR_RANGE, 
			 (float)RGBA[2]/COLOR_RANGE, 
			 (float)RGBA[3]/COLOR_RANGE);
	}
	
	public ColorData(float[] RGBA) {
		this(RGBA[0], RGBA[1], RGBA[2], RGBA[3]);
	}
	
	public ColorData clone() {
		return new ColorData(r, g, b, a);
	}

	public void reconstruct() {
		r = 1.0f;
		g = 1.0f;
		b = 1.0f;
		a = 1.0f;
	}
	
}