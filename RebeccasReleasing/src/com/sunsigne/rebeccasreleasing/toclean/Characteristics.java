package com.sunsigne.rebeccasreleasing.toclean;

import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;

public class Characteristics {

	private static final GameFile characteristics = new GameFile("characteristics");
	public Tool[] tools = new Tool[4];

	public Characteristics() {
		tools[Tool.KEY] = creationOfToolFromToolNumWithSavedData(Tool.KEY);
		tools[Tool.SWORD] = creationOfToolFromToolNumWithSavedData(Tool.SWORD);
		tools[Tool.BOMB] = creationOfToolFromToolNumWithSavedData(Tool.BOMB);
		tools[Tool.SEARCH] = creationOfToolFromToolNumWithSavedData(Tool.SEARCH);
	}

	public Tool getTool(int num) {
		return tools[num];
	}


	private Tool creationOfToolFromToolNumWithSavedData(int toolNum) {

		String toolLine = FileTask.read(characteristics, toolNum + 2);
		// the + 2 stand here because the first line should correspond
		// to tool 0 (the key) -> line 1 = tool 0 -> +1, but as the first
		// line is descriptive, the actual data start line 2 -> +1 again
		
		String[] dataIntoLine = new String[4];		
		int currentLvl = 0;
		int maxLvl = 0;

		dataIntoLine = toolLine.split(";");		
		currentLvl = Integer.valueOf(dataIntoLine[2]);
		maxLvl = Integer.valueOf(dataIntoLine[3]);
		
		return new Tool(toolNum, currentLvl, maxLvl);
	}

}
