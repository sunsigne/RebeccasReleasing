package objects.puzzle.bomb;

import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;

import objects.AnimatedObject;
import objects.OBJECTID;

public abstract class BombObject extends AnimatedObject{

	private boolean exploding;
	protected int boomtime = 30;
	protected int totalcount, count;
	
	public BombObject(int x, int y, OBJECTID id, int animation) {
		super(x, y, id, animation);

		w = 2 * Size.TILE_PUZZLE;
		h = 2 * Size.TILE_PUZZLE;
	}


	public void setExploding(boolean exploding) {
		this.exploding = exploding;
	}

	public boolean isExploding() {
		return exploding;
	}


	@Override
	public boolean isCameraDependant() {
		return false;
	}

	
	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

}
