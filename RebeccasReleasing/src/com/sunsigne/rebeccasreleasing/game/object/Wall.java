package com.sunsigne.rebeccasreleasing.game.object;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionReaction;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class Wall extends GameObject implements ICollisionReaction {

	public Wall(int x, int y, Facing facing) {
		super(true, LAYER.WOLRD_GUI_PUZZLE, x, y);

		setSize(facing);
	}

	////////// SIZE ////////////

	private void setSize(Facing facing) {
		switch (facing.getDirection()) {
		case LEFT:
			w = Size.TILE / 2;
			break;
		case RIGHT:
			w = Size.TILE / 2;
			miniX = w;
			break;
		case UP:
			h = Size.TILE / 2;
			break;
		case DOWN:
			h = Size.TILE / 2;
			miniY = h;
			break;
		default:
			break;
		}
	}

	////////// TICK ////////////

	@Override
	public void tick() {
	}

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {
	}

	////////// COLLISION ////////////

	@Override
	public void collidingReaction(GameObject collidingObject) {
		blockPass(collidingObject, this);
	}

}
