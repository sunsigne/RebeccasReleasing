
package com.sunsigne.rebeccasreleasing.game.puzzles.normal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.puzzle.GameTimer;
import objects.puzzle.WallPuzzle;
import objects.puzzle.bomb.Bomb;
import objects.world.puzzler.IPuzzler;
import tofinish.AudioBank;

@Todo("difficulty : moving bomb, bigger count, more bomb")
public class PuzzleBomb extends Puzzle {

	private static Bomb[] bomb = new Bomb[4];

	public PuzzleBomb(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(STATE.PUZZLEBOMB, puzzler, difficulty);
	}

	@Override
	public void createFrame() {
		HandlerObject.getInstance().addObject(new WallPuzzle(Size.X0, Size.Y0, WallPuzzle.WALLTYPE.BOMB));
		HandlerObject.getInstance().addObject(new GameTimer(GameTimer.TIME, () -> close()));
	}

	@Override
	public void randomGeneration() {
		bomb[0] = new Bomb(Size.X0 + 3 * Size.TILE_PUZZLE / 2,
				Size.Y0 + (1 + new Random().nextInt(5)) * Size.TILE_PUZZLE);
		bomb[1] = new Bomb(Size.X0 + 9 * Size.TILE_PUZZLE / 2,
				Size.Y0 + (1 + new Random().nextInt(5)) * Size.TILE_PUZZLE);
		bomb[2] = new Bomb(Size.X0 + 15 * Size.TILE_PUZZLE / 2,
				Size.Y0 + (1 + new Random().nextInt(5)) * Size.TILE_PUZZLE);
		bomb[3] = new Bomb(Size.X0 + 21 * Size.TILE_PUZZLE / 2,
				Size.Y0 + (1 + new Random().nextInt(5)) * Size.TILE_PUZZLE);

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
		if (GameMouseListener.mouseOver(mx, my, bomb[0].getX(), bomb[0].getY(), 2 * Size.TILE_PUZZLE,
				2 * Size.TILE_PUZZLE))
			bomb[0].removeCount();
		if (GameMouseListener.mouseOver(mx, my, bomb[1].getX(), bomb[1].getY(), 2 * Size.TILE_PUZZLE,
				2 * Size.TILE_PUZZLE))
			bomb[1].removeCount();
		if (GameMouseListener.mouseOver(mx, my, bomb[2].getX(), bomb[2].getY(), 2 * Size.TILE_PUZZLE,
				2 * Size.TILE_PUZZLE))
			bomb[2].removeCount();
		if (GameMouseListener.mouseOver(mx, my, bomb[3].getX(), bomb[3].getY(), 2 * Size.TILE_PUZZLE,
				2 * Size.TILE_PUZZLE))
			bomb[3].removeCount();
	}

	@Override
	public void mouseReleased(int mx, int my) {

		boolean winning = true;

		if (bomb[0].isExploding() && bomb[1].isExploding() && bomb[2].isExploding())
			bomb[3].setLastbomb(true);
		if (bomb[1].isExploding() && bomb[2].isExploding() && bomb[3].isExploding())
			bomb[0].setLastbomb(true);
		if (bomb[2].isExploding() && bomb[3].isExploding() && bomb[0].isExploding())
			bomb[1].setLastbomb(true);
		if (bomb[3].isExploding() && bomb[0].isExploding() && bomb[1].isExploding())
			bomb[2].setLastbomb(true);

		for (int i = 0; i <= 3; i++) {
			if (!bomb[i].isExploding())
				winning = false;
		}
		setWinning(winning);
		if (isWinning())
			close();
	}

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(50, 10, 10, 240));

	}

	@Override
	public AudioBank getSuccessSound() {

		return SoundBank.explosion_big;
	}

}
