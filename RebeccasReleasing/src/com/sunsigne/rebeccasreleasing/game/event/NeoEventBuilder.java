package com.sunsigne.rebeccasreleasing.game.event;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerEvent;

public class NeoEventBuilder implements INeoEvent {

	private NeoEventListener listener;
	
	private String name;
	private boolean canOccur;
	private boolean hasOccured;
	private boolean mustOccur;

	public NeoEventBuilder(String name, NeoEventListener listener) {
		this.name = name;
		this.listener = listener;
		canOccur(true);
		hasOccured(false);
		mustOccur(false);
		HandlerEvent.getInstance().addObject(this);
	}

	// state

	@Override
	public NeoEventListener getListener() {
		return listener;
	}	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean canOccur() {
		return canOccur;
	}

	@Override
	public void canOccur(boolean canOccur) {
		this.canOccur = canOccur;
	}

	@Override
	public boolean hasOccured() {
		return hasOccured;
	}

	@Override
	public void hasOccured(boolean hasOccured) {
		this.hasOccured = hasOccured;
	}

	@Override
	public boolean mustOccur() {
		return mustOccur;
	}

	@Override
	public void mustOccur(boolean mustoccur) {
		this.mustOccur = mustoccur;
	}

	@Override
	public void triggerEvent() {
		listener.startEvent();
	}
}
