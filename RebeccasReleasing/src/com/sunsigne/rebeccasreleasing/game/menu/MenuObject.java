package com.sunsigne.rebeccasreleasing.game.menu;

import java.awt.Graphics;
import java.awt.Rectangle;

import objects.GameObject;
import objects.OBJECTID;

public abstract class MenuObject extends GameObject {

	public MenuObject() {
		super(0, 0, OBJECTID.MENU, false);
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	protected void drawRect(Graphics g, int[] rect)
	{
		if(rect.length == 4)
		g.drawRect(rect[0], rect[1], rect[2], rect[3]);
		else System.err.println("the array rect in method drawRect should be 4 int long");
	}
}
