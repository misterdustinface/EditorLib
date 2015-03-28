package UI.widgets;

import generic.ListenerPattern.Descriptive.ChangeNotifier;
import shapes.Point;
import shapes.Polygon;
import shapes.Rectangle;

public class TextLabel extends ChangeNotifier {
	
	private enum ALIGNMENT { LEFT, CENTER, RIGHT };
	
	private ALIGNMENT 	alignment;
	private int 		maxChars;
	private String 		text;
	private Point		textLocation;
	
	public TextLabel() {
		text    	 = new String();
		textLocation = new Point(0, 0);
		maxChars     = 10;
		alignment    = ALIGNMENT.LEFT;
	}
	
	public void setText(String TEXT) { 
		text = TEXT;
		onTextModified();
	}
	
	private void onTextModified() {
		if (text.length() > maxChars) {
			text = text.substring(0, maxChars-3);
			text += "...";
		}
		notifyChanged();
	}
	
	public String getText() { 
		return text; 
	}
	
	public void setPosition(Point POS) { 
		textLocation = POS; 
	}
	
	public Point getPosition() { 
		return textLocation; 
	}
	
	public void center() { 
		alignment = ALIGNMENT.CENTER; 
	}
	
	public boolean hasText() { 
		return text.length() > 0;
	}
	
	public void setMaxTextWidth(int maxChars) { 
		this.maxChars = maxChars; 
		onTextModified();
	}
	
	public int getMaxTextWidth() {
		return maxChars;
	}

	public boolean isCentered() { 
		return alignment == ALIGNMENT.CENTER; 
	}
	
	public boolean isRightJustified() { 
		return alignment == ALIGNMENT.RIGHT;  
	}
	
	public boolean isLeftJustified() { 
		return alignment == ALIGNMENT.LEFT;   
	}
	
	public void alignText(Polygon polygon) {
		if (hasText()) {
			Rectangle bounding = polygon.getBoundingRectangle();
			int width  = isCentered() ? text.length() : maxChars; 
			float xoff = width * 3.75f;
			if (isRightJustified()) xoff = -xoff;
			textLocation.set((float)bounding.getCenterX() - xoff, (float)bounding.getCenterY() + 4);
		}
	}

}