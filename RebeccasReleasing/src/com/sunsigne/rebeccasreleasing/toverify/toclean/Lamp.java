package com.sunsigne.rebeccasreleasing.toverify.toclean;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionReaction;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;

import objects.characters.living.LivingObject;

public class Lamp extends GameObject implements ICollisionReaction {

	public Lamp(int x, int y) {
		super(true, LAYER.WOLRD_GUI_PUZZLE, x, y, OBJECTID.DECOR);
	}

	// behavior
	
	@Override
	public void tick() {

	}

	// design
	
	@Override
	public void render(Graphics g) {

		g.drawImage(texture.decor_small[0], x, y, w, h, null);
	}

	// collision
	
	@Override
	public void collidingReaction(GameObject collidingObject) {

	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

}
