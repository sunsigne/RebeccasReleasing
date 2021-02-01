package com.sunsigne.rebeccasreleasing.game.menu.introduction;

import com.sunsigne.rebeccasreleasing.game.menu.MenuObject;

abstract class CommunIntroductionObject extends MenuObject {

	private int phase;
	private float opacity = 1f;

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
	
	public float getOpacity() {
		return opacity;
	}

	public void setOpacity(float opacity) {
		this.opacity = opacity;
	}
	
}
