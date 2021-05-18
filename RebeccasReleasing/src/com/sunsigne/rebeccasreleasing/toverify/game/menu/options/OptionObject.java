package com.sunsigne.rebeccasreleasing.toverify.game.menu.options;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.ressources.font.BufferedFontBank;
import com.sunsigne.rebeccasreleasing.ressources.font.FontTask;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.GameText;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.ITranslation;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.MenuObject;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;

public class OptionObject extends MenuObject implements ITranslation {

	public OptionObject(ChatMap chatMap, ChatMap... chatMaps) {
		super(chatMap, chatMaps);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

		drawFrame(g);
		drawTranslatableText(g);
	}

	private void drawFrame(Graphics g) {
		g.drawImage(ImageBank.getImage(ImageBank.options_screen), 160, 100, 1600, 850, null);
	}

	private void drawText(Graphics g, String text, int gap, int x, int y) {
		g.setFont(font);
		g.setColor(new Color(255, 204, 0));
		g.drawString(text, x + gap, y);
	}

	@Override
	public void drawHitbox(Graphics g) {
		g.setColor(Color.white);
		drawRect(g, Options.languageRect);
		drawRect(g, Options.backRect);
//		g.drawImage(ImageLoader.cross, Width - 85, 10, 80, 80, null);
	}

	////////// LANGUAGE ////////////

	private final Font font = FontTask.createNewFont(BufferedFontBank.dogica_bold, 60f);

	private void drawTranslatableText(Graphics g) {
		GameText gametext;
		gametext = getGameTextFromFile(6);
		drawText(g, gametext.getText(), gametext.getGap(), 300, 280); // LANGUAGE
		gametext = getGameTextFromFile(7);
		drawText(g, gametext.getText(), gametext.getGap(), 900, 280); // < ENGLISH >
		gametext = getGameTextFromFile(8);
		drawText(g, gametext.getText(), gametext.getGap(), 260, 880); // < BACK

	}

}
