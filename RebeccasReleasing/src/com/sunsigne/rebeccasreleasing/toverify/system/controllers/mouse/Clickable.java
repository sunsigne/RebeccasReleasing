package com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public abstract class Clickable extends GameMouseInput implements IClick {

	public Clickable(STATE state) {
		super(state);
		GameMouseInput.clickable[getLayer().getNum()] = this;
		HandlerRender.getInstance().addObject(this);
	}

	@Override
	public boolean isCameraDependant() {
		return false;
	}
	
	public abstract void close();
	
	protected void colorRender(Graphics g, Color color) {
		g.setColor(color);
		int x0 = 64 + Size.TILE_PUZZLE;
		int y0 = 32 + Size.TILE_PUZZLE;
		g.fillRect(x0, y0, Size.WIDHT - 2 * x0 + 8, Size.HEIGHT - 2 * y0 + 8);
	}

	protected void gradientRender(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint paint = new GradientPaint(0, 0, new Color(220, 220, 255), 0, Size.HEIGHT, new Color(0, 0, 200));
		g2d.setPaint(paint);
		g2d.fillRect(0, 0, Size.WIDHT, Size.HEIGHT);
	}

	protected void greyRender(Graphics g) {
		int alpha = 200;
		g.setColor(new Color(64, 64, 64, alpha));
		g.fillRect(0, 0, Size.WIDHT, Size.HEIGHT);
	}
	
	protected void clearClickable() {
		
		HandlerRender.getInstance().removeObject(clickable[getLayer().getNum()]);
		clickable[getLayer().getNum()] = null;
		HandlerObject.getInstance().clear(false, getLayer());
		new GameCursor().hideCursor(false);
	}

}
