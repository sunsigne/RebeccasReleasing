package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.GameText;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.ITranslation;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.toverify.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.toverify.ressources.font.BufferedFontBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.font.FontTask;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.GameObject;

public abstract class CardObject extends CommunCardObject implements ITranslation {

	private boolean exist, dragged;
	protected int startingX, startingY;

	protected int upwardTime = 15;
	protected boolean shouldHide;
	protected int hiddingTime = 40;

	public CardObject(int x, int y, CARDTYPE cardtype, ChatMap chatMap, ChatMap... chatMaps) {
		super(x, y, OBJECTID.P_CARD, cardtype);

		languageMapping(chatMap, chatMaps);
		startingX = x;
		startingY = y;
	}

	// state

	public boolean doesExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public boolean isDragged() {
		return dragged;
	}

	public void setDragged(boolean dragged) {
		this.dragged = dragged;
	}

	public void willHide() {
		shouldHide = true;
	}

	protected boolean hasSameOrderNumThanFolder(boolean oneUnderInstead) {
		CardFolder folder = null;

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant(), getCameraLayer());
		for (GameObject tempObject : list)
			if (tempObject.getId() == OBJECTID.P_CARDFOLDER) {
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

	// design

	@Override
	public void render(Graphics g) {

		if (hiddingTime > 0 || !shouldHide) {
			drawCard(g);
			drawOrderLayer(g);
		} else
			drawMystery(g);

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

	// collision

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

	////////// LANGUAGE ////////////

	private GameFile[] gamefileFromLang = new GameFile[LANGUAGE.getTotalLanguages() + 1];
	private Font font = FontTask.createNewFont(BufferedFontBank.frizQuadrataTT, 45f);

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
