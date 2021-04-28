package com.sunsigne.rebeccasreleasing.system.handler;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

public interface IRender {

	boolean isCameraDependant();

	/**
	 * WARNING ! To actually call this method, the object whose the class implements IRender must, somehow,
	 * be add to {@code  handler_render} 
	 * 
	 * @see HandlerRender#addObject(IRender renderable)
	 */
	void render(Graphics g);
	
	static void setAlphaTo(Graphics2D g2d, float alpha)
	{
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
	}
}
