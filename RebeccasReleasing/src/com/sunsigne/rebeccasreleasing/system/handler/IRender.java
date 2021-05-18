package com.sunsigne.rebeccasreleasing.system.handler;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.system.util.GenericListener;

public interface IRender {

	boolean isCameraDependant();

	LAYER getLayer();

	/**
	 * WARNING ! To actually call this method, the object whose the class implements
	 * IRender must, somehow, be add to one of two lists in HandlerRender class
	 */
	void render(Graphics g);

	static void setTransluant(Graphics2D g2d, GenericListener listener) {
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		listener.doAction();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	}
}
