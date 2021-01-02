package objects.world.decor;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.main.Size;

import objects.FacingObject;
import objects.OBJECTID;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public class Couch extends FacingObject implements ICollision {

	private boolean single, dual, trio;

	public Couch(int x, int y, boolean facingLeft, boolean horizontal, int lenght) {
		super(x, y, facingLeft, horizontal, OBJECTID.WALL);

		w = Size.TILE;
		h = Size.TILE;

		if (lenght == 1)
			setSingle();
		if (lenght == 2)
			setDual();
		if (lenght == 3)
			setTrio();
	}

	// state

	private void setSingle() {
		this.horizontal = true;
		this.single = true;
		this.dual = false;
		this.trio = false;
		w = Size.TILE;
		h = Size.TILE;
	}

	private void setDual() {
		this.single = false;
		this.dual = true;
		this.trio = false;
		if (horizontal)
			w = 2 * Size.TILE;
		if (!horizontal)
			h = 2 * Size.TILE;
	}

	private void setTrio() {
		this.single = false;
		this.dual = false;
		this.trio = true;
		if (horizontal)
			w = 3 * Size.TILE;
		if (!horizontal)
			h = 3 * Size.TILE;
	}

	@Override
	public boolean isCameraDependant() {
		return true;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		BufferedImage img = paintingCouch();
		g.drawImage(img, x, y, w, h, null);
		drawHitbox(g);
	}

	private BufferedImage paintingCouch() {

		BufferedImage img = null;
		if (horizontal) {
			if (!facingLeft) {
				if (trio)
					img = texture.couch[0];
				if (dual)
					img = texture.couch[3];
				if (single)
					img = texture.couch[6];
			} else {
				if (trio)
					img = texture.couch[1];
				if (dual)
					img = texture.couch[4];
				if (single)
					img = texture.couch[7];
			}
		}
		if (!horizontal) {
			if (!facingLeft) {
				if (trio)
					img = texture.couch[2];
				if (dual)
					img = texture.couch[5];
				if (single)
					img = texture.couch[6];
			} else {
				if (trio)
					img = texture.couch[9];
				if (dual)
					img = texture.couch[8];
				if (single)
					img = texture.couch[7];
			}
		}
		return img;
	}

	@Override
	public void collision(LivingObject living) {

		living.collisionDetector.collidingBehavior(true, this, null);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

}
