package com.sunsigne.rebeccasreleasing.toverify.game.objects.world;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionReaction;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class Stairs extends GameObject implements ICollisionReaction, IInteraction {

	private boolean goesUp;
	private int stairId;

	public Stairs(int x, int y, boolean goesUp, int stairId) {
		super(true, LAYER.WOLRD_GUI_PUZZLE, x, y, OBJECTID.DELETE);

		this.goesUp = goesUp;
		this.stairId = stairId;
	}

	// state
	
	public int getStairId() {
		return stairId;
	}

	public void setStairId(int stairId) {
		this.stairId = stairId;
	}
	
	// behavior

	@Override
	public void doAction() {
		new SoundTask().playSound(SoundBank.NOPE);
		connectionToDualStairs();
	}

	private void connectionToDualStairs() {
		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant(), getLayer());
		for (GameObject tempObject : list) {
			if (tempObject instanceof Stairs)
			{
				Stairs tempStairs = (Stairs) tempObject;
				if(tempStairs.getStairId() == getStairId() && tempStairs != this)
					teleportPlayer(tempStairs);
			}
		}
	}

	private void teleportPlayer(Stairs dualStairs) {
		HandlerObject.getInstance().getPlayer().setX(dualStairs.getX());
		HandlerObject.getInstance().getPlayer().setY(dualStairs.getY());
	}

	@Override
	public void tick() {
	}

	// design

	@Override
	public void render(Graphics g) {

		BufferedImage img = goesUp ? texture.decor_small[3] : texture.decor_small[4];
		g.drawImage(img, x, y, w, h, null);
		renderingText(g);
	}

	// collision

	private void renderingText(Graphics g) {
		if (HandlerObject.getInstance().getPlayer().getInteraction() == this) {
			String text = goesUp ? "[E] Monter" : "[E] Descendre";
			Font font = new Font("arial", 1, Size.TILE / 3);
			g.setFont(font);
			g.setColor(Color.yellow);
			g.drawString(text, x - Size.TILE / 3, y - Size.TILE / 2);
		}
	}

	@Override
	public void collidingReaction(GameObject collidingObject) {

		if (collidingObject.isPlayer()) {
			if (collidingObject.getBounds().intersects(getBounds()))
				HandlerObject.getInstance().getPlayer().setInteraction(this);
		}
	}

	@Override
	public Rectangle getBounds() {

		int size = Size.TILE / 3;
		return new Rectangle(x + size, y + size, size, size);
	}


}