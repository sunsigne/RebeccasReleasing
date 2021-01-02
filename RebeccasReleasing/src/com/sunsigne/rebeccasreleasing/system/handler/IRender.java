package com.sunsigne.rebeccasreleasing.system.handler;

import java.awt.Graphics;

public interface IRender {

	boolean isCameraDependant();

	/**
	 * WARNING ! To actually call this method, the object whose the class implements IRender must, somehow,
	 * be add to {@code  handler_render} 
	 * 
	 * @see HandlerRender#addObject(IRender renderable)
	 */
	void render(Graphics g);
}
