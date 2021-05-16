package com.sunsigne.rebeccasreleasing.toverify.game.menu.introduction;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.GameObject;
import objects.TimerListener;

public class AutomaticTimerObject extends GameObject {

	private TimerListener listener;
	private int timeinTicks;

	public AutomaticTimerObject(int timeinTicks, TimerListener listener) {
		super(false, 0, 0, 0, OBJECTID.TIMER);
		this.listener = listener;
		this.timeinTicks = timeinTicks;
		HandlerObject.getInstance().addObject(this);
	}

	// behavior

	@Override
	public void tick() {
		--timeinTicks;
		if (timeinTicks <= 0)
		{
			listener.onFinish();
			HandlerObject.getInstance().removeObject(this);
		}
	}

	// design

	@Override
	public void render(Graphics g) {

	}

	// collision

	@Override
	public Rectangle getBounds() {
		return null;
	}

}