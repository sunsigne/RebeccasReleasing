package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.lazer.object;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.puzzles.PuzzleObject;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class PliersCursor extends PuzzleObject {

	public PliersCursor() {
		super(0, 0, OBJECTID.DELETE);

		w = 3 * Size.TILE_PUZZLE / 2;
		h = 3 * Size.TILE_PUZZLE / 2;
	}

	@Override
	public void tick() {
		x = new GameCursor().getPos().x - 95;
		y = new GameCursor().getPos().y - 20;
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(texture.gui_tool[4], x, y, w, h, null);
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

}