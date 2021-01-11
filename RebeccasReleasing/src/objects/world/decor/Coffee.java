package objects.world.decor;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public class Coffee extends GameObject implements ICollision  {

	public Coffee(int x, int y) {
		super(x, y, OBJECTID.DECOR, true);

		w = Size.TILE;
		h = 2 * Size.TILE;
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

		g.drawImage(texture.dispenser[1], x, y, w, h, null);
		drawHitbox(g);
	}

	@Override
	public void collision(LivingObject living) {
		
	}
	
	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

	

}
