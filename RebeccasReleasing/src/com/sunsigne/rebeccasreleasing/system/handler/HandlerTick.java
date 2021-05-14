package com.sunsigne.rebeccasreleasing.system.handler;

import java.util.LinkedList;

public class HandlerTick implements ITick {

	////////// SIGNELTON ////////////

	private static HandlerTick instance = null;

	public static HandlerTick getInstance() {
		if (instance == null)
			instance = new HandlerTick();
		return instance;
	}

	////////// MAP OR LIST ////////////

	private LinkedList<ITick> handler_tick_list = new LinkedList<>();

	public void addObject(ITick tickable) {

		if (tickable != null)
			handler_tick_list.add(tickable);
	}

	public void removeObject(ITick tickable) {

		if (tickable != null)
			handler_tick_list.remove(tickable);
	}

	////////// BEHAVIOR ////////////

	@Override
	public void tick() {
		for (ITick tempTick : handler_tick_list)
			tempTick.tick();
	}

}
