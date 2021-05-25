package com.sunsigne.rebeccasreleasing.game.puzzles.key.object;

import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;

public class KeyForward extends KeyObject {

	public KeyForward(int x, int y) {
		super(x, y);
	}

	private boolean throwing;

	public void setThrowing(boolean throwing) {
		this.throwing = throwing;
	}

	public boolean isThrowing() {
		return throwing;
	}

	////////// TICK ////////////

	@Override
	public void tick() {
		if (Conductor.getState() == STATE.PUZZLE) {
			velocity();

			if (isThrowing()) {
				velY = 0;
				velX--;
			} else
				goesUpandDown();
		}
	}
}
