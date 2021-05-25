package com.sunsigne.rebeccasreleasing.toverify.game.puzzles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionReaction;
import com.sunsigne.rebeccasreleasing.game.puzzles.PuzzleObject;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.KeyObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.OBJECTID;

public class WallPuzzle extends PuzzleObject implements ICollisionReaction {

	private BufferedImage texture;

	public WallPuzzle(int x, int y, BufferedImage texture) {
		super(x, y, OBJECTID.DELETE);
		this.texture = texture;
	}

	// behavior

	@Override
	public void tick() {
	}

	// design

	@Override
	public void render(Graphics g) {

		g.drawImage(texture, x, y, w, h, null);
	}

	// collision

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

	////////// COLLISION ////////////

	@Override
	public void collidingReaction(GameObject collidingObject) {
		if (collidingObject instanceof KeyObject)
			collidingReaction(collidingObject, false, this, () -> {
				HandlerObject.getInstance().getPlayer().puzzle.close();
			});
	}

}
