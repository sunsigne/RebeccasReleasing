package com.sunsigne.rebeccasreleasing.game.puzzles.search.clickable;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.search.PuzzleSearchBuilder;
import com.sunsigne.rebeccasreleasing.game.puzzles.search.object.SearchWord;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseInput;

import objects.world.puzzler.IPuzzler;

public class PuzzleSearch extends PuzzleSearchBuilder<SearchWord> {

	public PuzzleSearch(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(puzzler, difficulty, false);
	}

	@Override
	public void mousePressed(int mx, int my) {

		for (int i = 0; i < 6; i++) {
			if (getWord(i).doesExist() && GameMouseInput.mouseOver(mx, my, getWord(i).getRect())) {
				getWord(i).setDragged(true);
				return;
			}
		}
	}

	@Override
	public void mouseReleased(int mx, int my) {

		boolean winning = true;
		for (int i = 0; i < 6; i++) {
			if (getWord(i).isDragged() && getWord(i).isAboveFolder())
				getWord(i).placeWord();

			getWord(i).setDragged(false);

			if (!getWord(i).isStable())
				winning = false;
		}
		setWinning(winning);
		if (isWinning())
			close();
	}

}
