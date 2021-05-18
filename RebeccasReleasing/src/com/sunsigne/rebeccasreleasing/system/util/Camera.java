package com.sunsigne.rebeccasreleasing.system.util;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerTick;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class Camera implements ITick {

	public Camera() {
		HandlerTick.getInstance().addObject(this);
	}

	////////// POSITION ////////////

	private float x, y;

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	////////// TICK ////////////

	@Override
	public void tick() {
		if (HandlerObject.getInstance().isPlayerExisting()) {
			GameObject player = HandlerObject.getInstance().getPlayer();
			x = -player.getX() - Size.TILE / 2 + Size.WIDHT / 2;
			y = -player.getY() - Size.TILE / 2 + Size.HEIGHT / 2;
		}
	}

}
