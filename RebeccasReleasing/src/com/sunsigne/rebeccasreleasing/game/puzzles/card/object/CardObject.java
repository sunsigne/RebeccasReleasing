package com.sunsigne.rebeccasreleasing.game.puzzles.card.object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
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

	// design

	@Override
	public void render(Graphics g) {

		g.drawImage(ImageBank.getImage(ImageBank.card_frame), x, y, w, h, null);

		if (hiddingTime > 0 || !shouldHide) {
			drawCardContent(g);
			drawOrderLayer(g);
		} else
			drawMystery(g);

		drawHitbox(g);
	}

	private void drawCardContent(Graphics g) {

		Font font = new Font("arial", 1, 50);
		g.setFont(font);
		
		if (getCardtype() == CARDTYPE.ATTACK) {
			g.setColor(Color.red);
			g.drawImage(ImageBank.getImage(ImageBank.card_attack), x, y, w, h, null);
			g.drawString("attack", x + 55, y + 45);
		}
		if (getCardtype() == CARDTYPE.CRITICAL) {
			g.setColor(new Color(255, 255, 0)); // yellow
			g.drawImage(ImageBank.getImage(ImageBank.card_critical), x, y, w, h, null);
			g.drawString("critical", x + 40, y + 45);
		}
		if (getCardtype() == CARDTYPE.DEFENSE) {
			g.setColor(new Color(0, 170, 0)); // green
			g.drawImage(ImageBank.getImage(ImageBank.card_defense), x, y, w, h, null);
			g.drawString("defense", x + 30, y + 45);
		}
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
		Font font = new Font("arial", 1, 300);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("?", x + w / 2 - 90, y + h / 2 + 50);
	}

	// collision

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

}
