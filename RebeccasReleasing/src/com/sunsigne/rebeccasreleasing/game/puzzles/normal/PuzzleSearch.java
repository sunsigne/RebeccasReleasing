package com.sunsigne.rebeccasreleasing.game.puzzles.normal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.puzzle.GameTimer;
import objects.puzzle.WallPuzzle;
import objects.puzzle.search.SearchFolder;
import objects.puzzle.search.SearchWord;
import objects.world.puzzler.PuzzlerObject;

public class PuzzleSearch extends Puzzle {

	private static SearchWord[] word = new SearchWord[6];
	private static SearchFolder searchfolder;

	public PuzzleSearch(PuzzlerObject puzzler, DIFFICULTY difficulty) {
		super(STATE.PUZZLESEARCH, puzzler, difficulty);
	}

	@Override
	public void createFrame() {
		HandlerObject.getInstance().addObject(new WallPuzzle(Size.X0, Size.Y0, WallPuzzle.WALLTYPE.SEARCH));
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
		HandlerObject.getInstance().addObject(word[0]);
		HandlerObject.getInstance().addObject(word[1]);
		HandlerObject.getInstance().addObject(word[2]);
		HandlerObject.getInstance().addObject(word[3]);
		HandlerObject.getInstance().addObject(word[4]);
		HandlerObject.getInstance().addObject(word[5]);
	}

	@Override
	public void mousePressed(int mx, int my) {
		if (word[0].doesExist() && GameMouseListener.mouseOver(mx, my, word[0].getX(), word[0].getY(),
				Size.TILE_PUZZLE * 3, Size.TILE_PUZZLE)) {
			word[0].setDragged(true);
			return;
		}

		if (word[1].doesExist() && GameMouseListener.mouseOver(mx, my, word[1].getX(), word[1].getY(),
				Size.TILE_PUZZLE * 3, Size.TILE_PUZZLE)) {
			word[1].setDragged(true);
			return;
		}

		if (word[2].doesExist() && GameMouseListener.mouseOver(mx, my, word[2].getX(), word[2].getY(),
				Size.TILE_PUZZLE * 3, Size.TILE_PUZZLE)) {
			word[2].setDragged(true);
			return;
		}

		if (word[3].doesExist() && GameMouseListener.mouseOver(mx, my, word[3].getX(), word[3].getY(),
				Size.TILE_PUZZLE * 3, Size.TILE_PUZZLE)) {
			word[3].setDragged(true);
			return;
		}

		if (word[4].doesExist() && GameMouseListener.mouseOver(mx, my, word[4].getX(), word[4].getY(),
				Size.TILE_PUZZLE * 3, Size.TILE_PUZZLE)) {
			word[4].setDragged(true);
			return;
		}

		if (word[5].doesExist() && GameMouseListener.mouseOver(mx, my, word[5].getX(), word[5].getY(),
				Size.TILE_PUZZLE * 3, Size.TILE_PUZZLE)) {
			word[5].setDragged(true);
			return;
		}
	}

	@Override
	public void mouseReleased(int mx, int my) {

		boolean winning = true;
		for (int i = 0; i <= 5; i++) {
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
	public String getSuccessSound() {
		return null;
	}

}
