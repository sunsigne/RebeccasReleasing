package objects.characters.living;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.main.Game;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;

import objects.AnimatedObject;
import objects.OBJECTID;
import objects.characters.collision.CollisionDetector;

public abstract class LivingObject extends AnimatedObject {

	public Puzzle puzzle;
	public CollisionDetector collisionDetector;

	protected boolean[] watching = new boolean[4];
	private boolean flagX, flagY;

	public LivingObject(int x, int y, OBJECTID objectid, int animation) {
		super(x, y, objectid, animation);

		watching[Size.DIRECTION_DOWN] = true;
		w = Size.TILE;
		h = Size.TILE;
	}

	// state

	@Override
	public boolean isCameraDependant() {
		return true;
	}

	public boolean isPlayerActive() {

		if (Conductor.getState() == STATE.LEVEL || Conductor.getState() == STATE.CHATTING)
			return true;
		else {
			setMotionless();
			return false;
		}
	}

	@Override
	public void tick() {

		updateWatchingDirection();
		if (isPlayerActive())
			velocity();
		collisionDetector.update();
	}

	protected void updateWatchingDirection() {
		if (isMotionlessbyX())
			flagX = false;
		if (isMotionlessbyY())
			flagY = false;

		if (!flagX && velY < 0) {
			watching[Size.DIRECTION_UP] = true;
			watching[Size.DIRECTION_DOWN] = false;
			watching[Size.DIRECTION_LEFT] = false;
			watching[Size.DIRECTION_RIGHT] = false;
			flagY = true;
		}
		if (!flagX && velY > 0) {
			watching[Size.DIRECTION_UP] = false;
			watching[Size.DIRECTION_DOWN] = true;
			watching[Size.DIRECTION_LEFT] = false;
			watching[Size.DIRECTION_RIGHT] = false;
			flagY = true;
		}
		if (!flagY && velX < 0) {
			watching[Size.DIRECTION_UP] = false;
			watching[Size.DIRECTION_DOWN] = false;
			watching[Size.DIRECTION_LEFT] = true;
			watching[Size.DIRECTION_RIGHT] = false;
			flagX = true;
		}
		if (!flagY && velX > 0) {
			watching[Size.DIRECTION_UP] = false;
			watching[Size.DIRECTION_DOWN] = false;
			watching[Size.DIRECTION_LEFT] = false;
			watching[Size.DIRECTION_RIGHT] = true;
			flagX = true;
		}
	}

	@Override
	public void render(Graphics g) {

		drawHitbox(g);
	}

	@Override
	protected void drawHitbox(Graphics g) {
		if (Game.visibleHitbox) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.white);
			g2d.draw(getBounds());
			g2d.draw(getBoundsTop());
			g2d.draw(getBoundsLeft());
			g2d.draw(getBoundsRight());
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 4, y + h / 2, w / 2, h / 2);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle(x + w / 4, y, w / 2, h / 2);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle(x, y + h / 8, w / 6, 6 * w / 8);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle(x + 5 * w / 6, y + h / 8, w / 6, 6 * w / 8);
	}

}
