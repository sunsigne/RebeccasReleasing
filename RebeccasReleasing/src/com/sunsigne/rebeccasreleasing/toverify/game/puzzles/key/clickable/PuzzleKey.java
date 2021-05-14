
package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.key.clickable;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.key.PuzzleKeyBuilder;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.key.object.Key;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;

import objects.world.puzzler.IPuzzler;

public class PuzzleKey extends PuzzleKeyBuilder<Key> {

	public PuzzleKey(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(puzzler, difficulty, false);
	}

	@Override
	public void mousePressed(int mx, int my) {
		if (Conductor.getState() == STATE.PUZZLE)
			getKey().setThrowing(true);
	}

	@Override
	public void mouseReleased(int mx, int my) {
	}

}
