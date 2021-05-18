package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.common_object;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

public abstract class PuzzleObject extends GameObject {

	public PuzzleObject(int x, int y, OBJECTID id) {
		super(false, LAYER.WOLRD_GUI_PUZZLE, x, y, id);

		w = Size.TILE_PUZZLE;
		h = Size.TILE_PUZZLE;
	}	

}
