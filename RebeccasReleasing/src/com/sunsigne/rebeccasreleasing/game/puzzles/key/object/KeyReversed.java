package com.sunsigne.rebeccasreleasing.game.puzzles.key.object;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class KeyReversed extends KeyObject {

	public KeyReversed(int x, int y) {
		super(x, y);
		velX = 53;
	}

	private boolean exist;

	public boolean doesExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	////////// TICK ////////////

	private final int xmax = Size.X0 + 12 * Size.TILE_PUZZLE;

	@Override
	public void tick() {
		if (Conductor.getState() == STATE.PUZZLE) {
			velocity();

			if (x < xmax)
				velX--;
			else {
				HandlerObject.getInstance().getPlayer().puzzle.setWinning(true);
				velX = 0;
				goesUpandDown();
			}
		}
	}
}
