package com.sunsigne.rebeccasreleasing.game.event;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerEvent;

public class Event {

	private EventContext context;
	
	private String name;
	private boolean canOccur;
	private boolean hasOccured;
	private boolean mustOccur;

	public Event(String name, EventContext context) {
		this.name = name;
		this.context = context;
		canOccur(true);
		hasOccured(false);
		mustOccur(false);
		HandlerEvent.getInstance().addObject(this);
	}

	public EventContext getContext() {
		return context;
	}	

	public String getName() {
		return name;
	}

	public boolean canOccur() {
		return canOccur;
	}

	public void canOccur(boolean canOccur) {
		this.canOccur = canOccur;
	}

	public boolean hasOccured() {
		return hasOccured;
	}

	public void hasOccured(boolean hasOccured) {
		this.hasOccured = hasOccured;
	}

	public boolean mustOccur() {
		return mustOccur;
	}

	public void mustOccur(boolean mustoccur) {
		this.mustOccur = mustoccur;
	}

	public void triggerEvent() {
		context.startEvent();
	}
}
