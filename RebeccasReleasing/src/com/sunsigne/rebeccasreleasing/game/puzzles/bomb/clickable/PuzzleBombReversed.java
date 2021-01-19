
package com.sunsigne.rebeccasreleasing.game.puzzles.bomb.clickable;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.bomb.PuzzleBombBuilder;
import com.sunsigne.rebeccasreleasing.game.puzzles.bomb.object.BombReversed;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseInput;

import objects.world.puzzler.IPuzzler;

public class PuzzleBombReversed extends PuzzleBombBuilder<BombReversed> {

	public PuzzleBombReversed(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(puzzler, difficulty, true);
	}

	@Override
	public void mousePressed(int mx, int my) {

	}

	@Override
	public void mouseReleased(int mx, int my) {

		boolean winning = true;

		for (int i = 0; i < 4; i++) {
			if (GameMouseInput.mouseOver(mx, my, getBomb(i).getRect()))
				getBomb(i).addCount();
		}

		for (int i = 0; i < 4; i++) {
			if (!getBomb(i).isWinning())
				winning = false;
		}
		setWinning(winning);
	}

}
