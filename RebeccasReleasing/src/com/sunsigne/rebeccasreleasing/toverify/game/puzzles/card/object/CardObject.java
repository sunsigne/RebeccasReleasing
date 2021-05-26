package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.CollisionDetector;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionDetection;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.ressources.font.FontBank;
import com.sunsigne.rebeccasreleasing.ressources.font.FontTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.GameText;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.ITranslation;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;

public abstract class CardObject extends PuzzleCardObject implements ITranslation, ICollisionDetection {

	private boolean played, dragged;
	protected int startingX, startingY;

	protected int upwardTime = 15;

	public CardObject(int x, int y, CARDTYPE cardtype) {
		super(x, y, cardtype);

		languageMapping(fr, eng, custom);
		startingX = x;
		startingY = y;
	}

	// state

	public boolean isPlayed() {
		return played;
	}

	public void setPlayed(boolean played) {
		this.played = played;
	}

	public boolean isDragged() {
		return dragged;
	}

	public void setDragged(boolean dragged) {
		this.dragged = dragged;
	}

	protected boolean mustHide;
	protected int hiddingTime = 40;

	public void setMustHide(boolean mustHide) {
		this.mustHide = mustHide;
	}

	protected boolean hasSameOrderNumThanFolder(boolean oneUnderInstead) {
		CardFolder folder = null;

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant(), getLayer());
		for (GameObject tempObject : list)
			if (tempObject instanceof CardFolder) {
				folder = (CardFolder) tempObject;
				break;
			}

		if (oneUnderInstead)
			return folder.getOrderNum() == getOrderNum() - 1;
		else
			return folder.getOrderNum() == getOrderNum() || folder.getOrderNum() == 0;
	}

	public void resetPos() {
		x = startingX;
		y = startingY;
	}

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {

		if (hiddingTime > 0 || !mustHide) {
			drawCard(g);
			drawOrderLayer(g);
		} else
			drawMystery(g);
		if (Conductor.getDebugMode().getHitboxMode().getState())
			drawOrderNum(g);

	}

	private void drawCard(Graphics g) {
		boolean isAttack = getCardtype() == CARDTYPE.ATTACK ? true : false;
		int index = isAttack ? 2 : 3;
		g.drawImage(texture.puzzle_card[index], x, y, w, h, null);
		drawTranslatableText(g, index, isAttack);
	}

	private void drawText(Graphics g, boolean isAttack, String text, int gap, int x, int y) {
		Color color = isAttack ? new Color(220, 0, 0) : new Color(0, 170, 0);

		g.setFont(font);
		g.setColor(color);
		g.drawString(text, x + 20 + gap, y + 60);
		g.drawString(text, x + 20 + gap, y + 355);
	}

	private void drawOrderLayer(Graphics g) {

		// grey layer
		if (!hasSameOrderNumThanFolder(false)) {
			int alpha = 200;
			if (hasSameOrderNumThanFolder(true))
				alpha = 100;
			g.setColor(new Color(64, 64, 64, alpha));
			g.fillRect(x, y, w, h);
		}
	}

	private void drawMystery(Graphics g) {
		g.drawImage(texture.puzzle_card[1], x, y, w, h, null);
	}

	////////// COLLISION ////////////

	private CollisionDetector collisionDetector = new CollisionDetector(this);

	@Override
	public CollisionDetector getCollisionDetector() {
		return collisionDetector;
	}	

	////////// LANGUAGE ////////////

	private final ChatMap fr = new ChatMap(LANGUAGE.FRENCH, new GameFile("texts/french/other"));
	private final ChatMap eng = new ChatMap(LANGUAGE.ENGLISH, new GameFile("texts/english/other"));
	private final ChatMap custom = new ChatMap(LANGUAGE.CUSTOM, new GameFile("texts/custom/other"));

	private GameFile[] gamefileFromLang = new GameFile[LANGUAGE.getTotalLanguages() + 1];
	private Font font = new FontTask().createNewFont(FontBank.FRIZQUADRATATT, 45f);

	@Override
	public GameFile getGameFile(int number) {
		return gamefileFromLang[number];
	}

	@Override
	public void setGameFile(int number, GameFile gameFile) {
		this.gamefileFromLang[number] = gameFile;
	}

	private void drawTranslatableText(Graphics g, int index, boolean isAttack) {

		GameText gametext = getGameTextFromFile(index);
		drawText(g, isAttack, gametext.getText(), gametext.getGap(), x, y);
	}

}
