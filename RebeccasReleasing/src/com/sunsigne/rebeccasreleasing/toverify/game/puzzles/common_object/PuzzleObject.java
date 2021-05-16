package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.common_object;

import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.GameObject;

public abstract class PuzzleObject extends GameObject {

	public PuzzleObject(int x, int y, OBJECTID id) {
		super(false, 0, x, y, id);

		w = Size.TILE_PUZZLE;
		h = Size.TILE_PUZZLE;
	}	

}
