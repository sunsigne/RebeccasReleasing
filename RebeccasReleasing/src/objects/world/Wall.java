package objects.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public class Wall extends GameObject implements ICollision {

	public Wall(int x, int y) {
		super(true, x, y, OBJECTID.WALL);
	}

	// behavior
	
	@Override
	public void tick() {
	}

	// design
	
	@Override
	public void render(Graphics g) {

		g.drawImage(texture.decor_wall[0][0], x, y, w, h, null);
		drawHitbox(g);
	}
	
	// collision

	@Override
	public void collision(LivingObject living)
	{
		living.getCollisionDetector().collidingBehavior(true, this, null);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}	

}
