package com.sunsigne.rebeccasreleasing.game.event;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerTick;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;

public class EventLoader implements ITick {

	private IEvent ievent;
	private boolean start;

	public EventLoader(IEvent ievent) {
		this.ievent = ievent;
		HandlerTick.getInstance().addObject(this);
	}

	public void start() {
		start = true;
	}

	public void stop() {
		start = false;
	}

	@Override
	public void tick() {
		if (start)
			ievent.event();
	}

	public void clearEvent() {
		start = false;
		HandlerTick.getInstance().removeObject(this);
	}

}
