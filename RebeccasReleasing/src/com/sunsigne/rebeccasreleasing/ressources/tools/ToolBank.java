package com.sunsigne.rebeccasreleasing.ressources.tools;

import java.util.HashMap;
import java.util.Map;

public class ToolBank extends ToolIndex {

	/**
	 * WARNING ! Creating a new ToolBank increases by one the static index of the
	 * super class
	 */
	public ToolBank() {
		super();
	}

	////////// MAP OR LIST ////////////

	private static Map<ToolBank, BufferedTool> tools = new HashMap<>();

	// Even if this method is only used in this class, I prefere to let it public
	// to make it easier for modders and devellopers in adding content
	public static void addTool(ToolBank toolBank, BufferedTool bufferedTool) {

		if (bufferedTool != null)
			tools.put(toolBank, bufferedTool);
	}

	public static BufferedTool getTool(ToolBank toolBank) {
		return tools.get(toolBank);
	}

	public static Map<ToolBank, BufferedTool> getClonedMap() {
		var clonedMap = new HashMap<ToolBank, BufferedTool>();
		clonedMap.putAll(tools);
		return clonedMap;
	}

	////////// REFERENCES ////////////

	public static final ToolBank KEY = new ToolBank();
	public static final ToolBank SWORD = new ToolBank();
	public static final ToolBank BOMB = new ToolBank();
	public static final ToolBank GLASS = new ToolBank();
	public static final ToolBank PLIERS = new ToolBank();

	////////// RESSOURCES ////////////

	public static void loadRessources() {

		ToolTask tooltask = new ToolTask();

		addTool(KEY, tooltask.getBufferedToolFromFile(KEY, 2));
		addTool(SWORD, tooltask.getBufferedToolFromFile(SWORD, 3));
		addTool(BOMB, tooltask.getBufferedToolFromFile(BOMB, 4));
		addTool(GLASS, tooltask.getBufferedToolFromFile(GLASS, 5));
		addTool(PLIERS, tooltask.getBufferedToolFromFile(PLIERS, 6));
	}
}
