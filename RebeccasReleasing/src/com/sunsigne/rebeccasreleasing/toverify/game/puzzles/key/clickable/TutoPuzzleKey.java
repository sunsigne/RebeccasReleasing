
package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.key.clickable;

import java.util.Random;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.common_object.WallPuzzle;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

import objects.world.puzzler.IPuzzler;

public class TutoPuzzleKey extends PuzzleKey {

	private static WallPuzzle randomOneWall;

	// this puzzlekey is to teach the player he can move the lock with its mouse.
	public TutoPuzzleKey(IPuzzler puzzler) {
		super(puzzler, DIFFICULTY.CYAN);
		changeYPosOfWall();
	}

	@Override
	public void randomGeneration() {
		int col = 2 + new Random().nextInt(10);
		randomOneWall = new WallPuzzle(Size.X0 + col * Size.TILE_PUZZLE, 0, texture.decor_wall[3]);
		HandlerObject.getInstance().addObject(randomOneWall);
	}

	private void changeYPosOfWall() {
		getLock().tick();
		randomOneWall.setY(getLock().getY());
	}

}
