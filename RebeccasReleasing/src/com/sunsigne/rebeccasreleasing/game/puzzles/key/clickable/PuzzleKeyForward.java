
package com.sunsigne.rebeccasreleasing.game.puzzles.key.clickable;

import com.sunsigne.rebeccasreleasing.game.puzzles.key.PuzzleKeyBuilder;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.KeyForward;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler.IPuzzler;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;

public class PuzzleKeyForward extends PuzzleKeyBuilder<KeyForward> {

	public PuzzleKeyForward(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(puzzler, difficulty, true);
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
