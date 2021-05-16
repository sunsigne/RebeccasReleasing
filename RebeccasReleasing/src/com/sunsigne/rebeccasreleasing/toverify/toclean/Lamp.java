package com.sunsigne.rebeccasreleasing.toverify.toclean;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.toverify.Todo;

import objects.GameObject;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

@Todo("make it a destroyable")
public class Lamp extends GameObject implements ICollision {

	public Lamp(int x, int y) {
		super(true, 0, x, y, OBJECTID.DECOR);
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
	public void collision(LivingObject living) {

	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

}
