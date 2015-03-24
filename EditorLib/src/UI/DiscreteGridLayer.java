package UI;

import generic.ListenerPattern.Listener;


public interface DiscreteGridLayer extends UILayer, Tiled, SelectableTileGrid {
	int getMouseoverRow();
	int getMouseoverCol();
	void addTileSelectedListener(Listener listener);
}
