package UI.widgets;

import functionpointers.VoidFunctionPointer;

import java.io.File;

import notifiers.DataModificationNotifier;
import shapes.Polygon;
import shapes.PolygonBuilder;
import structures.Grid;
import UI.UILayer;
import UI.input.MouseUserDevice;

public abstract class FileChooser extends DataModificationNotifier implements UILayer {
	
	final public static String START_DIRECTORY = System.getProperty("user.home");	
	
	public int gridCols = 4;
	public int gridRows = 1;
	
	final private StaticGridMenu fileListing;
	final private MenuButton upButton;
	final private MenuButton exitButton;	
	
	private static String UP_BUTTON_TEXT   = "UP";
	private static String EXIT_BUTTON_TEXT = "EXIT";
	
	private boolean shouldDisplayAndUpdate;
	private File filepath;
	
	public FileChooser() {		
		
		upButton = extendedMenuButton();
		upButton.setText(UP_BUTTON_TEXT);
		Polygon p = PolygonBuilder.makeBox(120, 40);
		p.shift(2, 2);
		upButton.setPolygon(p);
		upButton.setButtonPressedFunction(new VoidFunctionPointer() {
			public void call() {
				if (filepath.getParent() != null) {
					chooseFile(filepath.getParent());
				}
			}
		});
		
		exitButton = extendedMenuButton();
		exitButton.setText(EXIT_BUTTON_TEXT);
		Polygon p2 = PolygonBuilder.makeBox(120, 40);
		p2.shift(124, 2);
		exitButton.setPolygon(p2);
		exitButton.setButtonPressedFunction(new VoidFunctionPointer() {
			public void call() {
				closeChooser();
			}
		});
		
		fileListing = new StaticGridMenu(new Grid(gridRows, gridCols));
		fileListing.setPosition(2, 48);
		fileListing.setButtonDimensions(120, 40);
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

	private void selectAndExit() {
		closeChooser();
		notifyDataModified();
	}
	
	private void closeChooser() {
		shouldDisplayAndUpdate = false;
		fileListing.clearButtons();
	}
	
	public File getChosenFile() { return filepath; }
	
	private void chooseFile(String path) {
		filepath = new File(path);
		if (filepath.isDirectory()) {
			refreshFileListing();
		} else if (filepath.isFile()) {
			selectAndExit();
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
		button.setText(file.getName());
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