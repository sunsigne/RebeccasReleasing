package com.sunsigne.rebeccasreleasing.system.util;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerTick;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;

import objects.GameObject;

public class Camera implements ITick {

	private float x, y;

	public Camera() {
		HandlerTick.getInstance().addObject(this);
	}	
	
	// state
	
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

	// behavior
	
	@Override
	public void tick() {
		if (HandlerObject.getInstance().isPlayerExisting)
		{
		GameObject player = HandlerObject.getInstance().player;
		x = -player.getX() - Size.TILE / 2 + Size.WIDHT / 2;
		y = -player.getY() - Size.TILE / 2 + Size.HEIGHT / 2;
		}
	}


}
