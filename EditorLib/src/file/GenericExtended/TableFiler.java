package file.GenericExtended;

import file.LuaScriptFiler;
import generic.Table;

public class TableFiler <ItemType> extends LuaScriptFiler {

	private Table<ItemType> loadedTable;
	private Table<ItemType> table;
	
	public TableFiler() {}
	public TableFiler(Table<ItemType> TABLE) {
		setTable(TABLE);
	}
	
	public void setTable(Table<ItemType> TABLE) { table = TABLE; }
	
	@Override
	protected void preparseOperation() {
		loadedTable = new Table<ItemType>();
	}

	@Override
	protected void postparseOperation() {
		table.merge(loadedTable);
	}

	@Override
	protected void parseLine(String line) {
		String   name = parseNameFromLine(line);
		ItemType item = parseItemFromLine(line);
		loadedTable.insert(name, item);
	}

	@Override
	protected String dataToLuaScript() {
		String script = new String();
		for(String name : table.getNames()) {
			script += createEntry(name, table.getItem(name).toString());
		}
		return scriptHeading("Start of Table") + script + scriptCloser("End of Table");
	}

	private String parseNameFromLine(String line) {
		throw new RuntimeException("Parsing not yet implemented");
	}
	
	private ItemType parseItemFromLine(String line) {
		throw new RuntimeException("Parsing not yet implemented");
	}

//	private ColorData parseColorDataFromLine(String line) {
//		String[] entries = super.parseEntries(line);
//		int[] hues = new int[] {Integer.parseInt(entries[0]),Integer.parseInt(entries[1]),
//								Integer.parseInt(entries[2]),Integer.parseInt(entries[3])};
//		return new ColorData(hues);
//	}
	
}
