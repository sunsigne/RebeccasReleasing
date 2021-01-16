
package com.sunsigne.rebeccasreleasing.game.puzzles.reversed;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.verify.IPuzzler;

import objects.puzzle.GameTimer;
import objects.puzzle.GameTimerReversed;
import objects.puzzle.WallPuzzle;
import objects.puzzle.key.KeyReversed;
import objects.puzzle.key.Lock;

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
			HandlerObject.getInstance()
					.addObject(new WallPuzzle(Size.X0 + i * Size.TILE_PUZZLE, Size.Y0, WallPuzzle.WALLTYPE.KEY));
			HandlerObject.getInstance().addObject(new WallPuzzle(Size.X0 + i * Size.TILE_PUZZLE,
					Size.Y0 + 7 * Size.TILE_PUZZLE, WallPuzzle.WALLTYPE.KEY));
		}
		for (int i = 0; i < 8; i++) {
			HandlerObject.getInstance()
					.addObject(new WallPuzzle(Size.X0, Size.Y0 + i * Size.TILE_PUZZLE, WallPuzzle.WALLTYPE.KEY));
			HandlerObject.getInstance().addObject(new WallPuzzle(Size.X0 + 13 * Size.TILE_PUZZLE,
					Size.Y0 + i * Size.TILE_PUZZLE, WallPuzzle.WALLTYPE.KEY));
		}
		HandlerObject.getInstance().addObject(new GameTimerReversed(GameTimer.TIME, () -> close()));

	}

	@Override
	public void randomGeneration() {
		int r0 = 2 + new Random().nextInt(10);
		int r1 = 1 + new Random().nextInt(5);

		HandlerObject.getInstance().addObject(new WallPuzzle(Size.X0 + r0 * Size.TILE_PUZZLE,
				Size.Y0 + r1 * Size.TILE_PUZZLE, WallPuzzle.WALLTYPE.KEY));
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
	public BufferedSound getSuccessSound() {

		return SoundBank.getSound(SoundBank.r_opening_door);
	}

}
