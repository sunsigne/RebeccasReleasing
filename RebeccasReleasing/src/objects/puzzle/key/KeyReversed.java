package objects.puzzle.key;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.OBJECTID;
import objects.puzzle.PuzzleObject;

public class KeyReversed extends PuzzleObject {

	private boolean movingUP;
	private boolean exist;
	private int speed = 8;

	public KeyReversed(int x, int y) {
		super(x, y, OBJECTID.P_KEY);

		velX = 53;
		w = Size.TILE_PUZZLE;
		h = Size.TILE_PUZZLE;
	}

	// state

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public boolean doesExist() {
		return exist;
	}

	public void setMovingUP(boolean movingUP) {
		this.movingUP = movingUP;
	}

	public boolean isMovingUP() {
		return movingUP;
	}

	@Override
	public void tick() {

		velocity();
		collision();

		if (x < (Size.X0 + 12 * Size.TILE_PUZZLE))
			velX--;

		else {
			HandlerObject.getInstance().player.puzzle.setWinning(true);
			velX = 0;
			goUpandDown();
		}
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
		if (doesExist()) {
			
			LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
			for (GameObject tempObject : list) {
				if (tempObject.getId() == OBJECTID.WALL && getBounds().intersects(tempObject.getBounds())) {
					HandlerObject.getInstance().player.puzzle.close();
				}
			}
		}
	}

}
