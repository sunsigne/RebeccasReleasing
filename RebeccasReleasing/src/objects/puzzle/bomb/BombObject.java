package objects.puzzle.bomb;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.IAnimation;

import objects.OBJECTID;
import objects.puzzle.PuzzleObject;

public abstract class BombObject extends PuzzleObject implements IAnimation {

	protected Animation animation;
	
	private boolean exploding;
	protected int boomtime = 30;
	protected int totalcount, count;
	
	public BombObject(int x, int y) {
		super(x, y, OBJECTID.P_BOMB);

		w = 2 * Size.TILE_PUZZLE;
		h = 2 * Size.TILE_PUZZLE;
	}


	public void setExploding(boolean exploding) {
		this.exploding = exploding;
	}

	public boolean isExploding() {
		return exploding;
	}
	
	protected void paintCount (Graphics g)
	{
		int alpha = 160;
		Font font = new Font("arial", 1, 120);
		g.setFont(font);
		if (count == totalcount)
			g.setColor(new Color(250, 50, 50, alpha));
		else
			g.setColor(Color.yellow);
	}
	
	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

}
