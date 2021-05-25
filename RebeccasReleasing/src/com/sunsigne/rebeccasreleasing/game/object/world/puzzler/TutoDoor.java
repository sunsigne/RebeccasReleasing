package com.sunsigne.rebeccasreleasing.game.object.world.puzzler;

import com.sunsigne.rebeccasreleasing.game.puzzles.key.clickable.TutoPuzzleKey;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.AXIS;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;

public class TutoDoor extends Door {

	// this specific door is exactly like a regular one but open a tutoPuzzleKey
	public TutoDoor(int x, int y, AXIS axis) {
		super(x, y, axis, DIFFICULTY.CYAN);
	}

	////////// PUZZLE ////////////

	@Override
	public Puzzle getPuzzle() {
		return new TutoPuzzleKey(this);
	}

}
