package com.sunsigne.rebeccasreleasing.toverify.game.objects.living;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.CollisionDetector;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionDetection;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public abstract class LivingObject extends GameObject implements IAnimation, ICollisionDetection {

	public Puzzle puzzle;

	private DIRECTION facing;
	protected boolean[] watching = new boolean[4];
	private boolean flagX, flagY;

	protected boolean isPushed;
	protected int pushTime = 10;

	public LivingObject(int x, int y) {
		super(true, LAYER.WOLRD_GUI_PUZZLE, x, y);

		watching[DIRECTION.DOWN.getNum()] = true;
		facing = DIRECTION.DOWN;
	}

	// state


	public DIRECTION getFacing() {
		return facing;
	}


	public void setFacing(DIRECTION facing) {
		resetWatchingDirection();
		watching[facing.getNum()] = true;
		this.facing = facing;
	}

	public boolean isPushed() {
		return isPushed;
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
		watching[DIRECTION.LEFT.getNum()] = false;
		watching[DIRECTION.RIGHT.getNum()] = false;
		watching[DIRECTION.UP.getNum()] = false;
		watching[DIRECTION.DOWN.getNum()] = false;
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
			watching[DIRECTION.LEFT.getNum()] = true;
			facing = DIRECTION.LEFT;
			flagX = true;
		}
		if (!flagY && velX > 0) {
			resetWatchingDirection();
			watching[DIRECTION.RIGHT.getNum()] = true;
			facing = DIRECTION.RIGHT;
			flagX = true;
		}

		if (!flagX && velY < 0) {
			resetWatchingDirection();
			watching[DIRECTION.UP.getNum()] = true;
			facing = DIRECTION.UP;
			flagY = true;
		}
		if (!flagX && velY > 0) {
			resetWatchingDirection();
			watching[DIRECTION.DOWN.getNum()] = true;
			facing = DIRECTION.DOWN;
			flagY = true;
		}

	}

	public void pushed(int direction) {
		if (!isPushed) {
			isPushed = true;
			new SoundTask().playSound(SoundBank.HIT_MEDIUM);
			if (isPlayer())
				World.gui.removeHp();
			if (direction == DIRECTION.LEFT.getNum())
				velX = -Size.TILE / 5;
			if (direction == DIRECTION.RIGHT.getNum())
				velX = Size.TILE / 5;
			if (direction == DIRECTION.UP.getNum())
				velY = -Size.TILE / 5;
			if (direction == DIRECTION.DOWN.getNum())
				velY = Size.TILE / 5;
		} else
			setMotionless();
	}

	// design

	@Override
	public void render(Graphics g) {

		drawHitbox(g);
	}

	@Override
	public void drawHitbox(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		g2d.draw(getBounds());
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsRight());
	}

	// collision

	public Rectangle getBoundsDown() {
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
	
	////////// COLLISION ////////////
	
	private CollisionDetector collisionDetector = new CollisionDetector(this);

	@Override
	public CollisionDetector getCollisionDetector() {
		return collisionDetector;
	}
}
