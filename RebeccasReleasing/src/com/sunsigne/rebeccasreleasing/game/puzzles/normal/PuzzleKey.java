
package com.sunsigne.rebeccasreleasing.game.puzzles.normal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.puzzle.GameTimer;
import objects.puzzle.WallPuzzle;
import objects.puzzle.key.Key;
import objects.puzzle.key.Lock;
import objects.world.puzzler.IPuzzler;

@Todo("pour tuto : immobiliser la clef loin du cadenas")
public class PuzzleKey extends Puzzle {

	private static Key key;

	public PuzzleKey(IPuzzler puzzler, DIFFICULTY difficulty) {
		super(STATE.PUZZLEKEY, puzzler, difficulty);
		GameCursor.hideCursor(true);
	}

	@Override
	public void createFrame() {
		for (int i = 0; i < 13; i++) {
			HandlerObject.getInstance().addObject(new WallPuzzle(Size.X0 + i * Size.TILE_PUZZLE, Size.Y0, WallPuzzle.WALLTYPE.KEY));
			HandlerObject.getInstance().addObject(
					new WallPuzzle(Size.X0 + i * Size.TILE_PUZZLE, Size.Y0 + 7 * Size.TILE_PUZZLE, WallPuzzle.WALLTYPE.KEY));
		}
		for (int i = 0; i < 8; i++) {
			HandlerObject.getInstance().addObject(new WallPuzzle(Size.X0, Size.Y0 + i * Size.TILE_PUZZLE, WallPuzzle.WALLTYPE.KEY));
			HandlerObject.getInstance().addObject(
					new WallPuzzle(Size.X0 + 13 * Size.TILE_PUZZLE, Size.Y0 + i * Size.TILE_PUZZLE, WallPuzzle.WALLTYPE.KEY));
		}

		HandlerObject.getInstance().addObject(new GameTimer(GameTimer.TIME, () -> {
			close();
			if (World.levelnum == 1 && !World.currentWorld.getIEvent().hasOccured(5) && !World.currentWorld.getIEvent().hasOccured(6)) {
				int playerPosX = HandlerObject.getInstance().player.getX();
				HandlerObject.getInstance().player.setX(playerPosX - Size.TILE/2);
				World.currentWorld.getIEvent().setMustoccur(true, 4);
			}
		}));
	}

	@Override
	public void randomGeneration() {
		int j = 1;
		if (getDifficulty().getLvl() >= 2)
			j = 5;

		for (int i = 0; i < j; i++) {
			int r0 = 2 + new Random().nextInt(10);
			int r1 = 1 + new Random().nextInt(5);

			HandlerObject.getInstance().addObject(
					new WallPuzzle(Size.X0 + r0 * Size.TILE_PUZZLE, Size.Y0 + r1 * Size.TILE_PUZZLE, WallPuzzle.WALLTYPE.KEY));
		}
	}

	@Override
	public void createPuzzle() {
		key = new Key(Size.X0 + 12 * Size.TILE_PUZZLE, Size.Y0 + 7 * Size.TILE_PUZZLE / 2);
		HandlerObject.getInstance().addObject(new Lock(Size.X0 + Size.TILE_PUZZLE, Size.Y0 + 7 * Size.TILE_PUZZLE / 2));
		HandlerObject.getInstance().addObject(key);
	}

	@Override
	public void mousePressed(int mx, int my) {
		key.setThrowing(true);
	}

	@Override
	public void mouseReleased(int mx, int my) {
	}

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(15, 45, 10, 240));

	}

	@Override
	public BufferedSound getSuccessSound() {
		return SoundBank.getSound(SoundBank.opening_door);
	}

}
