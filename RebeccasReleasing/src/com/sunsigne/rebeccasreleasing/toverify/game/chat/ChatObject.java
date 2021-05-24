package com.sunsigne.rebeccasreleasing.toverify.game.chat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.toverify.game.event.Event;
import com.sunsigne.rebeccasreleasing.toverify.ressources.characters.CharacterBank;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

public class ChatObject extends GameObject {

	private static final int NUM_OF_SENTENCES = 2;

	private Event eventOnDisplay;

	public boolean fulldisplayed;
	private boolean[] stop = new boolean[2];

	private CharacterBank characterBank;
	private int facialExpression;
	private String[] sentence = new String[NUM_OF_SENTENCES];
	private String[] currentText = new String[NUM_OF_SENTENCES];
	private char[][] letter = new char[NUM_OF_SENTENCES][64];

	private int speed = 1;
	private int pausetime;
	private int count, index;

	public ChatObject(CharacterBank characterBank, int facialExpression, String sentence1, String sentence2, Event eventOnDisplay) {
		super(false, LAYER.DIALOGUE_VENT, Size.X0, 750, OBJECTID.DISPLAYER);

		this.eventOnDisplay = eventOnDisplay;
		this.characterBank = characterBank;
		this.facialExpression = facialExpression;
		this.sentence[0] = sentence1;
		this.sentence[1] = sentence2;
		this.currentText[0] = "";
		this.currentText[1] = "";

		w = 1857;
		h = 300;

		lettersAttributionFromSentences();
	}

	private void lettersAttributionFromSentences() {
		int size = 0;

		for (int sentenceNumber = 0; sentenceNumber < NUM_OF_SENTENCES; sentenceNumber++) {
			if (sentence[sentenceNumber] != null) {
				size = sentence[sentenceNumber].length();
				for (int i = 0; i < size; i++) {
					letter[sentenceNumber][i] = this.sentence[sentenceNumber].charAt(i);
				}
			}
		}
	}

	// state

	public Event getEventOnDisplay() {
		return eventOnDisplay;
	}

	public boolean isFulldisplayed() {
		return fulldisplayed;
	}

	public void setFulldisplayed(boolean fulldisplayed) {
		this.fulldisplayed = fulldisplayed;
		if (fulldisplayed) {
			stop[0] = true;
			stop[1] = true;
			currentText[0] = sentence[0];
			currentText[1] = sentence[1];
		}
	}

	// behavior

	@Override
	public void tick() {
		if (pausetime > 0)
			pausetime--;
		else {
			if (!stop[0])
				readSentence(0);
			if (stop[0] && !stop[1])
				readSentence(1);
		}
	}

	private void pause() {
		pausetime = 25;
	}

	private void readSentence(int sentenceNum) {
		index++;
		if (index > speed) {
			index = 0;
			nextChar(sentenceNum);
		}
	}

	private void nextChar(int line) {
		char newchar = ' ';
		String newletter;

		int size = sentence[line].length();
		for (int i = 0; i < size; i++) {

			if (count == i) {
				newchar = letter[line][i];
				newletter = String.valueOf(newchar);
				boolean isPauseChar = ":,.!?…".contains(Character.toString(letter[line][i]));
				if (isPauseChar)
					pause();

				currentText[line] = currentText[line] + newletter;
				playTalkingSound();
			}
		}
		count++;

		if (count == size) {
			count = 0;
			stop[line] = true;
			if (line == 0 && sentence[1] == null)
				setFulldisplayed(true);
			else if (line == 1)
				setFulldisplayed(true);
		}
	}

	private void playTalkingSound() {

		if (characterBank == CharacterBank.rebecca)
			new SoundTask().playSound(0.2, SoundBank.TALKING_REBECCA);
		if (characterBank == CharacterBank.sarah)
			new SoundTask().playSound(0.2, SoundBank.TALKING_SARAH);
	}

	// design

	@Override
	public void render(Graphics g) {
		g.drawImage(texture.interface_chat, 0, 0, Size.WIDHT, Size.HEIGHT, null);

		g.drawImage(texture.getLivingFace(characterBank, facialExpression), 350, y, -2 * h / 3, 2 * h / 3, null);

		drawText(g);
	}

	private void drawText(Graphics g) {
		Font font = new Font("arial", 1, 55);
		g.setColor(Color.white);
		g.setFont(font);

		int x0 = 440;

		if (currentText[0] != null)
			g.drawString(currentText[0], x0, y + 80);
		if (currentText[1] != null)
			g.drawString(currentText[1], x0, y + 170);
	}

	// collision

	@Override
	public Rectangle getBounds() {

		return null;
	}

}
