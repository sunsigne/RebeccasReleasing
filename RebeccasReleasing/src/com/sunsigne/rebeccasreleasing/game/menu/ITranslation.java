package com.sunsigne.rebeccasreleasing.game.menu;

import com.sunsigne.rebeccasreleasing.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.system.Conductor;

public interface ITranslation {

	public GameFile getGameFile(int number);

	public void setGameFile(int number, GameFile gameFile);

	// use this method in the cronstructor of the class you want to be translated
	
	public default void languageMapping(ChatMap chatMap, ChatMap... chatMaps) {
		int size = chatMaps.length;

		textAttributionByLanguage(chatMap);

		if (size != 0) {
			for (int i = 0; i < size; i++)
				textAttributionByLanguage(chatMaps[i]);
		}
	}

	private void textAttributionByLanguage(ChatMap chatMap) {

		LANGUAGE language = chatMap.getLanguage();
		switch (language) {
		case FRENCH:
			setGameFile(2, chatMap.getGameFile());
			break;
		case ENGLISH:
		default:
			setGameFile(1, chatMap.getGameFile());
			break;
		}
	}

	private String verified(GameFile gamefile) {
		if (gamefile != null)
			return FileTask.read(gamefile);

		// if language not found, return the first valid language
		else {
			int size = LANGUAGE.TOTALNUM + 1;
			for (int i = 0; i < size; i++)
				if (getGameFile(i) != null)
					return FileTask.read(getGameFile(i));
		}
		Conductor.fatalError(
				"An unknown error has occured : couldn't correcly make a link between a text and an existing Language");
		return null;
	}

	private String verified(GameFile gamefile, int lineToRead) {
		if (gamefile != null)
			return FileTask.read(gamefile, lineToRead);

		// if language not found, return the first valid language
		else {
			int size = LANGUAGE.TOTALNUM + 1;
			for (int i = 0; i < size; i++)
				if (getGameFile(i) != null)
					return FileTask.read(getGameFile(i), lineToRead);
		}
		Conductor.fatalError(
				"An unknown error has occured : couldn't correcly make a link between a text and an existing Language");
		return null;
	}

	// use those methods to get data from your file

	public default String readDataFromFile() {
		switch (Options.getLanguage()) {
		case FRENCH:
			return verified(getGameFile(2));
		case ENGLISH:
		default:
			return verified(getGameFile(1));
		}
	}

	public default String readDataFromFile(int lineToRead) {
		switch (Options.getLanguage()) {
		case FRENCH:
			return verified(getGameFile(2), lineToRead);
		case ENGLISH:
		default:
			return verified(getGameFile(1), lineToRead);
		}
	}
		
	public default GameText getGameTextFromFile(int line)
	{
		String dataText = readDataFromFile(line);
		String[] dataIntoLine = new String[3];
		int gap;
		String text;
				
		dataIntoLine = dataText.split(";");
		gap = Integer.valueOf(dataIntoLine[1]);
		text = String.valueOf(dataIntoLine[2]).replace("\"", "");

		GameText gametext = new GameText(gap, text);
		
		return gametext;
	}


}
