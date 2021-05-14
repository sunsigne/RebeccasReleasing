package com.sunsigne.rebeccasreleasing.toverify.system.handler;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

public interface IRender {

	boolean isCameraDependant();

	/**
	 * WARNING ! To actually call this method, the object whose the class implements
	 * IRender must, somehow, be add to one of two lists in HandlerRender class
	 */
	void render(Graphics g);

	static void setAlphaTo(Graphics2D g2d, float alpha) {
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
	}
}
