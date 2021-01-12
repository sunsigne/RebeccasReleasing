
package com.sunsigne.rebeccasreleasing.game.puzzles.reversed;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.puzzle.GameTimer;
import objects.puzzle.GameTimerReversed;
import objects.puzzle.WallPuzzle;
import objects.puzzle.bomb.BombReversed;
import objects.world.puzzler.IPuzzler;

public class PuzzleBombReversed extends Puzzle {

	private static BombReversed[] bomb = new BombReversed[4];

	public PuzzleBombReversed(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(STATE.PUZZLEBOMB, puzzler, difficulty, true);
	}

	@Override
	public void createFrame() {
		HandlerObject.getInstance().addObject(new WallPuzzle(Size.X0, Size.Y0, WallPuzzle.WALLTYPE.BOMB));
		HandlerObject.getInstance().addObject(new GameTimerReversed(GameTimer.TIME, () -> close()));
	}

	@Override
	public void randomGeneration() {
		bomb[0] = new BombReversed(Size.X0 + 3 * Size.TILE_PUZZLE / 2, Size.Y0 + (1 + new Random().nextInt(5)) * Size.TILE_PUZZLE);
		bomb[1] = new BombReversed(Size.X0 + 9 * Size.TILE_PUZZLE / 2, Size.Y0 + (1 + new Random().nextInt(5)) * Size.TILE_PUZZLE);
		bomb[2] = new BombReversed(Size.X0 + 15 * Size.TILE_PUZZLE / 2, Size.Y0 + (1 + new Random().nextInt(5)) * Size.TILE_PUZZLE);
		bomb[3] = new BombReversed(Size.X0 + 21 * Size.TILE_PUZZLE / 2, Size.Y0 + (1 + new Random().nextInt(5)) * Size.TILE_PUZZLE);

	}

	@Override
	public void createPuzzle() {
		HandlerObject.getInstance().addObject(bomb[0]);
		HandlerObject.getInstance().addObject(bomb[1]);
		HandlerObject.getInstance().addObject(bomb[2]);
		HandlerObject.getInstance().addObject(bomb[3]);
	}

	@Override
	public void mousePressed(int mx, int my) {

	}

	@Override
	public void mouseReleased(int mx, int my) {
		
		boolean winning = true;
		
		if (GameMouseListener.mouseOver(mx, my, bomb[0].getX(), bomb[0].getY(), 2 * Size.TILE_PUZZLE, 2 * Size.TILE_PUZZLE))
			bomb[0].addCount();
		if (GameMouseListener.mouseOver(mx, my, bomb[1].getX(), bomb[1].getY(), 2 * Size.TILE_PUZZLE, 2 * Size.TILE_PUZZLE))
			bomb[1].addCount();
		if (GameMouseListener.mouseOver(mx, my, bomb[2].getX(), bomb[2].getY(), 2 * Size.TILE_PUZZLE, 2 * Size.TILE_PUZZLE))
			bomb[2].addCount();
		if (GameMouseListener.mouseOver(mx, my, bomb[3].getX(), bomb[3].getY(), 2 * Size.TILE_PUZZLE, 2 * Size.TILE_PUZZLE))
			bomb[3].addCount();

		for (int i = 0; i <= 3; i++) {
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
