package com.sunsigne.rebeccasreleasing.game.puzzles.normal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.puzzle.GameTimer;
import objects.puzzle.FakeWallPuzzle;
import objects.puzzle.search.SearchFolder;
import objects.puzzle.search.SearchWord;
import objects.world.puzzler.IPuzzler;

public class PuzzleSearch extends Puzzle {

	private static final int NUMOFWORD = 6;
	private static SearchWord[] word = new SearchWord[NUMOFWORD];
	private static SearchFolder searchfolder;

	public PuzzleSearch(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(STATE.PUZZLESEARCH, puzzler, difficulty);
	}

	@Override
	public void createFrame() {
		HandlerObject.getInstance().addObject(new FakeWallPuzzle(Size.X0, Size.Y0, FakeWallPuzzle.WALLTYPE.SEARCH));
		HandlerObject.getInstance().addObject(new GameTimer(GameTimer.TIME, () -> close()));
	}

	@Override
	public void randomGeneration() {
		int r0 = 1 + new Random().nextInt(5);
		int r1 = 1 + new Random().nextInt(5);
		while (r0 == r1)
			r1 = 1 + new Random().nextInt(5);

		int x0 = 350;
		int y0 = 300;

		for (int j = 0; j <= 1; j++) {
			for (int i = 0; i <= 2; i++) {
				int radWord = 3 + new Random().nextInt(6);
				int radX = new Random().nextInt(200);
				int radY = new Random().nextInt(100);
				if (Math.random() <= 0.5)
					radX = -1 * radX;
				if (Math.random() <= 0.5)
					radY = -1 * radY;

				word[i + 3 * j] = new SearchWord(radWord, x0 + radX + i * 500, y0 + radY + j * 250);
				if (i + 3 * j == r0)
					word[i + 3 * j] = new SearchWord(1, x0 + radX + i * 500, y0 + radY + j * 250);
				if (i + 3 * j == r1)
					word[i + 3 * j] = new SearchWord(2, x0 + radX + i * 500, y0 + radY + j * 250);
			}
		}
	}

	@Override
	public void createPuzzle() {
		searchfolder = new SearchFolder();

		HandlerObject.getInstance().addObject(searchfolder);

		for (int i = 0; i < NUMOFWORD; i++) {
			HandlerObject.getInstance().addObject(word[i]);
		}
	}

	@Override
	public void mousePressed(int mx, int my) {

		for (int i = 0; i < NUMOFWORD; i++) {
			if (word[i].doesExist() && GameMouseListener.mouseOver(mx, my, word[i].getRect())) {
				word[i].setDragged(true);
				return;
			}
		}
	}

	@Override
	public void mouseReleased(int mx, int my) {

		boolean winning = true;
		for (int i = 0; i < NUMOFWORD; i++) {
			if (word[i].isDragged() && word[i].isAboveFolder())
				word[i].placeWord();

			word[i].setDragged(false);

			if (!word[i].isStable())
				winning = false;
		}
		setWinning(winning);
		if (isWinning())
			close();
	}

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(35, 25, 45, 240));

	}

	@Override
	public BufferedSound getSuccessSound() {
		return null;
	}

}
