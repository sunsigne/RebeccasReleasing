package objects.puzzle;

import com.sunsigne.rebeccasreleasing.main.Size;

import objects.GameObject;
import objects.OBJECTID;

public abstract class PuzzleObject extends GameObject {

	public PuzzleObject(int x, int y, OBJECTID id) {
		super(false, x, y, id);

		w = Size.TILE_PUZZLE;
		h = Size.TILE_PUZZLE;
	}	

}
