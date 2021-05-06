
package com.sunsigne.rebeccasreleasing.game.puzzles.lazer.clickable;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.bomb.PuzzleBombBuilder;
import com.sunsigne.rebeccasreleasing.game.puzzles.bomb.object.Bomb;
import com.sunsigne.rebeccasreleasing.game.puzzles.lazer.PuzzleLazerBuilder;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseInput;

import objects.world.puzzler.IPuzzler;

public class PuzzleLazer extends PuzzleLazerBuilder {

	public PuzzleLazer(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(puzzler, difficulty, false);
	}

	@Override
	public void mousePressed(int mx, int my) {
		for (int i = 0; i < 2; i++) {
			if (GameMouseInput.mouseOver(mx, my, getWire(i).getRect()))
				getWire(i).setCut(true);
		}
	}

	@Override
	public void mouseReleased(int mx, int my) {

		boolean winning = true;

		for (int i = 0; i < 2; i++) {
			if (!getWire(i).isCut())
				winning = false;
		}
		setWinning(winning);
		if (isWinning())
			close();
	}


}
