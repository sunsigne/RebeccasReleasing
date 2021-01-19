
package com.sunsigne.rebeccasreleasing.game.puzzles.key.clickable;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.PuzzleKeyBuilder;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.Key;

import objects.world.puzzler.IPuzzler;

public class PuzzleKey extends PuzzleKeyBuilder<Key> {

	public PuzzleKey(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(puzzler, difficulty, false);
	}

	@Override
	public void mousePressed(int mx, int my) {
		getKey().setThrowing(true);
	}

	@Override
	public void mouseReleased(int mx, int my) {
	}

}
