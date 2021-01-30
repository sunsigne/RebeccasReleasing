package com.sunsigne.rebeccasreleasing.game.menu.introduction;

import com.sunsigne.rebeccasreleasing.game.menu.MenuObject;

abstract class CommunIntroductionObject extends MenuObject {

	private int phase;

	public CommunIntroductionObject() {
		super();
	}

	// state

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	
}
