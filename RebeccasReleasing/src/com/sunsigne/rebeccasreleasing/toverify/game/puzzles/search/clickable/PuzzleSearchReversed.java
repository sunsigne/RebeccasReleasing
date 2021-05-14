package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.search.clickable;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.search.PuzzleSearchBuilder;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.search.object.SearchWordReversed;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.GameMouseInput;

import objects.world.puzzler.IPuzzler;

public class PuzzleSearchReversed extends PuzzleSearchBuilder<SearchWordReversed> {

	public PuzzleSearchReversed(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(puzzler, difficulty, true);
	}

	@Override
	public void mousePressed(int mx, int my) {

		// verify if you are above the folder AND not above any SearchWord
		// -> close the game because paradox
		for (int i = 0; i < 6; i++) {
			if (getWord(i).doesExist() && GameMouseInput.mouseOver(mx, my, getWord(i).getRect())
					&& GameMouseInput.mouseOver(mx, my, getFolder().getRect())) {
				setWinning(false);
				close();
			}
		}

		// verify if you are above a SearchWord
		// -> grab it
		for (int i = 0; i < 6; i++) {
			if (getWord(i).doesExist() && GameMouseInput.mouseOver(mx, my, getWord(i).getRect())) {
				getWord(i).setDragged(true);
				return;
			}
		}

		// verify if you are above the folder
		// -> spawn a good SearchWord
		if (GameMouseInput.mouseOver(mx, my, getFolder().getRect())) {
			for (int i = 0; i < 6; i++) {
				if (getWord(i).isGoodWord() && !getWord(i).doesExist()) {
					getWord(i).placeWord();
					break;
				}
			}
		}
	}

	@Override
	public void mouseReleased(int mx, int my) {

		// verify if you are above a SearchWord AND if you are or not grabbing one
		// -> close the game because paradox
		for (int i = 0; i < 6; i++) {
			if (getWord(i).doesExist() && GameMouseInput.mouseOver(mx, my, getWord(i).getRect()) && !AWordIsDragged())
			{
				setWinning(false);
				close();
			}
		}

		// verify if you are grabbing a SearchWord
		// -> release it and make is stable
		// (note : grabbing one doesn't make it unstable, it's normal)
		for (int i = 0; i < 6; i++) {
			if (getWord(i).isDragged()) {
				getWord(i).setDragged(false);
				getWord(i).setStable(true);
			}
		}

		boolean winning = true;
		for (int i = 0; i < 6; i++) {
			if (!getWord(i).isStable())
				winning = false;
		}
		setWinning(winning);
	}

	private boolean AWordIsDragged() {
		for (int i = 0; i < 6; i++) {
			if (getWord(i).isDragged())
				return true;
		}
		return false;
	}

}
