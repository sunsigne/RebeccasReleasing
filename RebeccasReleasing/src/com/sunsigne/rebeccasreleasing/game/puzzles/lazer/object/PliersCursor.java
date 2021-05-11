package com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.puzzles.commun_object.PuzzleObject;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

public class PliersCursor extends PuzzleObject {

	public PliersCursor() {
		super(0, 0, OBJECTID.CURSOR);

		w = 3 * Size.TILE_PUZZLE / 2;
		h = 3 * Size.TILE_PUZZLE / 2;
	}

	@Override
	public void tick() {
		x = GameCursor.getPos().x - 95;
		y = GameCursor.getPos().y - 20;
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(texture.gui_tool[4], x, y, w, h, null);
		drawHitbox(g);
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

}