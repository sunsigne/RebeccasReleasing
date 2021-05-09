package objects.characters.living;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.Game;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.IFacing;
import objects.characters.collision.CollisionDetector;

public abstract class LivingObject extends GameObject implements IAnimation, IFacing {

	public Puzzle puzzle;
	private CollisionDetector collisionDetector;

	private FACING facing;
	protected boolean[] watching = new boolean[4];
	private boolean flagX, flagY;

	protected boolean isPushed;
	protected int pushTime = 10;

	public LivingObject(int x, int y, OBJECTID objectid) {
		super(true, x, y, objectid);

		watching[FACING.DOWN.getNum()] = true;
		facing = FACING.DOWN;
		collisionDetector = new CollisionDetector(this);
	}

	// state

	@Override
	public FACING getFacing() {
		return facing;
	}

	@Override
	public void setFacing(FACING facing) {
		resetWatchingDirection();
		watching[facing.getNum()] = true;
		this.facing = facing;
	}

	public CollisionDetector getCollisionDetector() {
		return collisionDetector;
	}

	public boolean isPushed() {
		return isPushed;
	}

	public boolean isPlayer() {
		return getId() == OBJECTID.PLAYER;
	}

	public boolean isPlayerActive() {

		if (Conductor.getState() == STATE.LEVEL || Conductor.getState() == STATE.CHATTING)
			return true;
		else {
			setMotionless();
			return false;
		}
	}

	// behavior

	protected void livingTickBehavior(boolean canMoveIfPlayerChatting) {

		boolean flag = true;
		if (!canMoveIfPlayerChatting && Conductor.getState() == STATE.CHATTING)
			flag = false;

		if (!isPushed)
			updateWatchingDirection();

		if (isPlayerActive() && flag) {
			velocity();
			pushTimer();
		}
		collisionDetector.update();
	}

	protected void pushTimer() {
		if (isPushed) {
			if (pushTime > 0)
				pushTime--;
			else {
				isPushed = false;
				pushTime = 10;
				setMotionless();
			}
		}
	}

	private void resetWatchingDirection() {
		watching[FACING.LEFT.getNum()] = false;
		watching[FACING.RIGHT.getNum()] = false;
		watching[FACING.UP.getNum()] = false;
		watching[FACING.DOWN.getNum()] = false;
	}

	// hard to complexe, but make the animation fluid and intuitive :
	// he the player start to move a direction but then goes diagonaly
	// (like to adjust), the sprite wont update as the main direction is
	// the first called, but it will if the main is finnaly abandon.
	protected void updateWatchingDirection() {
		if (isMotionlessbyX())
			flagX = false;
		if (isMotionlessbyY())
			flagY = false;

		if (!flagY && velX < 0) {
			resetWatchingDirection();
			watching[FACING.LEFT.getNum()] = true;
			facing = FACING.LEFT;
			flagX = true;
		}
		if (!flagY && velX > 0) {
			resetWatchingDirection();
			watching[FACING.RIGHT.getNum()] = true;
			facing = FACING.RIGHT;
			flagX = true;
		}

		if (!flagX && velY < 0) {
			resetWatchingDirection();
			watching[FACING.UP.getNum()] = true;
			facing = FACING.UP;
			flagY = true;
		}
		if (!flagX && velY > 0) {
			resetWatchingDirection();
			watching[FACING.DOWN.getNum()] = true;
			facing = FACING.DOWN;
			flagY = true;
		}

	}

	public void pushed(int direction) {
		if (!isPushed) {
			isPushed = true;
			SoundTask.playSound(SoundBank.getSound(SoundBank.push));
			if (isPlayer())
				World.gui.removeHp();
			if (direction == FACING.LEFT.getNum())
				velX = -Size.TILE / 5;
			if (direction == FACING.RIGHT.getNum())
				velX = Size.TILE / 5;
			if (direction == FACING.UP.getNum())
				velY = -Size.TILE / 5;
			if (direction == FACING.DOWN.getNum())
				velY = Size.TILE / 5;
		}
		else setMotionless();
	}

	// design

	@Override
	public void render(Graphics g) {

		drawHitbox(g);
	}

	@Override
	protected void drawHitbox(Graphics g) {
		if (Game.isDebugMode()) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.white);
			g2d.draw(getBounds());
			g2d.draw(getBoundsTop());
			g2d.draw(getBoundsLeft());
			g2d.draw(getBoundsRight());
		}
	}

	// collision

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
