package com.sunsigne.rebeccasreleasing.toverify.toclean;

import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.toverify.ressources.GameFile;

public interface Characteristics {

	static final GameFile tools = new GameFile("data/characteristics/tools");
	static final GameFile hearts = new GameFile("data/characteristics/hearts");
	
	public Tool getTool(int num);

	public int getHp();

	public void setHp(int hp);
	
	public int getMaxHp();

	public void setMaxHp(int hp);
	
	public default Tool getToolFromFile(int toolNum) {

		String toolLine = FileTask.read(tools, toolNum + 2);
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
	
	public default int getMaxHpFromFile()
	{
		String heartLine = FileTask.read(hearts, 2);
		return Integer.valueOf(heartLine);
	}

}
