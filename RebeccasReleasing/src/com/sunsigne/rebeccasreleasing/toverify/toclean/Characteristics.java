package com.sunsigne.rebeccasreleasing.toverify.toclean;

import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.ressources.tools.BufferedTool;
import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;

public interface Characteristics {

	static final GameFile hearts = new GameFile("data/characteristics/hearts");

	public BufferedTool getTool(ToolBank toolBank);

	public int getHp();

	public void setHp(int hp);

	public int getMaxHp();

	public void setMaxHp(int hp);

	public default int getMaxHpFromFile() {
		String heartLine = FileTask.read(hearts, 2);
		return Integer.valueOf(heartLine);
	}

}
