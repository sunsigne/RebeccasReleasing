package com.sunsigne.rebeccasreleasing.game.puzzles.commun_object;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;

public abstract class PuzzleObject extends GameObject {

	public PuzzleObject(int x, int y, OBJECTID id) {
		super(false, x, y, id);

		w = Size.TILE_PUZZLE;
		h = Size.TILE_PUZZLE;
	}	

}
