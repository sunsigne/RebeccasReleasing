package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.key.object;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.common_object.PuzzleObject;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

public class Lock extends PuzzleObject {

	int ymin = 32 + Size.TILE_PUZZLE;
	int ymax = 32 + 6 * Size.TILE_PUZZLE;

	public Lock(int x, int y) {
		super(x, y, OBJECTID.P_LOCK);
	}

	@Override
	public void tick() {
		if (Conductor.getState() == STATE.PUZZLE) {
			if (GameCursor.getPos().y < ymin)
				y = ymin;
			else if (GameCursor.getPos().y > ymax)
				y = ymax;
			else
				y = GameCursor.getPos().y;
		}
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(texture.puzzle_key[1], x, y, w, h, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 4, y + h / 4, w / 2, h / 2);
	}

}