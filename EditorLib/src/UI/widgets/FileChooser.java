package UI.widgets;

import generic.ListenerPattern.Descriptive.DataModificationNotifier;
import generic.fp.VoidFunctionPointer;
import generic.structures.Grid;

import java.io.File;

import UI.UILayer;
import UI.input.MouseUserDevice;
import shapes.Point;
import shapes.Polygon;
import shapes.PolygonBuilder;

public abstract class FileChooser extends DataModificationNotifier implements UILayer {
	
	public static String START_DIRECTORY = System.getProperty("user.home");
	public int gridRows = 4;
	public int gridCols = 4;
	
	private StaticGridMenu 	fileListing;
	private MenuButton     	upButton;
	private MenuButton	  	exitButton;	
	private boolean shouldDisplayAndUpdate;
	
	private File filepath;
	
	private static String UP_BUTTON_TEXT   = "UP";
	private static String EXIT_BUTTON_TEXT = "EXIT";
	
	public FileChooser() {		
		
		upButton = extendedMenuButton();
		upButton.textLabel.setText(UP_BUTTON_TEXT);
		upButton.textLabel.center();
		Polygon p = PolygonBuilder.makeBox(120, 40);
		p.shift(2, 2);
		upButton.setPolygon(p);
		upButton.setButtonPressedFunction(new VoidFunctionPointer() {
			public void call() {
				chooseFile(filepath.getParent());
			}
		});
		
		exitButton = extendedMenuButton();
		exitButton.textLabel.setText(EXIT_BUTTON_TEXT);
		exitButton.textLabel.center();
		Polygon p2 = PolygonBuilder.makeBox(120, 40);
		p2.shift(124, 2);
		exitButton.setPolygon(p2);
		exitButton.setButtonPressedFunction(new VoidFunctionPointer() {
			public void call() {
				exit();
			}
		});
		
		fileListing = new StaticGridMenu(new Grid(gridRows,gridCols));
		fileListing.setPosition(new Point(2,48));
		fileListing.setButtonDimensions(140, 40);
		fileListing.setButtonOffset(4);
		
		shouldDisplayAndUpdate = false;
	}
	
	public boolean shouldDisplayAndUpdate() { return shouldDisplayAndUpdate; }
	public StaticGridMenu getFileListing() { return fileListing; }
	public MenuButton getUpButton() { return upButton; }
	public MenuButton getExitButton() { return exitButton; }
	
	protected abstract MenuButton extendedMenuButton();
	
	public void chooseFile() {
		shouldDisplayAndUpdate = true;
		chooseFile(START_DIRECTORY);
	}

	public void exit() {
		shouldDisplayAndUpdate = false;
		notifyDataModified();
		fileListing.clearButtons();
	}
	
	public File getChosenFile() { return filepath; }
	
	private void chooseFile(String path) {
		filepath = new File(path);
		if (filepath.isDirectory()) {
			refreshFileListing();
		} else if (filepath.isFile()) {
			exit();
		}
	}
	
	private void refreshFileListing() {
		fileListing.clearButtons();
		
		final File[] files = filepath.listFiles();
		resizeGridToFitFiles(files.length);
		int filecount = 0;
		
		for (File file : files) {
			if (!file.isHidden()) {
				MenuButton button = makeFileChooserButton(file);
				fileListing.addButton(button);
				final String PATH = file.getPath();
				button.setButtonPressedFunction(new VoidFunctionPointer() {
					public void call() {
						chooseFile(PATH);
					}
				});
				filecount++;
			}
		}
		
		resizeGridToFitFiles(filecount);
		
	}
	
	private MenuButton makeFileChooserButton(File file) {
		MenuButton button = extendedMenuButton();
		button.textLabel.setMaxTextWidth(20);
		button.textLabel.setText(file.getName());
		button.textLabel.center();
		
		Polygon p = PolygonBuilder.makeBox(120, 40);
		p.shift(getFileListing().getX(), getFileListing().getY());
		button.setPolygon(p);

		return button;
	}
	
	private void resizeGridToFitFiles(int numberOfFiles) {
		gridCols = gridCols < 1 ? 1 : gridCols;
		gridRows = (numberOfFiles / gridCols) + (numberOfFiles % gridCols);
		gridRows = gridRows < 1 ? 1 : gridRows;
		fileListing.setGridDimensions(gridRows, gridCols);
	}
	
	public void update(MouseUserDevice mouse) {
		if (shouldDisplayAndUpdate) {
			upButton.update(mouse);
			exitButton.update(mouse);
			try {
				fileListing.update(mouse);
			} catch (Exception e) {
				
			}
			mouse.intercept();
		}
	}
	
}