package com.sunsigne.rebeccasreleasing.toclean.verify;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;

import objects.GameObject;

public class BonusText extends GameObject {

	private int time;
	private String text;

	public BonusText(int x, int y, String text) {
		super(false, x, y, OBJECTID.DISPLAYER);
		
		this.text = text;
		time = 40;
		velY = -1;
	}

	public BonusText(GameObject object, String text) {
		super(true, object.getX(), object.getY(), OBJECTID.DISPLAYER);

		this.text = text;
		time = 40;
		velY = -1;
	}

	// behavior

	@Override
	public void tick() {
		velocity();
		--time;
		if (time == 0)
			HandlerObject.getInstance().removeObject(this);

	}

	// render

	@Override
	public void render(Graphics g) {

		Font font = new Font("arial", 1, Size.TILE / 2);
		g.setFont(font);
		g.setColor(Color.yellow);
		g.drawString(text, x, y - Size.TILE);
	}

	// collision

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
