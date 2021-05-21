package com.sunsigne.rebeccasreleasing.ressources.tools;

import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.GameText;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.ITranslation;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;

public class ToolTask implements ITranslation {

	private static final GameFile loc = new GameFile("data/characteristics/tools");

	private static final ChatMap fr = new ChatMap(LANGUAGE.FRENCH, new GameFile("texts/french/tool"));
	private static final ChatMap eng = new ChatMap(LANGUAGE.ENGLISH, new GameFile("texts/english/tool"));
	private static final ChatMap custom = new ChatMap(LANGUAGE.CUSTOM, new GameFile("texts/custom/tool"));

	public ToolTask() {
		languageMapping(fr, eng, custom);
	}

	public BufferedTool getBufferedToolFromFile(ToolBank toolBank, int line) {

		String toolLine = FileTask.read(loc, line);
		GameText gametext = getGameTextFromFile(line);

		String[] dataIntoLine = new String[4];
		int currentLvl = 0;
		int maxLvl = 0;

		dataIntoLine = toolLine.split(";");
		currentLvl = Integer.valueOf(dataIntoLine[2]);
		maxLvl = Integer.valueOf(dataIntoLine[3]);

		return new BufferedTool(toolBank, gametext.getText(), currentLvl, maxLvl);
	}

	////////// LANGUAGE ////////////

	private final GameFile[] gamefileFromLang = new GameFile[LANGUAGE.getTotalLanguages() + 1];

	@Override
	public GameFile getGameFile(int number) {
		return gamefileFromLang[number];
	}

	@Override
	public void setGameFile(int number, GameFile gameFile) {
		this.gamefileFromLang[number] = gameFile;
	}

}
