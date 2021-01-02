package com.sunsigne.rebeccasreleasing.game.event;

import com.sunsigne.rebeccasreleasing.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public abstract class EventBuilder implements IEvent {

	private boolean[] occured = new boolean[16];
	private boolean[] mustoccur = new boolean[16];

	// state

	protected void setOccured(boolean occured, int num) {
		this.occured[num] = occured;
	}

	@Override
	public boolean hasOccured(int num) {
		return occured[num];
	}

	@Override
	public void setMustoccur(boolean mustoccur, int num) {
		this.mustoccur[num] = mustoccur;
	}

	protected boolean getMustoccur(int num) {
		return mustoccur[num];
	}

	@Override
	public void event() {

		if (!hasOccured(0))
			event00();
		if (!hasOccured(1))
			event01();
		if (!hasOccured(2))
			event02();
		if (!hasOccured(3))
			event03();
		if (!hasOccured(4))
			event04();
		if (!hasOccured(5))
			event05();
		if (!hasOccured(6))
			event06();
		if (!hasOccured(7))
			event07();
		if (!hasOccured(8))
			event08();
		if (!hasOccured(9))
			event09();
		if (!hasOccured(10))
			event10();
		if (!hasOccured(11))
			event11();
		if (!hasOccured(12))
			event12();
		if (!hasOccured(13))
			event13();
		if (!hasOccured(14))
			event14();
		if (!hasOccured(15))
			event15();
	}

	protected void event(int i) {
		Conductor.state = STATE.CHATTING;
		HandlerObject.getInstance().player.setMotionless();
		setOccured(true, i);
	}

}
