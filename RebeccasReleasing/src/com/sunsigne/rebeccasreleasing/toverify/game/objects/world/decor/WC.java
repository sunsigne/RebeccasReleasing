package com.sunsigne.rebeccasreleasing.toverify.game.objects.world.decor;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.CollisionDetector;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionReaction;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class WC extends GameObject implements ICollisionReaction {

	public WC(int x, int y) {
		super(true, LAYER.WOLRD_GUI_PUZZLE, x, y, OBJECTID.DELETE);

		h = Size.TILE / 4;
		w = Size.TILE / 2;
		miniX = w / 2;
	}

	// behavior

	@Override
	public void tick() {

	}

	// design

	@Override
	public void render(Graphics g) {

		int w0 = Size.TILE;
		int h0 = Size.TILE;

		g.drawImage(texture.decor_small[2], x, y, w0, h0, null);
	}

	// collision

	@Override
	public void collidingReaction(GameObject collidingObject) {
		blockPass(collidingObject, this);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x + miniX, y, w, h);
	}

}
