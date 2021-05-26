package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.puzzles.PuzzleObject;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public abstract class PuzzleCardObject extends PuzzleObject {

	public PuzzleCardObject(int x, int y, CARDTYPE cardtype) {
		super(x, y);

		this.cardtype = cardtype;

		w = Size.TILE_PUZZLE * 2;
		h = Size.TILE_PUZZLE * 3;
	}

	private CARDTYPE cardtype;

	public void setCardtype(CARDTYPE cardtype) {
		this.cardtype = cardtype;
	}

	public CARDTYPE getCardtype() {
		return cardtype;
	}

	private int orderNum;

	public void setOrderNum(int number) {
		this.orderNum = number;
	}

	public int getOrderNum() {
		return orderNum;
	}

	////////// RENDER ////////////
	
	protected void drawOrderNum(Graphics g) {
		Font font = new Font("arial", 1, 80);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(getOrderNum()), x + 100, y);
	}
}
