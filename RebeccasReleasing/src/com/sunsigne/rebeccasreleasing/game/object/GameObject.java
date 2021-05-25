package com.sunsigne.rebeccasreleasing.game.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.system.handler.IRender;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.living.PlayerObject;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.TextureBank;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public abstract class GameObject implements ITick, IRender {

	public GameObject(boolean cameraDependant, LAYER layer, int x, int y) {
		this.x = x;
		this.y = y;
		initX = x;
		initY = y;

		w = Size.TILE;
		h = Size.TILE;

		this.cameraDependant = cameraDependant;
		this.layer = layer;
	}

	public boolean isPlayer() {
		return (this instanceof PlayerObject);
	}

	////////// POSITION ////////////

	protected int x, y;
	protected int initX, initY;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	protected int miniX, miniY;

	public int getMiniX() {
		return miniX;
	}

	public int getMiniY() {
		return miniY;
	}

	////////// SIZE ////////////

	protected int w, h;

	public int getWitdh() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	public int[] getRect() {
		int[] rect = new int[4];
		rect[0] = getBounds().x;
		rect[1] = getBounds().y;
		rect[2] = getBounds().width;
		rect[3] = getBounds().height;
		return rect;
	}

	public Rectangle getBounds() {
		return new Rectangle(x + miniX, y + miniY, w, h);
	}

	////////// VELOCICY ////////////

	protected int velX, velY;

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public boolean isMotionless() {
		return isMotionlessbyX() && isMotionlessbyY();
	}

	public boolean isMotionlessbyX() {
		return velX == 0;
	}

	public boolean isMotionlessbyY() {
		return velY == 0;
	}

	public void setMotionless() {
		velX = 0;
		velY = 0;
	}

	////////// TICK ////////////

	protected void velocity() {
		x = x + velX;
		y = y + velY;
	}

	////////// RENDER ////////////

	protected TextureBank texture = TextureBank.getInstance();
	private boolean cameraDependant;
	private LAYER layer;

	@Override
	public boolean isCameraDependant() {
		return cameraDependant;
	}

	@Override
	public LAYER getLayer() {
		return layer;
	}

	public void drawHitbox(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		if (getBounds() != null)
			g2d.draw(getBounds());
	}

}
