
package com.sunsigne.rebeccasreleasing.game.puzzles.key.clickable;

import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.commun_object.WallPuzzle;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

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
		randomOneWall = new WallPuzzle(Size.X0 + col * Size.TILE_PUZZLE, 0, texture.decor_wall[1][3]);
		HandlerObject.getInstance().addObject(randomOneWall);
	}

	private void changeYPosOfWall() {
		getLock().tick();
		randomOneWall.setY(getLock().getY());
	}

}
