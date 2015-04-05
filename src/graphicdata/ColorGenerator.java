package graphicdata;

import java.util.Random;

import structures.ColorData;
import tags.Library;

final public class ColorGenerator implements Library {
	
	private ColorGenerator () {
		
	}
	
	public static ColorData randomColor() {
		return new ColorData((float)Math.random(), (float)Math.random(), (float)Math.random(), 0.0f);
	}
	
	//http://stackoverflow.com/questions/43044/algorithm-to-randomly-generate-an-aesthetically-pleasing-color-palette
	public static ColorData randomPastel() {
		return new ColorData((float)Math.random()/2, (float)Math.random()/2, (float)Math.random()/2, 0.0f);
	}
	
	//http://stackoverflow.com/questions/43044/algorithm-to-randomly-generate-an-aesthetically-pleasing-color-palette
	public static ColorData mixColor(ColorData mix) {
	    Random random = new Random();
	    float red   = (int) ((random.nextFloat() + mix.r) / 2);
	    float green = (int) ((random.nextFloat() + mix.g) / 2);
	    float blue  = (int) ((random.nextFloat() + mix.b) / 2);
	    return new ColorData(red, green, blue, 0);
	}
	
	public static ColorData getCompliment(ColorData primary) {
		return new ColorData(1 - primary.r, 1 - primary.g, 1 - primary.b, 0);
	}
	
	public static ColorData getIntermediateColor(ColorData primary, ColorData secondary) {
		return new ColorData((primary.r + secondary.r)/2,
							 (primary.g + secondary.g)/2,
							 (primary.b + secondary.b)/2,
							 (primary.a + secondary.a)/2 );
	}
	
}