package com.sunsigne.rebeccasreleasing.game.puzzles.key.object;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.puzzles.commun_object.PuzzleObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

public abstract class KeyObject extends PuzzleObject {

	private static final int ymin = 5 * Size.TILE_PUZZLE / 4;
	private static final int ymax = Size.HEIGHT - 9 * Size.TILE_PUZZLE / 4;

	protected boolean movingUP;
	private int speed = 8;

	public KeyObject(int x, int y) {
		super(x, y, OBJECTID.P_KEY);
	}

	// behavior

	protected void goUpandDown() {
		if (movingUP) {
			velY = -speed;
			if (y < ymin)
				movingUP = false;
		} else {
			velY = speed;
			if (y > ymax)
				movingUP = true;
		}
	}
	
	// design

	@Override
	public void render(Graphics g) {

		g.drawImage(texture.puzzle_key[0], x, y, w, h, null);
		drawHitbox(g);
	}

	// collision
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 4, y + h / 4, w / 2, h / 2);
	}

}
