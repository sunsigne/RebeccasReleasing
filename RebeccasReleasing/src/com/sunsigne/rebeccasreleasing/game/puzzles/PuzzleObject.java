package com.sunsigne.rebeccasreleasing.game.puzzles;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public abstract class PuzzleObject extends GameObject {

	public PuzzleObject(int x, int y) {
		super(false, LAYER.WOLRD_GUI_PUZZLE, x, y);

		w = Size.TILE_PUZZLE;
		h = Size.TILE_PUZZLE;
	}	

}
