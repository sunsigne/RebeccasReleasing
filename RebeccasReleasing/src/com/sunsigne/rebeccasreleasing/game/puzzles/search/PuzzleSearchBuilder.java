package com.sunsigne.rebeccasreleasing.game.puzzles.search;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.search.object.SearchFolder;
import com.sunsigne.rebeccasreleasing.game.puzzles.search.object.SearchWord;
import com.sunsigne.rebeccasreleasing.game.puzzles.search.object.SearchWordObject;
import com.sunsigne.rebeccasreleasing.game.puzzles.search.object.SearchWordReversed;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.world.puzzler.IPuzzler;

public abstract class PuzzleSearchBuilder<T> extends Puzzle {

	private static SearchWordObject[] word = new SearchWordObject[6];
	private static SearchFolder searchfolder;

	public PuzzleSearchBuilder(IPuzzler puzzler, DIFFICULTY difficulty, boolean reversed) {
		super(STATE.PUZZLE, puzzler, difficulty, reversed);
	}

	@SuppressWarnings("unchecked")
	protected T getWord(int number) {
		return (T) word[number];
	}

	protected SearchFolder getFolder() {
		return searchfolder;
	}

	protected SearchWordObject createSearchWord(int wordnumber, int x, int y) {
		if (!isReversed())
			return new SearchWord(wordnumber, x, y);
		return new SearchWordReversed(wordnumber, x, y);
	}

	@Override
	public void randomGeneration() {

		// creation of two different random numbers
		int r0 = 1 + new Random().nextInt(5);
		int r1 = 1 + new Random().nextInt(5);
		while (r0 == r1)
			r1 = 1 + new Random().nextInt(5);

		int x0 = 350;
		int y0 = 300;

		// loop to take all SearchWord
		for (int j = 0; j <= 1; j++) {
			for (int i = 0; i <= 2; i++) {

				// creation of random position for SearchWord
				int radX = new Random().nextInt(200);
				int radY = new Random().nextInt(100);
				if (Math.random() <= 0.5)
					radX = -1 * radX;
				if (Math.random() <= 0.5)
					radY = -1 * radY;

				// creation of random word for SearchWord
				int radWord = 3 + new Random().nextInt(6);

				// if the loop tour is egal to one of the two random numbers
				// initially generated, the word MUST be "TOP" OR "SECRET"
				if (i + 3 * j == r0)
					radWord = 1;
				if (i + 3 * j == r1)
					radWord = 2;

				// creation of SearchWord
				word[i + 3 * j] = createSearchWord(radWord, x0 + radX + i * 500, y0 + radY + j * 250);
			}
		}
	}

	@Override
	public void createPuzzle() {
		searchfolder = new SearchFolder();

		HandlerObject.getInstance().addObject(searchfolder);

		for (int i = 0; i < 6; i++) {
			if (isReversed() && word[i].isGoodWord())
				continue;
			HandlerObject.getInstance().addObject(word[i]);
		}
	}

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(35, 25, 45, 240));
		renderingFakeWall(g, texture.decor_wall[4]);

	}

	@Override
	public BufferedSound getSuccessSound() {
		return null;
	}

}
