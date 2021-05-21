package com.sunsigne.rebeccasreleasing.toverify.ressources.tools;

import java.util.HashMap;
import java.util.Map;

import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;

public class ToolBank {

	private static int maxIndex = -1;

	public ToolBank() {
		maxIndex++;
		index = maxIndex;
	}

	private int index;

	public int getIndex() {
		return index;
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

	public static Map<ToolBank, BufferedTool> getMap() {
		return tools;
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

		// gui
		addTool(KEY, tooltask.getBufferedToolFromFile(KEY, 2));
		addTool(SWORD, tooltask.getBufferedToolFromFile(SWORD, 3));
		addTool(BOMB, tooltask.getBufferedToolFromFile(BOMB, 4));
		addTool(GLASS, tooltask.getBufferedToolFromFile(GLASS, 5));
		addTool(PLIERS, tooltask.getBufferedToolFromFile(PLIERS, 6));
	}
}
