
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
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.puzzle.GameTimer;
import objects.puzzle.GameTimerReversed;
import objects.puzzle.FakeWallPuzzle;
import objects.puzzle.bomb.BombReversed;
import objects.world.puzzler.IPuzzler;

public class PuzzleBombReversed extends Puzzle {

	private static final int NUMOFBOMB = 4;
	private static BombReversed[] bomb = new BombReversed[NUMOFBOMB];

	public PuzzleBombReversed(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(STATE.PUZZLEBOMB, puzzler, difficulty, true);
	}

	@Override
	public void createFrame() {
		HandlerObject.getInstance().addObject(new FakeWallPuzzle(Size.X0, Size.Y0, FakeWallPuzzle.WALLTYPE.BOMB));
		HandlerObject.getInstance().addObject(new GameTimerReversed(GameTimer.TIME, () -> close()));
	}

	@Override
	public void randomGeneration() {
		for (int i = 0; i < NUMOFBOMB; i++) {
			bomb[i] = new BombReversed(Size.X0 + (6 * i + 3) * (Size.TILE_PUZZLE / 2),
					Size.Y0 + (1 + new Random().nextInt(5)) * Size.TILE_PUZZLE);
		}
	}

	@Override
	public void createPuzzle() {
		for (int i = 0; i < NUMOFBOMB; i++) {
			HandlerObject.getInstance().addObject(bomb[i]);
		}
	}

	@Override
	public void mousePressed(int mx, int my) {

	}

	@Override
	public void mouseReleased(int mx, int my) {

		boolean winning = true;

		for (int i = 0; i < NUMOFBOMB; i++) {
			if (GameMouseListener.mouseOver(mx, my, bomb[i].getRect()))
				bomb[i].addCount();
		}

		for (int i = 0; i < NUMOFBOMB; i++) {
			if (!bomb[i].isWinning())
				winning = false;
		}
		setWinning(winning);

	}

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(50, 10, 10, 240));

	}

	@Override
	public BufferedSound getSuccessSound() {

		return SoundBank.getSound(SoundBank.r_explosion_big);

	}
}
