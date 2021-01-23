package com.sunsigne.rebeccasreleasing.system.handler;

import java.util.HashMap;

import com.sunsigne.rebeccasreleasing.game.event.INeoEvent;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.onlyconductortorebuild.Conductor;

public class HandlerEvent implements ITick {

	// singleton

	private static HandlerEvent instance = null;

	public static HandlerEvent getInstance() {
		if (instance == null)
			instance = new HandlerEvent();
		return instance;
	}

	// map or list

	private HashMap<String, INeoEvent> handler_event_map = new HashMap<>();

	public void addObject(INeoEvent ievent) {

		if (ievent != null)
			handler_event_map.put(ievent.getName(), ievent);
	}

	public INeoEvent getEvent(String name) {
		return handler_event_map.get(name);
	}

	public void removeObject(INeoEvent ievent) {

		if (ievent != null)
			handler_event_map.remove(ievent.getName(), ievent);
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
		handler_event_map.forEach((name, ievent) -> {
			if (ievent.canOccur() && !ievent.hasOccured()) {
				if (!ievent.mustOccur()) {
					ievent.mustOccur(ievent.getListener().startingCondition());
				}
				if (ievent.mustOccur()) {
					Conductor.setState(STATE.CHATTING);
					HandlerObject.getInstance().player.setMotionless();
					ievent.canOccur(false);
					ievent.hasOccured(true);
					ievent.mustOccur(false);
					ievent.triggerEvent();
				}
			}
		});
	}
}
