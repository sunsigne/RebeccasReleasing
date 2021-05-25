
package com.sunsigne.rebeccasreleasing.game.puzzles.key.clickable;

import com.sunsigne.rebeccasreleasing.game.puzzles.key.PuzzleKeyBuilder;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.KeyReversed;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler.IPuzzler;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;

public class PuzzleKeyReversed extends PuzzleKeyBuilder<KeyReversed> {

	public PuzzleKeyReversed(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(puzzler, difficulty, false);
	}

	@Override
	public void mousePressed(int mx, int my) {
	}

	@Override
	public void mouseReleased(int mx, int my) {
		if (Conductor.getState() == STATE.PUZZLE) {

			KeyReversed key = getKey();
			if (!key.doesExist()) {
				key.setX(getLock().getX());
				key.setY(getLock().getY());
				key.setExist(true);
				HandlerObject.getInstance().addObject(key);
			}
		}
	}
}
