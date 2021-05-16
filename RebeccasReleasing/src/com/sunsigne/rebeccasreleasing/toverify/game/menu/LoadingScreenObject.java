package com.sunsigne.rebeccasreleasing.toverify.game.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.toverify.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.GameObject;

public class LoadingScreenObject extends GameObject implements ITranslation {

	private boolean running;

	public LoadingScreenObject(ChatMap chatMap, ChatMap... chatMaps) {
		super(false, 2, 0, 0, OBJECTID.LOADING);
		languageMapping(chatMap, chatMaps);
	}

	public void start() {
		HandlerObject.getInstance().addObject(this);
		running = true;
	}

	public void stop() {
//		remove();
		running = false;
		HandlerObject.getInstance().removeObject(this);
	}

	@Override
	public void tick() {
		if (running) {

		}
	}

	@Override
	public void render(Graphics g) {
		if (running) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Size.WIDHT, Size.HEIGHT);

			drawTranslatableText(g);
		}
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	////////// LANGUAGE ////////////

	private final GameFile[] gamefileFromLang = new GameFile[LANGUAGE.getTotalLanguages() + 1];
	private final Font font = new Font("arial", 1, 150);

	@Override
	public GameFile getGameFile(int number) {
		return gamefileFromLang[number];
	}

	@Override
	public void setGameFile(int number, GameFile gameFile) {
		this.gamefileFromLang[number] = gameFile;
	}

	private void drawTranslatableText(Graphics g) {
		GameText gametext = getGameTextFromFile(2);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(gametext.getText(), 480 + gametext.getGap(), Size.HEIGHT / 2 + 50);

	}

}
