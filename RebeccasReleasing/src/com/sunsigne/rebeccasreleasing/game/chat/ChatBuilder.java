package com.sunsigne.rebeccasreleasing.game.chat;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.event.Event;
import com.sunsigne.rebeccasreleasing.game.menu.ITranslation;
import com.sunsigne.rebeccasreleasing.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.ressources.characters.CharacterBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.IClick;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerEvent;

public abstract class ChatBuilder extends Clickable implements IClick, ITranslation {

	protected static final int MAX_LINES_FOR_SAME_DIALOGUE = 255;

	protected ChatObject[] chatObject = new ChatObject[MAX_LINES_FOR_SAME_DIALOGUE];
	private GameFile[] gamefileFromLang = new GameFile[LANGUAGE.TOTALNUM + 1];

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

	@Override
	public GameFile getGameFile(int number) {
		return gamefileFromLang[number];
	}

	@Override
	public void setGameFile(int number, GameFile gameFile) {
		this.gamefileFromLang[number] = gameFile;
	}

	protected abstract void displayChat();

	private void creationOfChatObjectFromChatID(int chatID) {

		String allDataText = readDataFromFile();
		String[] chatIDLines = selectChatIdFromData(allDataText, chatID);
		int size = calculRealSizeOfChatArray(chatIDLines);

		String[][] dataIntoLine = new String[size][6];
		CharacterBank[] characterBank = new CharacterBank[size];
		Integer[] charaCol = new Integer[size];
		Integer[] charaRow = new Integer[size];
		Integer[] charaExpression = new Integer[size];
		String[] sentence = new String[size + 1];
		boolean twoSentences = false;
		String[] event = new String[size];
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

			charaCol[line] = Integer.valueOf(dataIntoLine[line][3]);
			charaRow[line] = Integer.valueOf(dataIntoLine[line][4]);
			characterBank[line] = selectCharacterFromData(charaCol[line], charaRow[line]);
			charaExpression[line] = Integer.valueOf(dataIntoLine[line][6]);
			event[line] = String.valueOf(dataIntoLine[line][2]).replace("\"", "");
			
			sentence[line] = dataIntoLine[line][7].replace("\"", "");

			// checking for next line
			if (chatIDLines[line + 1] != "") {
				dataIntoLine[line + 1] = chatIDLines[line + 1].split(";");

				charaCol[line + 1] = Integer.valueOf(dataIntoLine[line + 1][3]);
				charaRow[line + 1] = Integer.valueOf(dataIntoLine[line + 1][4]);
				characterBank[line + 1] = selectCharacterFromData(charaCol[line + 1], charaRow[line]);
				charaExpression[line + 1] = Integer.valueOf(dataIntoLine[line + 1][6]);

				if (characterBank[line] == characterBank[line + 1])
					twoSentences = true;
			}

			// if next line is the same character, the next chat has two sentences
			if (twoSentences)
				sentence[line + 1] = dataIntoLine[line + 1][7].replace("\"", "");
			else
				sentence[line + 1] = null;

			// checking for eventual event
			Event eventOnDisplay = null;
			String eventName = event[line];

			if (event[line].indexOf("null") == -1)
				eventOnDisplay = HandlerEvent.getInstance().getEvent(eventName);

			chatObject[line - gap] = new ChatObject(characterBank[line], charaExpression[line], sentence[line], sentence[line + 1],
					eventOnDisplay);
			chatObject[line + 1 - gap] = null;
		}

	}

	private CharacterBank selectCharacterFromData(int charaCol, int charaRol) {

		for (CharacterBank tempCharacter : CharacterBank.characters.keySet()) {
			int tempCol = CharacterBank.getCharacter(tempCharacter).getCol();
			int tempRow = CharacterBank.getCharacter(tempCharacter).getRow();

			if (tempCol == charaCol && tempRow == charaRol)
				return tempCharacter;
		}
		// this should not occurs, but won't crash the game if it does
		return null;
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
