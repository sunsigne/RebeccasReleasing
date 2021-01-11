
package com.sunsigne.rebeccasreleasing.game.puzzles.reversed;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.puzzle.GameTimerReversed;
import objects.puzzle.key.KeyReversed;
import objects.puzzle.key.Lock;
import objects.world.Wall;
import objects.world.puzzler.IPuzzler;

public class PuzzleKeyReversed extends Puzzle {

	private static Lock lock;
	private static KeyReversed key;

	public PuzzleKeyReversed(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(STATE.PUZZLEKEY, puzzler, difficulty, true);
		GameCursor.hideCursor(true);
	}

	@Override
	public void createFrame() {

		for (int i = 0; i < 13; i++) {
			HandlerObject.getInstance().addObject(new Wall(Size.X0 + i * Size.TILE_PUZZLE, Size.Y0, Wall.WALLTYPE.KEY));
		}
		for (int i = 0; i < 13; i++) {
			HandlerObject.getInstance().addObject(new Wall(Size.X0 + i * Size.TILE_PUZZLE, Size.Y0 + 7 * Size.TILE_PUZZLE, Wall.WALLTYPE.KEY));
		}
		for (int i = 0; i < 8; i++) {
			HandlerObject.getInstance().addObject(new Wall(Size.X0, Size.Y0 + i * Size.TILE_PUZZLE, Wall.WALLTYPE.KEY));
		}
		for (int i = 0; i < 8; i++) {
			HandlerObject.getInstance().addObject(new Wall(Size.X0 + 13 * Size.TILE_PUZZLE, Size.Y0 + i * Size.TILE_PUZZLE, Wall.WALLTYPE.KEY));
		}

		HandlerObject.getInstance().addObject(new GameTimerReversed(GameTimerReversed.R_TIME, () -> close()));

	}

	@Override
	public void randomGeneration() {
		int r0 = 2 + new Random().nextInt(10);
		int r1 = 1 + new Random().nextInt(5);

		HandlerObject.getInstance().addObject(new Wall(Size.X0 + r0 * Size.TILE_PUZZLE, Size.Y0 + r1 * Size.TILE_PUZZLE, Wall.WALLTYPE.KEY));
	}

	@Override
	public void createPuzzle() {
		key = new KeyReversed(0, 0);
		lock = new Lock(Size.X0 + Size.TILE_PUZZLE, Size.Y0 + 7 * Size.TILE_PUZZLE / 2);
		HandlerObject.getInstance().addObject(lock);
	}

	@Override
	public void mousePressed(int mx, int my) {
	}

	@Override
	public void mouseReleased(int mx, int my) {
		if (!key.doesExist()) {
			key = new KeyReversed(lock.getX(), lock.getY());
			key.setExist(true);
			HandlerObject.getInstance().addObject(key);
		}
	}

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(15, 45, 10, 240));

	}

	@Override
	public String getSuccessSound() {

		return AudioBank.r_opening_door;
	}

}
