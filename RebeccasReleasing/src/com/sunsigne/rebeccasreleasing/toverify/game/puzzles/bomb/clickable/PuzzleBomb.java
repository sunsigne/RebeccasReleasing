
package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb.clickable;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb.PuzzleBombBuilder;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb.object.Bomb;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.GameMouseInput;

import objects.world.puzzler.IPuzzler;

public class PuzzleBomb extends PuzzleBombBuilder<Bomb> {

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
