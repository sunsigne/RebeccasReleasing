
package com.sunsigne.rebeccasreleasing.game.puzzles.key.clickable;

import java.util.Random;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler.IPuzzler;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.WallPuzzle;

public class TutoPuzzleKey extends PuzzleKeyForward {

	private WallPuzzle randomOneWall;

	// this puzzlekey is to teach the player one can move the lock with the mouse.
	public TutoPuzzleKey(IPuzzler puzzler) {
		super(puzzler, DIFFICULTY.CYAN);
		reajustWallPosition();
	}

	@Override
	protected void randomWallGeneration(int numOfWall) {
		int col = 2 + new Random().nextInt(10);
		randomOneWall = new WallPuzzle(getCol(col), 0, texture.decor_wall[3]);
		HandlerObject.getInstance().addObject(randomOneWall);
	}

	private void reajustWallPosition() {
		getLock().tick();
		randomOneWall.setY(getLock().getY());
	}

}
