package objects.world.decor;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public class Water extends GameObject implements ICollision {

	public Water(int x, int y) {
		super(true, x, y, OBJECTID.DECOR);

		// this item is technically 2-tile-height
		// but its perspective makes its hitbox 1-tile-height
	}

	// behavior

	@Override
	public void tick() {

	}

	// design

	@Override
	public void render(Graphics g) {

		int h0 = 2 * Size.TILE;

		g.drawImage(texture.decor_tall[1], x, y, w, h0, null);
		drawHitbox(g);
	}

	// collision

	@Override
	public void collision(LivingObject living) {
		living.getCollisionDetector().collidingBehavior(true, this, null);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

}
