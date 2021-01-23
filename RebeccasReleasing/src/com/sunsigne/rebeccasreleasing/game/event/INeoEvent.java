package com.sunsigne.rebeccasreleasing.game.event;

public interface INeoEvent {

	NeoEventListener getListener();
	
	String getName();
	
	boolean canOccur();

	boolean hasOccured();

	boolean mustOccur();

	void canOccur(boolean canOccur);

	void hasOccured(boolean hasOccured);

	void mustOccur(boolean mustoccur);

	void triggerEvent();

}
