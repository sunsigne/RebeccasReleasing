package objects.puzzle.key;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;

import objects.OBJECTID;
import objects.puzzle.PuzzleObject;

public class Lock extends PuzzleObject {

	int ymin = 32 + Size.TILE_PUZZLE;
	int ymax = 32 + 6 * Size.TILE_PUZZLE;

	public Lock(int x, int y) {
		super(x, y, OBJECTID.TAIL);

		w = Size.TILE_PUZZLE;
		h = Size.TILE_PUZZLE;
	}

	@Override
	public void tick() {
		if (GameMouseListener.getInstance().getPos().y < ymin)
			y = ymin;
		else if (GameMouseListener.getInstance().getPos().y > ymax)
			y = ymax;
		else
			y = GameMouseListener.getInstance().getPos().y;
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(texture.item[1], x, y, w, h, null);
		drawHitbox(g);
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 4, y + h / 4, w / 2, h / 2);
	}

}