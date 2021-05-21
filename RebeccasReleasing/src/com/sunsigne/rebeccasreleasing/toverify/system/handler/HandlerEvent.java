package com.sunsigne.rebeccasreleasing.toverify.system.handler;

import java.util.HashMap;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerTick;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;
import com.sunsigne.rebeccasreleasing.toverify.game.event.Event;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.conductor.Conductor;

public class HandlerEvent implements ITick {
	
	// singleton

	private static HandlerEvent instance = null;

	public static HandlerEvent getInstance() {
		if (instance == null)
			instance = new HandlerEvent();
		return instance;
	}

	// map or list

	private HashMap<String, Event> handler_event_map = new HashMap<>();

	public void addObject(Event event) {

		if (event != null)
			handler_event_map.put(event.getName(), event);
	}

	public Event getEvent(String name) {
		return handler_event_map.get(name);
	}

	public void removeObject(Event event) {

		if (event != null)
			handler_event_map.remove(event.getName(), event);
	}

	public void clear() {
		handler_event_map.clear();
	}

	// constructor

	public HandlerEvent() {
		HandlerTick.getInstance().addObject(this);
	}

	// behavior

	@Override
	public void tick() {
		handler_event_map.forEach((name, event) -> {
			if (event.canOccur() && !event.hasOccured()) {
				if (!event.mustOccur()) {
					event.mustOccur(event.getContext().startingCondition());
				}
				if (event.mustOccur()) {
					Conductor.setState(STATE.CHATTING);
					HandlerObject.getInstance().getPlayer().setMotionless();
					event.canOccur(false);
					event.hasOccured(true);
					event.mustOccur(false);
					event.triggerEvent();
				}
			}
		});
	}
}
