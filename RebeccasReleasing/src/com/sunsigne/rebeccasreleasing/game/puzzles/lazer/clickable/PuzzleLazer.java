
package com.sunsigne.rebeccasreleasing.game.puzzles.lazer.clickable;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.lazer.PuzzleLazerBuilder;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseInput;

import objects.world.puzzler.IPuzzler;

public class PuzzleLazer extends PuzzleLazerBuilder {

	public PuzzleLazer(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(puzzler, difficulty, false);
	}

	@Override
	public void mousePressed(int mx, int my) {
		for (int i = 0; i < NUMBEROFWIRES; i++) {
			if (getWire(i).doesExist() && GameMouseInput.mouseOver(mx, my, getWire(i).getRect()))
				getWire(i).setCut(true);
		}
	}

	@Override
	public void mouseReleased(int mx, int my) {

		boolean winning = true;

		for (int i = 0; i < NUMBEROFWIRES; i++) {
			if (getWire(i).isCut()) {
				winning = getWire(i).getColor() == getColorAnswer().getColor() ? true : false;
				setWinning(winning);
				close();
			}
		}
	}

}
