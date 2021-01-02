package com.sunsigne.rebeccasreleasing.system.handler;

public interface ITick  {

	/**
	 * WARNING ! To actually call this method, the object whose the class implements ITick must, somehow,
	 * be add to {@code  handler_tick} 
	 * 
	 * @see HandlerTick#addObject(ITick tickable)
	 */
	void tick();
	
}
