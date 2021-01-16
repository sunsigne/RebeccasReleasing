package objects.puzzle.key;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.OBJECTID;
import objects.puzzle.PuzzleObject;

@Todo("create a power where the key destroy some walls encountered (like fist and second for exemple)")
public class Key extends PuzzleObject {

	int ymin = 32 + Size.TILE_PUZZLE;
	int ymax = 32 + 6 * Size.TILE_PUZZLE;

	private boolean movingUP;
	private boolean throwing;
	private int speed = 8;

	public Key(int x, int y) {
		super(x, y, OBJECTID.P_KEY);

		w = Size.TILE_PUZZLE;
		h = Size.TILE_PUZZLE;
	}

	// state

	public void setThrowing(boolean throwing) {
		this.throwing = throwing;
	}

	public boolean isThrowing() {
		return throwing;
	}

	@Override
	public void tick() {
		velocity();
		collision();

		if (isThrowing()) {
			velY = 0;
			velX--;
		} else
			goUpandDown();
	}

	private void goUpandDown() {
		if (movingUP) {
			velY = -speed;
			if (y < 5 * Size.TILE_PUZZLE / 4)
				movingUP = false;
		} else {
			velY = speed;
			if (y > Size.HEIGHT - 9 * Size.TILE_PUZZLE / 4)
				movingUP = true;
		}
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(texture.item[0], x, y, w, h, null);
		drawHitbox(g);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 4, y + h / 4, w / 2, h / 2);
	}

	private void collision() {

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
		for (GameObject tempObject : list) {
			if (tempObject.getId() == OBJECTID.P_LOCK && getBounds().intersects(tempObject.getBounds())) {
				HandlerObject.getInstance().player.puzzle.setWinning(true);
				HandlerObject.getInstance().player.puzzle.close();
			}
			if (tempObject.getId() == OBJECTID.WALL && getBounds().intersects(tempObject.getBounds())) {
				HandlerObject.getInstance().player.puzzle.close();
			}
		}
	}

}
