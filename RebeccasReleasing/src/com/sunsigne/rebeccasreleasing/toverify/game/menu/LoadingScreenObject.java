package com.sunsigne.rebeccasreleasing.toverify.game.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.toverify.ressources.characters.CharacterBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.Facing.DIRECTION;

public class LoadingScreenObject extends GameObject implements ITranslation, IAnimation {

	private Animation[] animation = new Animation[2]; // - facing
	private boolean running;

	public LoadingScreenObject(ChatMap chatMap, ChatMap... chatMaps) {
		super(false, LAYER.QUIT_MENU, 0, 0, OBJECTID.LOADING);
		languageMapping(chatMap, chatMaps);
	}

	@Override
	public Animation getAnimation(int... array) {

		int facing = array[0];

		if (animation[facing] == null)
			animation[facing] = new Animation(20,
					texture.getLivingBattle(CharacterBank.rebecca, facing, 3),
					texture.getLivingBattle(CharacterBank.rebecca, facing, 4),
					texture.getLivingBattle(CharacterBank.rebecca, facing, 5),
					texture.getLivingBattle(CharacterBank.rebecca, facing, 4));
		return animation[facing];
	}

	
	public void start() {
		HandlerObject.getInstance().addObject(this);
		running = true;
	}

	public void stop() {
		running = false;
		HandlerObject.getInstance().removeObject(this);
	}

	@Override
	public void tick() {
		if (running) {
			runAnimations();
		}
	}

	private void runAnimations() {
		runAnimation(DIRECTION.LEFT.getNum(), 0);
		runAnimation(DIRECTION.RIGHT.getNum(), 0);
	}

	
	@Override
	public void render(Graphics g) {
		if (running) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Size.WIDHT, Size.HEIGHT);

			drawTranslatableText(g);
			drawAnimation(g, 1700, 850, 200, 200, DIRECTION.LEFT.getNum(), 0);
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
		Font fontA = new Font("arial", 1, 80);
		g.setFont(fontA);
		g.setColor(Color.WHITE);
		g.drawString(gametext.getText(), 1180 + gametext.getGap(), 1000);

	}

}
