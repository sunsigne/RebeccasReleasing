
package com.sunsigne.rebeccasreleasing.game.puzzles.normal;

import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.verify.IPuzzler;

import objects.puzzle.WallPuzzle;
import objects.puzzle.key.Key;
import objects.puzzle.key.Lock;

public class TutoPuzzleKey extends PuzzleKey {

	private static Lock lock;
	private static WallPuzzle randomOneWall;

	// this specific puzzlekey is exactly like a regular one, but the only wall spawn right between the lock
	// and the key. The objective is the player must understand he can move the lock with its mouse.
	public TutoPuzzleKey(IPuzzler puzzler) {
		super(puzzler, DIFFICULTY.CYAN);
		changeYPosOfWall();

	}

	@Override
	public void randomGeneration() {
		int col = 2 + new Random().nextInt(10);
		randomOneWall = new WallPuzzle(Size.X0 + col * Size.TILE_PUZZLE, 3000, WallPuzzle.WALLTYPE.KEY);
		HandlerObject.getInstance().addObject(randomOneWall);
	}

	@Override
	public void createPuzzle() {
		key = new Key(Size.X0 + 12 * Size.TILE_PUZZLE, Size.Y0 + 7 * Size.TILE_PUZZLE / 2);
		lock = new Lock(Size.X0 + Size.TILE_PUZZLE, Size.Y0 + 7 * Size.TILE_PUZZLE / 2);
		HandlerObject.getInstance().addObject(lock);
		HandlerObject.getInstance().addObject(key);

	}

	private void changeYPosOfWall() {
		lock.tick();
		randomOneWall.setY(lock.getY());
	}

	
}
