package com.sunsigne.rebeccasreleasing.game.chat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageTask;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.CHARA;

public class ChatObject extends GameObject {

	private static final int NUM_OF_SENTENCES = 2;

	private EventListener eventOnDisplay;

	public boolean fulldisplayed;
	private boolean[] stop = new boolean[2];

	private CHARA chara;
	private String[] sentence = new String[NUM_OF_SENTENCES];
	private String[] currentText = new String[NUM_OF_SENTENCES];
	private char[][] letter = new char[NUM_OF_SENTENCES][64];

	private int speed = 1;
	private int pausetime;
	private int count, index;

	public ChatObject(CHARA chara, String sentence1, String sentence2, EventListener eventOnDisplay) {
		super(false, Size.X0, 750, OBJECTID.DISPLAYER);

		this.eventOnDisplay = eventOnDisplay;
		this.chara = chara;
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

	public EventListener getEventOnDisplay() {
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
		switch (chara) {
		case REBECCA:
			SoundTask.playSound(0.2, SoundBank.getSound(SoundBank.talking_rebecca));
			break;
		case SARAH:
			SoundTask.playSound(0.2, SoundBank.getSound(SoundBank.talking_sarah));
			break;
		default:
			break;
		}
	}
	
	// design

	@Override
	public void render(Graphics g) {
		g.drawImage(texture.interface_chat, 0, 0, Size.WIDHT, Size.HEIGHT, null);

		BufferedImage img = null;
		img = paintingChara(chara);

		g.drawImage(img, 350, y, -2 * h / 3, 2 * h / 3, null);

		drawText(g);
	}

	private BufferedImage paintingChara(CHARA chara) {
		BufferedImage img = null;

		switch (chara) {
		case REBECCA:
			img = texture.living_rebecca_face[0];
			break;
		case SARAH:
			img = texture.living_sarah_face[0];
			break;
		default:
			img = ImageTask.drawMissingTexture();
			break;
		}
		return img;
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
