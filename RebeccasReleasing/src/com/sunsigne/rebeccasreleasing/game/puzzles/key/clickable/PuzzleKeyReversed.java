
package com.sunsigne.rebeccasreleasing.game.puzzles.key.clickable;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.PuzzleKeyBuilder;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.KeyReversed;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.world.puzzler.IPuzzler;

public class PuzzleKeyReversed extends PuzzleKeyBuilder<KeyReversed> {

	public PuzzleKeyReversed(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(puzzler, difficulty, true);
	}

	@Override
	public void mousePressed(int mx, int my) {
	}

	@Override
	public void mouseReleased(int mx, int my) {
		if (!getKey().doesExist()) {
			replaceKey(new KeyReversed(getLock().getX(), getLock().getY()));
			getKey().setExist(true);
			HandlerObject.getInstance().addObject(getKey());
		}
	}

}
