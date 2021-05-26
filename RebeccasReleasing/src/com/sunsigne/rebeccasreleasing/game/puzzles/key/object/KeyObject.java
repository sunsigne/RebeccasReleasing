package com.sunsigne.rebeccasreleasing.game.puzzles.key.object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.object.collision.CollisionDetector;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionDetection;
import com.sunsigne.rebeccasreleasing.game.puzzles.PuzzleObject;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public abstract class KeyObject extends PuzzleObject implements ICollisionDetection {

	public KeyObject(int x, int y) {
		super(x, y);
		speed = 8;
	}

	////////// SIZE ////////////

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 4, y + h / 4, w / 2, h / 2);
	}

	////////// TICK ////////////

	private int speed;

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	private final int ymin = Size.Y0 + Size.TILE_PUZZLE;
	private final int ymax = Size.Y0 + 6 * Size.TILE_PUZZLE;
	private boolean movingUP;

	protected void goesUpandDown() {
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

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {

		BufferedImage img = texture.puzzle_key[0];
		g.drawImage(img, x, y, w, h, null);
	}

	////////// COLLISION ////////////

	private CollisionDetector collisionDetector = new CollisionDetector(this);

	@Override
	public CollisionDetector getCollisionDetector() {
		return collisionDetector;
	}
}
