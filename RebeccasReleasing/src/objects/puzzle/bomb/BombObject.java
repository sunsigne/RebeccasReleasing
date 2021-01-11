package objects.puzzle.bomb;

import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;

import objects.GameObject;
import objects.OBJECTID;

public abstract class BombObject extends GameObject{

	protected Animation animation;
	
	private boolean exploding;
	protected int boomtime = 30;
	protected int totalcount, count;
	
	public BombObject(int x, int y, OBJECTID id) {
		super(x, y, id, false);

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
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

}
