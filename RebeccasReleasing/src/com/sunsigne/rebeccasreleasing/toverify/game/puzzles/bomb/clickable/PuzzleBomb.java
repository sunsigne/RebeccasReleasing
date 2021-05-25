
package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb.clickable;

import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler.IPuzzler;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb.PuzzleBombBuilder;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb.object.BombForward;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.GameMouseInput;

public class PuzzleBomb extends PuzzleBombBuilder<BombForward> {

	public PuzzleBomb(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(puzzler, difficulty, false);
	}

	@Override
	public void mousePressed(int mx, int my) {
		for (int i = 0; i < 4; i++) {
			if (GameMouseInput.mouseOver(mx, my, getBomb(i).getRect()))
				getBomb(i).removeCount();
		}
	}

	@Override
	public void mouseReleased(int mx, int my) {

		boolean winning = true;

		for (int i = 0; i < 4; i++) {
			if (!getBomb(i).isExploding())
				winning = false;
		}
		setWinning(winning);
		if (isWinning())
			close();
	}


}
