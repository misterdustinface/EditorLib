package rendering;

import shapes.Point;
import UI.widgets.BarSlider;
import UI.widgets.FileChooser;
import UI.widgets.MenuButton;
import UI.widgets.TextLabel;
import UI.widgets.UIMenu;

public interface MenuDrawer {
	void drawMenuBox         	( Point topLeft, int width, int height);
	void drawMenuBox			( int X, int Y, int width, int height);
	void drawButton       		( MenuButton b );
	void drawSlider       		( BarSlider s );
	void drawSelectorArrow		( MenuButton b, int x, int size );
	void drawPlusOnButton 		( MenuButton b );
	void drawTextLabel          ( TextLabel tl);
	void drawUIMenu       		( UIMenu menu );
	void drawFileChooser		( FileChooser fileChooser );
}
