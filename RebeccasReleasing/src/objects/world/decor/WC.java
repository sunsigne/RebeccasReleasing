package objects.world.decor;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

@Todo("redesign")
public class WC extends GameObject implements ICollision  {

	public WC(int x, int y) {
		super(true, x, y, OBJECTID.DECOR);
		
		h = Size.TILE / 4;
		w = Size.TILE / 2;
		miniX = w/2;
	}
	
	// behavior

	@Override
	public void tick() {

	}
	
	// design

	@Override
	public void render(Graphics g) {

		int w0 = Size.TILE;
		int h0 = Size.TILE;
		
		g.drawImage(texture.decor_small[2], x, y, w0, h0, null);
		drawHitbox(g);
	}
	
	// collision
	
	@Override
	public void collision(LivingObject living) {
		living.getCollisionDetector().collidingBehaviorThinDecor(this);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x + miniX, y, w, h);
	}


}
