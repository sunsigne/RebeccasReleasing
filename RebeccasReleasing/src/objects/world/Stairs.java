package objects.world;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.GameObject;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public class Stairs extends GameObject implements ICollision, IInteraction {

	private boolean goesUp;
	private int stairId;

	public Stairs(int x, int y, boolean goesUp, int stairId) {
		super(true, 0, x, y, OBJECTID.STAIRS);

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
		SoundTask.playSound(SoundBank.getSound(SoundBank.nope));
		connectionToDualStairs();
	}

	private void connectionToDualStairs() {
		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant(), getCameraLayer());
		for (GameObject tempObject : list) {
			if (tempObject.getId() == OBJECTID.STAIRS)
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
	public void collision(LivingObject living) {
		if (living.isPlayer()) {
			if (living.getBounds().intersects(getBounds()))
				HandlerObject.getInstance().getPlayer().setInteraction(this);
		}
	}

	@Override
	public Rectangle getBounds() {

		int size = Size.TILE / 3;
		return new Rectangle(x + size, y + size, size, size);
	}


}