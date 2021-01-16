package com.sunsigne.rebeccasreleasing.game.chat;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Conductor;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.IClick;

import objects.characters.CHARA;

public abstract class ChatBuilder extends Clickable implements IClick {

	protected static final int MAX_LINES_FOR_SAME_DIALOGUE = 255;
	
	protected ChatObject[] chatObject = new ChatObject[MAX_LINES_FOR_SAME_DIALOGUE];
	private String[] filenameFromLang = new String[LANGUAGE.TOTALNUM + 1];	

	
	/**
	 * WARNING ! Because of the fonctions mouse.clearClickable() and
	 * HandlerObject.getInstance().clearFront(); starting a chat would cause various
	 * bugs if a clickable (like a puzzle for exemple) is already open.
	 */
	public ChatBuilder(int chatID, ChatMap chatMap, ChatMap... chatMaps) {
		super(STATE.CHATTING);

		SoundTask.changeMusicVol(0.2);
		languageMapping(chatMap, chatMaps);

		creationOfChatObjectFromChatID(chatID);
		displayChat();
	}
	
	@Override
	public boolean isCameraDependant() {
		return false;
	}
	
	protected abstract void displayChat();

	private void languageMapping(ChatMap chatMap, ChatMap... chatMaps) {
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
			filenameFromLang[2] = chatMap.getFilename();
			break;
		case ENGLISH:
		default:
			filenameFromLang[1] = chatMap.getFilename();
			break;
		}
	}

	private String readDataFromFile() {
		switch (Options.getLanguage()) {
		case FRENCH:
			return verified(filenameFromLang[2]);
		case ENGLISH:
		default:
			return verified(filenameFromLang[1]);
		}
	}

	private String verified(String txt) {
		if (txt != null)
			return FileTask.read(txt);

		// if language not found, return the first valid language
		else {
			int size = LANGUAGE.TOTALNUM + 1;
			for (int i = 0; i < size; i++)
				if (filenameFromLang[i] != null)
					return FileTask.read(filenameFromLang[i]);
		}
		Conductor.fatalError(
				"An unknown error has occured : couldn't correcly make a link between a text and an existing Language");
		return null;
	}

	private void creationOfChatObjectFromChatID(int chatID) {

		String allDataText = readDataFromFile();
		String[] chatIDLines = selectChatIdFromData(allDataText, chatID);
		int size = calculRealSizeOfChatArray(chatIDLines);

		String[][] dataIntoLine = new String[size][6];
		CHARA[] chara = new CHARA[size];
		String[] sentence = new String[size + 1];
		boolean twoSentences = false;
		int[] event = new int[size];
		int gap = 0;

		for (int line = 0; line < size; line++) {

			// this part make sure than array in ChatObject is not discontinue
			if (twoSentences) {
				twoSentences = false;
				gap++;
				continue;
			}
			// segmenting data from line
			dataIntoLine[line] = chatIDLines[line].split(";");
			chara[line] = CHARA.getChara(Integer.valueOf(dataIntoLine[line][3]));
			event[line] = Integer.valueOf(dataIntoLine[line][2]);
			sentence[line] = dataIntoLine[line][5].replace("\"", "");

			// checking for next line
			if (chatIDLines[line + 1] != "") {
				dataIntoLine[line + 1] = chatIDLines[line + 1].split(";");
				chara[line + 1] = CHARA.getChara(Integer.valueOf(dataIntoLine[line + 1][3]));
				if (chara[line] == chara[line + 1])
					twoSentences = true;
			}

			// if next line is the same character, the next chat has two sentences
			if (twoSentences)
				sentence[line + 1] = dataIntoLine[line + 1][5].replace("\"", "");
			else
				sentence[line + 1] = null;

			//checking for eventual event
			EventListener eventOnDisplay = null;
			int eventNum = event[line];
			if (eventNum != 0) eventOnDisplay = () -> World.currentWorld.getIEvent().setMustoccur(true, eventNum);
			
			chatObject[line - gap] = new ChatObject(chara[line], sentence[line], sentence[line + 1], eventOnDisplay);
			chatObject[line + 1 - gap] = null;
		}

	}

	private String[] selectChatIdFromData(String dataText, int chatID) {

		// register of dataText as an array of lines
		String[] alllines = dataText.split(System.getProperty("line.separator"));
		int size = alllines.length;
		String[] chatIDLines = alllines;

		// erase of useless lines
		for (int i = 1; i < size; i++) {
			String[] lineContent = chatIDLines[i].split(";");
			if (Integer.valueOf(lineContent[1]) != chatID)
				chatIDLines[i] = "";
		}
		// reset to possition of lines into the array (as values should start at 0)
		int count = 0;
		for (int i = 1; i < size; i++) {
			if (chatIDLines[i] != "") {
				chatIDLines[count] = chatIDLines[i];
				chatIDLines[i] = "";
				count++;
			}
		}
		return chatIDLines;
	}

	private int calculRealSizeOfChatArray(String[] chatIDLines) {
		int currentSize = chatIDLines.length;
		int realSize = 0;

		if (currentSize >= MAX_LINES_FOR_SAME_DIALOGUE) {
			Conductor.fatalError("A same csv file for dialogues can't be longer than "
					+ (MAX_LINES_FOR_SAME_DIALOGUE - 1) + " lines");
		}

		for (int line = 0; line < currentSize; line++) {
			if (chatIDLines[line] != "")
				realSize = realSize + 1;
			else
				break;
		}
		return realSize;
	}

	@Override
	public void render(Graphics g) {

	}

}
