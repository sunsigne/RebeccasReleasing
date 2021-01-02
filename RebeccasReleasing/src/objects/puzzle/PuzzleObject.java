package objects.puzzle;

import objects.GameObject;
import objects.OBJECTID;

public abstract class PuzzleObject extends GameObject {

	public PuzzleObject(int x, int y, OBJECTID id) {
		super(x, y, id);

	}	

	@Override
	public boolean isCameraDependant() {
		return false;
	}
	

}
