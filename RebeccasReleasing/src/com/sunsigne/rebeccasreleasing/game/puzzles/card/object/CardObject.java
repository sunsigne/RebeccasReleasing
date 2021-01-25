package com.sunsigne.rebeccasreleasing.game.puzzles.card.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;

public abstract class CardObject extends CommunCardObject {

	private boolean exist, dragged;
	protected int startingX, startingY;

	protected int upwardTime = 15;
	protected boolean shouldHide;
	protected int hiddingTime = 40;

	public CardObject(int x, int y, CARDTYPE cardtype) {
		super(x, y, OBJECTID.P_CARD, cardtype);

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

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
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
			drawCardContent(g);
			drawOrderLayer(g);
		} else
			drawMystery(g);

		drawHitbox(g);
	}

	private void drawCardContent(Graphics g) {
		if (getCardtype() == CARDTYPE.ATTACK) 
			g.drawImage(texture.puzzle_card[Options.getLanguage().getNum()][1], x, y, w, h, null);
		if (getCardtype() == CARDTYPE.DEFENSE) 
			g.drawImage(texture.puzzle_card[Options.getLanguage().getNum()][2], x, y, w, h, null);
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
		g.drawImage(texture.puzzle_card[Options.getLanguage().getNum()][0], x, y, w, h, null);
	}

	// collision

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

}
