package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.search.object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.common_object.PuzzleObject;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

public abstract class SearchWordObject extends PuzzleObject {

	private boolean movingUP, movingLeft;
	private boolean exist, stable;
	private boolean isGoodWord;
	private boolean dragged;
	private int speed = 4;

	private int wordnumber;
	private String text;

	public SearchWordObject(int wordnumber, int x, int y) {
		super(x, y, OBJECTID.P_WORD);

		setStable(true);
		this.wordnumber = wordnumber;

		w = Size.TILE_PUZZLE * 3;
		h = Size.TILE_PUZZLE;

		RandomMovement();
		RandomWord();

	}

	// state

	private void RandomMovement() {
		double r0 = Math.random();
		double r1 = Math.random();
		if (r0 <= 0.5)
			movingUP = true;
		if (r1 <= 0.5)
			movingLeft = true;
	}

	private void RandomWord() {
		if (wordnumber == 1) {
			setGoodWord(true);
			setStable(false);
			text = "    TOP";
		}
		if (wordnumber == 2) {
			setGoodWord(true);
			setStable(false);
			text = "SECRET";
		}
		if (wordnumber == 3) {
			text = "    T0P";
		}
		if (wordnumber == 4) {
			text = "    IOP";
		}
		if (wordnumber == 5) {
			text = "SECR3T";
		}
		if (wordnumber == 6) {
			text = "SEC2ET";
		}
		if (wordnumber == 7) {
			text = "5ECRET";
		}
		if (wordnumber == 8) {
			text = "SECREI";
		}
	}

	// state

	public boolean doesExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public boolean isStable() {
		return stable;
	}

	public void setStable(boolean stable) {
		this.stable = stable;
	}

	public boolean isGoodWord() {
		return isGoodWord;
	}

	public void setGoodWord(boolean isGood) {
		this.isGoodWord = isGood;
	}

	public boolean isDragged() {
		return dragged;
	}

	public void setDragged(boolean dragged) {
		this.dragged = dragged;
	}

	// behavior

	public abstract void placeWord();

	@Override
	public void tick() {

		if (!isDragged())
			velocity();
		if (isDragged()) {
			x = (int) GameCursor.getPos().x - Size.TILE_PUZZLE;
			y = (int) GameCursor.getPos().y - Size.TILE_PUZZLE / 2;
		}
		goUpandDown();
		goLeftandRight();
		collision();
	}

	private void goUpandDown() {
		if (movingUP) {
			velY = -speed;
			if (y < Size.Y0 + h + Size.TILE_PUZZLE / 12)
				movingUP = false;
		} else {
			velY = speed;
			if (y > Size.HEIGHT - 9 * Size.TILE_PUZZLE / 4)
				movingUP = true;
		}
	}

	private void goLeftandRight() {
		if (movingLeft) {
			velX = -speed;
			if (x < 11 * Size.TILE_PUZZLE / 8)
				movingLeft = false;
		} else {
			velX = speed;
			if (x > 127 * Size.TILE_PUZZLE / 12)
				movingLeft = true;
		}
	}

	// design

	@Override
	public void render(Graphics g) {

		Font font = new Font(Font.DIALOG, 1, 70);
		g.setFont(font);
		g.setColor(new Color(255, 80, 80));
		g.drawRect(x + 25, y, 8 * Size.TILE_PUZZLE / 3, Size.TILE_PUZZLE);
		g.drawRect(x + 24, y - 1, 8 * Size.TILE_PUZZLE / 3 + 2, Size.TILE_PUZZLE + 2);
		g.drawRect(x + 23, y - 2, 8 * Size.TILE_PUZZLE / 3 + 4, Size.TILE_PUZZLE + 4);
		g.drawString(text, x + 5 * Size.TILE_PUZZLE / 12, y + 2 * Size.TILE_PUZZLE / 3);
	}

	// collision

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

	protected abstract void collision();

}
